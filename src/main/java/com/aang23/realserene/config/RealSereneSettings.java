package com.aang23.realserene.config;

import com.aang23.realserene.RealSerene;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RealSerene.MODID)
public class RealSereneSettings {

    public static final ForgeConfigSpec spec;
    public static final RealSereneSettings INSTANCE;

    public static ForgeConfigSpec.BooleanValue realDayTime;
    public static ForgeConfigSpec.BooleanValue realSeasonsCycle;
    public static ForgeConfigSpec.BooleanValue realVanillaWeatherCycle;
    public static ForgeConfigSpec.IntValue dayTimeSyncValue;
    public static ForgeConfigSpec.IntValue timeShift;
    public static ForgeConfigSpec.IntValue real_seasons_timing;
    public static ForgeConfigSpec.IntValue real_vanilla_weather_timing;


    // Season configuration fields
    public static ForgeConfigSpec.ConfigValue<String> start_EARLY_SUMMER;
    public static ForgeConfigSpec.ConfigValue<String> stop_EARLY_SUMMER;
    public static ForgeConfigSpec.ConfigValue<String> start_MID_SUMMER;
    public static ForgeConfigSpec.ConfigValue<String> stop_MID_SUMMER;
    public static ForgeConfigSpec.ConfigValue<String> start_LATE_SUMMER;
    public static ForgeConfigSpec.ConfigValue<String> stop_LATE_SUMMER;

    public static ForgeConfigSpec.ConfigValue<String> start_EARLY_AUTUMN;
    public static ForgeConfigSpec.ConfigValue<String> stop_EARLY_AUTUMN;
    public static ForgeConfigSpec.ConfigValue<String> start_MID_AUTUMN;
    public static ForgeConfigSpec.ConfigValue<String> stop_MID_AUTUMN;
    public static ForgeConfigSpec.ConfigValue<String> start_LATE_AUTUMN;
    public static ForgeConfigSpec.ConfigValue<String> stop_LATE_AUTUMN;

    public static ForgeConfigSpec.ConfigValue<String> start_EARLY_WINTER;
    public static ForgeConfigSpec.ConfigValue<String> stop_EARLY_WINTER;
    public static ForgeConfigSpec.ConfigValue<String> start_MID_WINTER;
    public static ForgeConfigSpec.ConfigValue<String> stop_MID_WINTER;
    public static ForgeConfigSpec.ConfigValue<String> start_LATE_WINTER;
    public static ForgeConfigSpec.ConfigValue<String> stop_LATE_WINTER;

    public static ForgeConfigSpec.ConfigValue<String> start_EARLY_SPRING;
    public static ForgeConfigSpec.ConfigValue<String> stop_EARLY_SPRING;
    public static ForgeConfigSpec.ConfigValue<String> start_MID_SPRING;
    public static ForgeConfigSpec.ConfigValue<String> stop_MID_SPRING;
    public static ForgeConfigSpec.ConfigValue<String> start_LATE_SPRING;
    public static ForgeConfigSpec.ConfigValue<String> stop_LATE_SPRING;

    public static ForgeConfigSpec.ConfigValue<String> opm_city_name;
    public static ForgeConfigSpec.ConfigValue<String> opm_country_code;
    public static ForgeConfigSpec.ConfigValue<String> opm_api_key;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        INSTANCE = new RealSereneSettings(builder);
        spec = builder.build();
    }

    private RealSereneSettings(ForgeConfigSpec.Builder builder) {
        builder.push("General");

        realDayTime = builder
            .comment("Enable daytime syncing")
            .define("realDayTime", true);

        timeShift = builder
            .comment("The value used to sync the day")
            .defineInRange("timeShift", 0, Integer.MIN_VALUE, Integer.MAX_VALUE);

        realSeasonsCycle = builder
            .comment("Enable seasons syncing")
            .define("realSeasonsCycle", true);

        realVanillaWeatherCycle = builder
            .comment("Enable Vanilla weather syncing")
            .define("realVanillaWeatherCycle", false);

        dayTimeSyncValue = builder
            .comment("The value used to sync the day")
            .defineInRange("dayTimeSyncValue", 6000, 0, Integer.MAX_VALUE);

        real_vanilla_weather_timing = builder
            .comment("RealVanillaWeatherSync Update Timing")
            .defineInRange("real_vanilla_weather_timing", 5 * 60000, 0, Integer.MAX_VALUE);

        real_seasons_timing = builder
            .comment("RealSeasonsSync Update Timing")
            .defineInRange("real_seasons_timing", 5 * 60000, 0, Integer.MAX_VALUE);

        builder.pop();

        // Weather settings fields
        builder.push("Weather Settings");

        opm_city_name = builder
            .comment("City name for weather API")
            .define("opmCityName", "ВашГород");

        opm_country_code = builder
            .comment("Country code for weather API")
            .define("opmCountryCode", "RU");

        opm_api_key = builder
            .comment("API Key for OpenWeatherMap (обязательно)")
            .define("opmApiKey", ""); // Поле для API ключа пользователя

        builder.pop();

        // Seasons settings fields
        builder.push("Seasons Settings");

        start_EARLY_SUMMER = builder
            .comment("Start date for early summer")
            .define("start_EARLY_SUMMER", "01/06");

        stop_EARLY_SUMMER = builder
            .comment("Stop date for early summer")
            .define("stop_EARLY_SUMMER", "21/06");

        start_MID_SUMMER = builder
            .comment("Start date for mid summer")
            .define("start_MID_SUMMER", "22/06");

        stop_MID_SUMMER = builder
            .comment("Stop date for mid summer")
            .define("stop_MID_SUMMER", "31/07");

        start_LATE_SUMMER = builder
            .comment("Start date for late summer")
            .define("start_LATE_SUMMER", "01/08");

        stop_LATE_SUMMER = builder
            .comment("Stop date for late summer")
            .define("stop_LATE_SUMMER", "31/08");

        // Similarly for Autumn, Winter, and Spring settings...
        start_EARLY_AUTUMN = builder
            .comment("Start date for early autumn")
            .define("start_EARLY_AUTUMN", "01/09");

        stop_EARLY_AUTUMN = builder
            .comment("Stop date for early autumn")
            .define("stop_EARLY_AUTUMN", "21/09");

        start_MID_AUTUMN = builder
            .comment("Start date for mid autumn")
            .define("start_MID_AUTUMN", "22/09");

        stop_MID_AUTUMN = builder
            .comment("Stop date for mid autumn")
            .define("stop_MID_AUTUMN", "31/10");

        start_LATE_AUTUMN = builder
            .comment("Start date for late autumn")
            .define("start_LATE_AUTUMN", "01/11");

        stop_LATE_AUTUMN = builder
            .comment("Stop date for late autumn")
            .define("stop_LATE_AUTUMN", "30/11");

        // Winter
        start_EARLY_WINTER = builder
            .comment("Start date for early winter")
            .define("start_EARLY_WINTER", "01/12");

        stop_EARLY_WINTER = builder
            .comment("Stop date for early winter")
            .define("stop_EARLY_WINTER", "21/12");

        start_MID_WINTER = builder
            .comment("Start date for mid winter")
            .define("start_MID_WINTER", "22/12");

        stop_MID_WINTER = builder
            .comment("Stop date for mid winter")
            .define("stop_MID_WINTER", "31/01");

        start_LATE_WINTER = builder
            .comment("Start date for late winter")
            .define("start_LATE_WINTER", "01/02");

        stop_LATE_WINTER = builder
            .comment("Stop date for late winter")
            .define("stop_LATE_WINTER", "28/02");

        // Spring
        start_EARLY_SPRING = builder
            .comment("Start date for early spring")
            .define("start_EARLY_SPRING", "01/03");

        stop_EARLY_SPRING = builder
            .comment("Stop date for early spring")
            .define("stop_EARLY_SPRING", "21/03");

        start_MID_SPRING = builder
            .comment("Start date for mid spring")
            .define("start_MID_SPRING", "22/03");

        stop_MID_SPRING = builder
            .comment("Stop date for mid spring")
            .define("stop_MID_SPRING", "30/04");

        start_LATE_SPRING = builder
            .comment("Start date for late spring")
            .define("start_LATE_SPRING", "01/05");

        stop_LATE_SPRING = builder
            .comment("Stop date for late spring")
            .define("stop_LATE_SPRING", "31/05");

        builder.pop();
    }

    public static boolean isRealSeasonsCycle() {
        return INSTANCE.realSeasonsCycle.get();
    }

    public static String getApiKey() {
        return INSTANCE.opm_api_key.get(); // Получаем API ключ от пользователя
    }
}
