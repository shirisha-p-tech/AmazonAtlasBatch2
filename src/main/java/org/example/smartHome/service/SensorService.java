package org.example.smartHome.service;

import org.example.smartHome.model.SensorData;
import org.example.smartHome.repository.CustomerRepository;
import org.example.smartHome.repository.SensorDataRepository;

import java.time.Instant;
import java.util.List;

/**
 * Service layer for managing sensor data.
 * Handles adding new readings and querying time-series data.
 */
public class SensorService {
    private final SensorDataRepository repo;

    public SensorService() {
        this.repo = new SensorDataRepository();
    }

    // Overloaded constructor (for tests – allows injecting mocks)
    public SensorService(SensorDataRepository repo) {
        this.repo = repo;
    }


    // Adds a new sensor reading with timestamp and optional TTL
    public void addReading(String deviceId, String type, Double value, Long ttlSeconds) {
        SensorData data = new SensorData();
        data.setDeviceId(deviceId);
        data.setTimestamp(Instant.now().toString());
        data.setSensorType(type);
        data.setValue(value);
        data.setExpiresAt(ttlSeconds); // TTL attribute

        repo.save(data);
    }

    // Queries readings between two timestamps
    public List<SensorData> queryRange(String deviceId, String from, String to) {
        return repo.queryRange(deviceId, from, to);
    }

    // Gets the latest N readings for a device
    public List<SensorData> getLatest(String deviceId, int n) {
        return repo.getLatest(deviceId, n);
    }
}
