package ru.smarthome.temperature;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record TemperatureResponse(
        double value,
        String unit,
        Instant timestamp,
        String location,
        String status,

        @JsonProperty("sensor_id")
        String sensorId,

        @JsonProperty("sensor_type")
        String sensorType,

        String description
) {
}
