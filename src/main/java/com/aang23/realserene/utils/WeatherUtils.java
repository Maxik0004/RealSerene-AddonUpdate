package com.aang23.realserene.utils;

import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.external.openweathermap.WeatherGetter;

public class WeatherUtils {
    private static boolean raining = false;
    private static boolean thundering = false;

    /**
     * Обновляет состояние погоды на основе данных от WeatherGetter.
     */
    public static void setWeather() {
        // Получаем имя города и код страны из настроек
        String cityName = RealSereneSettings.INSTANCE.opm_city_name.get();
        String countryCode = RealSereneSettings.INSTANCE.opm_country_code.get();

        // Получаем погодное состояние с использованием WeatherGetter
        String weatherCondition = WeatherGetter.getWeather(cityName, countryCode);

        if (weatherCondition == null || weatherCondition.isEmpty()) {
            System.err.println("Не удалось получить данные о погоде.");
            raining = false;
            thundering = false;
            return;
        }

        // Логируем состояние погоды для отладки
        System.out.println("Получено состояние погоды: " + weatherCondition);

        // Определяем состояние дождя и грома
        raining = weatherCondition.toLowerCase().contains("rain") ||
                  weatherCondition.toLowerCase().contains("snow");
        thundering = weatherCondition.toLowerCase().contains("thunderstorm");
    }

    public static boolean isRaining() {
        return raining;
    }

    public static boolean isThundering() {
        return thundering;
    }
}