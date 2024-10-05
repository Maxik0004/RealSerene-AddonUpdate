package com.aang23.realserene.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.aang23.realserene.config.RealSereneSettings;
import com.aang23.realserene.utils.TimeUtils;
import com.aang23.realserene.utils.WeatherUtils;
import com.aang23.realserene.RealSerene;

@Mod.EventBusSubscriber(modid = RealSerene.MODID)
public class DaytimeChangeListener {

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            for (ServerLevel world : event.getServer().getAllLevels()) {
                // Используем экземпляр INSTANCE для доступа к полям
                if (RealSereneSettings.INSTANCE.realVanillaWeatherCycle.get()) {
                    // Устанавливаем состояние дождя и грома в мире
                    if (WeatherUtils.isRaining()) {
                        world.setWeatherParameters(1000, 2000, true, true); // Примерно 1000 тактов дождя
                    } else {
                        world.setWeatherParameters(0, 0, false, false); // Прекратить дождь
                    }
                }
                if (RealSereneSettings.INSTANCE.realDayTime.get()) {
                    // Устанавливаем время в мире на основе реального времени
                    world.setDayTime(TimeUtils.syncToReal(TimeUtils.getRawTickTime())); // 24000
                }
            }
        }
    }
}