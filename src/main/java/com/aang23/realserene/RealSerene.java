package com.aang23.realserene;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.ModList;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import com.aang23.realserene.events.DaytimeChangeListener;
import com.aang23.realserene.events.SeasonChangeListener;
import com.aang23.realserene.commands.RealSereneCommand;
import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.timers.SeasonsTimer;
import com.aang23.realserene.timers.WeatherTimer;
import com.aang23.realserene.utils.TimeUtils;
import java.util.Timer;
import com.aang23.realserene.events.SeasonChangeListener;
import com.aang23.realserene.utils.TimeUtils;
import com.aang23.realserene.events.DaytimeChangeListener;
import com.aang23.realserene.commands.RealSereneCommand;
import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.timers.*;
import net.minecraft.world.level.Level;

@Mod(RealSerene.MODID)
public class RealSerene {
    public static final String MODID = "realserene";
    public static final String NAME = "Real Serene Seasons";
    public static final String VERSION = "1.5";

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        System.out.println("Setting up RealSerene...");
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        RealSereneCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();

        if (RealSereneSettings.realDayTime.get()) {
            System.out.println("Registering event for RealDayTime...");
            MinecraftForge.EVENT_BUS.register(new DaytimeChangeListener());
            server.getLevel(Level.OVERWORLD).getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, server);

        } else {
            server.getLevel(Level.OVERWORLD).getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(true, server);
        }

        if (ModList.get().isLoaded("sereneseasons") && RealSereneSettings.realSeasonsCycle.get()) {
            System.out.println("Registering event for RealSeasonsCycle...");
            MinecraftForge.EVENT_BUS.register(new SeasonChangeListener());
            Timer timer = new Timer();
            timer.schedule(new SeasonsTimer(), 0, RealSereneSettings.real_seasons_timing.get());
        }

        if (RealSereneSettings.realVanillaWeatherCycle.get()) {
            System.out.println("Registering timer for RealVanillaWeatherCycle...");
            Timer timer = new Timer();
            timer.schedule(new WeatherTimer(), 0, RealSereneSettings.real_vanilla_weather_timing.get());
        }
    }

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        MinecraftServer server = event.getServer();

        TimeUtils.syncValue = RealSereneSettings.dayTimeSyncValue.get();

        if (RealSereneSettings.realVanillaWeatherCycle.get()) {
           server.getLevel(Level.OVERWORLD).getGameRules().getRule(GameRules.RULE_WEATHER_CYCLE).set(false, server);
        } else {
            server.getLevel(Level.OVERWORLD).getGameRules().getRule(GameRules.RULE_WEATHER_CYCLE).set(true, server);
        }
    }
}
