package ru.smarthome.temperature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class TemperatureController {

    @GetMapping("/temperature")
    public TemperatureResponse getTemperature(
            @RequestParam String location
    ) {
        return generateTemperature(location, "");
    }

    @GetMapping("/temperature/{sensorId}")
    public TemperatureResponse getTemperatureById(
            @PathVariable String sensorId
    ) {
        return generateTemperature("sensor-" + sensorId, sensorId);
    }

    private TemperatureResponse generateTemperature(
            String location,
            String sensorId
    ) {
        double value = ThreadLocalRandom.current()
                .nextDouble(180, 301) / 10.0;

        return new TemperatureResponse(
                value,
                "C",
                Instant.now(),
                location,
                "active",
                sensorId,
                "temperature",
                "Симуляция температуры в " + location
        );
    }
}