package com.aang23.realserene.external.openweathermap;

import com.aang23.realserene.config.RealSereneSettings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherGetter {

    public static String getWeather(String city, String country) {
        String apiKey = RealSereneSettings.opm_api_key.get(); // Получаем API ключ
        String endpoint = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&appid=" + apiKey + "&units=metric";

        try {
            // Создаем соединение
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Читаем ответ
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            connection.disconnect();

            // Возвращаем ответ (в формате JSON, который потом можно парсить)
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
