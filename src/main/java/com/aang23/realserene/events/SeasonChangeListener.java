package com.aang23.realserene.events;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.intermod.sereneseasons.SereneIntegration;
import com.aang23.realserene.timers.SeasonsTimer;
import net.minecraftforge.event.TickEvent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;


@Mod.EventBusSubscriber(modid = "RealSerene.MODID")
public class SeasonChangeListener {

    @SubscribeEvent
    public static void onTick(TickEvent.ServerTickEvent event) {
        if (RealSereneSettings.isRealSeasonsCycle()) {
            try {
                ResourceKey<Level> levelKey = Level.OVERWORLD; // Используем Overworld
                SereneIntegration.setSeason(levelKey, SeasonsTimer.season);
            } catch (NullPointerException e) {
                System.out.println("Season not set. Calculating.");
                SeasonsTimer.runOnce();
            }
        }
    }
}