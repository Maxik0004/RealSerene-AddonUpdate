package com.aang23.realserene.commands;

import net.minecraft.server.MinecraftServer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import com.aang23.realserene.utils.TimeUtils;

public class InfoSubCommand {
    public static void call(MinecraftServer server, CommandSourceStack source, String[] args) {
        if (args.length > 1) {
            switch (args[1]) {
                case "list":
                    source.sendSuccess(() -> Component.literal("Options are: real_daytime, seconds_real_daytime, tick_daytime, synced_tick_daytime, month"), false);
                    break;
                case "real_daytime":
                    source.sendSuccess(() -> Component.literal("The current real daytime is: " + TimeUtils.getHours() + ":" + TimeUtils.getMinutes() + ":" + TimeUtils.getSeconds()), false);
                    break;
                case "seconds_real_daytime":
                    source.sendSuccess(() -> Component.literal("The current real seconds daytime is: " + TimeUtils.getRawSeconds()), false);
                    break;
                case "tick_daytime":
                    source.sendSuccess(() -> Component.literal("The current tick daytime is: " + TimeUtils.getRawTickTime()), false);
                    break;
                case "synced_tick_daytime":
                    source.sendSuccess(() -> Component.literal("The current synced tick daytime is: " + TimeUtils.syncToReal(TimeUtils.getRawTickTime())), false);
                    break;
                case "month":
                    source.sendSuccess(() -> Component.literal("The current month is: " + TimeUtils.getMonth()), false);
                    break;
                default:
                    source.sendSuccess(() -> Component.literal("Unknown info type! Use '/realserene info list' to get a list."), false);
            }
        } else {
            source.sendSuccess(() -> Component.literal("Please specify an info to query! Use '/realserene info list' to get a list."), false);
        }
    }
}