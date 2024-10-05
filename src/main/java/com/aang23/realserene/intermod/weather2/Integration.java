package com.aang23.realserene.intermod.weather2;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import weather2.weathersystem.WeatherManagerClient;
import weather2.weathersystem.WeatherManagerServer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.OnlyIn;

@Mod.EventBusSubscriber(modid = "realserene", bus = Mod.EventBusSubscriber.Bus.MOD)
public class Integration {
    public static WeatherManagerClient clientWeatherManager;
    public static WeatherManagerServer serverWeatherManager;

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onClientSetup(FMLClientSetupEvent event) {
        initClient();
    }

    @OnlyIn(Dist.CLIENT)
    public static void initClient() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level != null) {
            // Получаем ResourceKey для текущего уровня (мира)
            ResourceKey<Level> worldKey = minecraft.level.dimension();
            clientWeatherManager = new WeatherManagerClient(worldKey);
        }
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        initServer();
    }

    public static void initServer() {
        MinecraftServer server = Minecraft.getInstance().getSingleplayerServer(); // Получаем экземпляр сервера
        if (server != null) {
            ServerLevel serverLevel = server.getLevel(Minecraft.getInstance().level.dimension());
            if (serverLevel != null) {
                serverWeatherManager = new WeatherManagerServer(serverLevel); // Передаем ServerLevel в конструктор
            }
        }
    }
}
