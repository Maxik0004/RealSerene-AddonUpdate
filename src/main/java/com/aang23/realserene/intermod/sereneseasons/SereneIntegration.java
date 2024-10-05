package com.aang23.realserene.intermod.sereneseasons;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import sereneseasons.api.season.Season;
import sereneseasons.handler.season.SeasonHandler;
import sereneseasons.season.SeasonSavedData;
import sereneseasons.season.SeasonTime;
import net.minecraftforge.server.ServerLifecycleHooks;

public class SereneIntegration {
    public static void setSeason(ResourceKey<Level> worldKey, Season.SubSeason newSeason) {
        MinecraftServer minecraftServer = ServerLifecycleHooks.getCurrentServer();
        ServerLevel serverWorld = minecraftServer.getLevel(worldKey);

        if (serverWorld != null) {
            SeasonSavedData seasonData = SeasonHandler.getSeasonSavedData(serverWorld);
            seasonData.seasonCycleTicks = SeasonTime.ZERO.getSubSeasonDuration() * newSeason.ordinal();
            seasonData.setDirty(); // Mark the data as dirty to ensure it's saved.
            SeasonHandler.sendSeasonUpdate(serverWorld);
        } else {
            System.out.println("World not found for key: " + worldKey.location().toString());
        }
    }
}
