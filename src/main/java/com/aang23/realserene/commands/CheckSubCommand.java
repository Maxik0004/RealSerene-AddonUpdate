package com.aang23.realserene.commands;

import net.minecraft.server.MinecraftServer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import com.aang23.realserene.timers.SeasonsTimer;
import com.aang23.realserene.utils.TimeUtils;

public class CheckSubCommand {
    public static void call(MinecraftServer server, CommandSourceStack source, String[] args) {
        if (args.length > 1) {
            switch (args[1]) {
                case "list":
                    source.sendSuccess(() -> Component.literal("Available checks: sync, seasonsync"), false);
                    break;
                case "sync":
                    if (args.length > 2) {
                        try {
                            int value = Integer.parseInt(args[2]);
                            source.sendSuccess(() -> Component.literal("Synced value: " + TimeUtils.syncToReal(value)), false);
                        } catch (NumberFormatException e) {
                            source.sendSuccess(() -> Component.literal("Error: Argument must be a valid integer."), false);
                        }
                    } else {
                        source.sendSuccess(() -> Component.literal("Usage: /realserene check sync [value]"), false);
                    }
                    break;
                case "seasonsync":
                    SeasonsTimer.runOnce();
                    source.sendSuccess(() -> Component.literal("Synced the season"), false);
                    break;
                default:
                    source.sendSuccess(() -> Component.literal("Unknown check! Use '/realserene check list' for a list."), false);
            }
        } else {
            source.sendSuccess(() -> Component.literal("Please specify a check to perform! Use '/realserene check list' for a list."), false);
        }
    }
}