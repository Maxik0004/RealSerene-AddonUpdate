package com.aang23.realserene.commands;

import net.minecraft.server.MinecraftServer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.external.openweathermap.WeatherGetter;

public class GetWSubCommand {
     public static void call(MinecraftServer server, CommandSourceStack source, String[] args)  {
        if (args.length == 3) {
            // Получаем погоду, используя указанные город и страну
            String weatherInfo = WeatherGetter.getWeather(args[1], args[2]);
            source.sendSuccess(() -> Component.literal(weatherInfo), false);
        } else if (args.length == 1) {
            // Получаем погоду по умолчанию (из настроек)
            String defaultWeatherInfo = WeatherGetter.getWeather(
    RealSereneSettings.opm_city_name.get(),
    RealSereneSettings.opm_country_code.get()
);
            source.sendSuccess(() -> Component.literal(defaultWeatherInfo), false);
        } else {
            // Сообщение о неправильном использовании команды
            source.sendSuccess(() -> Component.literal("Usage: /realserene getw [city] [countrycode]"), false);
        }
    }
}