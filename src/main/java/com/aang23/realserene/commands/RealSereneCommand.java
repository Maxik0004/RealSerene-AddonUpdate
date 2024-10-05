package com.aang23.realserene.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;

public class RealSereneCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
            Commands.literal("realserene")
                .then(Commands.argument("action", StringArgumentType.string())
                    .then(Commands.argument("arg1", StringArgumentType.string()) // Дополнительный аргумент
                        .executes(context -> executeCommand(context, StringArgumentType.getString(context, "action"), StringArgumentType.getString(context, "arg1")))
                    )
                    .executes(context -> executeCommand(context, StringArgumentType.getString(context, "action"), null))
                )
        );
    }

    private static int executeCommand(CommandContext<CommandSourceStack> context, String action, String arg1) {
        CommandSourceStack source = context.getSource();
        MinecraftServer server = source.getServer();

        // Создаем массив аргументов для передачи в команды
        String[] args = arg1 != null ? new String[]{arg1} : new String[0];

        switch (action) {
            case "info":
                InfoSubCommand.call(server, source, args);
                break;
            case "check":
                CheckSubCommand.call(server, source, args);
                break;
            case "getw":
                GetWSubCommand.call(server, source, args);
                break;
            default:
                source.sendSuccess(() -> Component.literal("Unknown action: " + action + ". Usage: /realserene <info/check/getw>"), false);
                break;
        }

        return 1;
    }
}
