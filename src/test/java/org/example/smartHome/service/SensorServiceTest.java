package org.example.smartHome.service;

import org.example.smartHome.model.SensorData;
import org.example.smartHome.repository.SensorDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for SensorService class.
 * Verifies adding, querying, and retrieving latest sensor readings.
 */
@ExtendWith(MockitoExtension.class)
class SensorServiceTest {

    // Mock repository to simulate DynamoDB
    @Mock
    private SensorDataRepository repo;

    // Injects mock repository into SensorService
    @InjectMocks
    private SensorService service;

    private SensorData mockData;

    @BeforeEach
    void setup() {
        // Create a mock sensor data reading before each test
        mockData = new SensorData();
        mockData.setDeviceId("device-123");
        mockData.setSensorType("Temperature");
        mockData.setValue(28.5);
        mockData.setTimestamp("2025-10-04T10:00:00Z");
    }

    // TEST 1: Add a new sensor reading
    @Test
    void testAddReading() {
        // repo.save() should be called once without exceptions
        doNothing().when(repo).save(any(SensorData.class));

        // Call method under test
        service.addReading("device-123", "Temperature", 28.5, 3600L);

        // Verify that repo.save() was invoked once
        verify(repo, times(1)).save(any(SensorData.class));
    }

    // TEST 2: Query range between two timestamps
    @Test
    void testQueryRange() {
        // Mock data returned from DynamoDB
        when(repo.queryRange("device-123", "2025-10-04T00:00:00Z", "2025-10-04T23:59:00Z"))
                .thenReturn(List.of(mockData));

        // Call method
        List<SensorData> result = service.queryRange("device-123",
                "2025-10-04T00:00:00Z", "2025-10-04T23:59:00Z");

        // Assertions
        assertEquals(1, result.size(), "Should return one record");
        assertEquals("Temperature", result.get(0).getSensorType());
        verify(repo, times(1)).queryRange(anyString(), anyString(), anyString());
    }

    // TEST 3: Get latest N readings for a device
    @Test
    void testGetLatest() {
        // Mock latest readings
        when(repo.getLatest("device-123", 3)).thenReturn(List.of(mockData));

        // Call method
        List<SensorData> result = service.getLatest("device-123", 3);

        // Assertions
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(28.5, result.get(0).getValue());
        verify(repo, times(1)).getLatest("device-123", 3);
    }

    // TEST 4: Query range returns empty list
    @Test
    void testQueryRange_NoResults() {
        // Simulate no readings found
        when(repo.queryRange(anyString(), anyString(), anyString()))
                .thenReturn(List.of());

        // Call method
        List<SensorData> result = service.queryRange("device-123",
                "2025-10-04T00:00:00Z", "2025-10-04T23:59:00Z");

        // Assertions
        assertTrue(result.isEmpty(), "Expected empty list when no readings found");
        verify(repo, times(1)).queryRange(anyString(), anyString(), anyString());
    }

    // TEST 5: Get latest returns empty list
    @Test
    void testGetLatest_NoResults() {
        // Simulate no recent readings
        when(repo.getLatest("device-123", 5)).thenReturn(List.of());

        // Call method
        List<SensorData> result = service.getLatest("device-123", 5);

        // Assertions
        assertNotNull(result);
        assertTrue(result.isEmpty(), "Expected empty list for no latest readings");
        verify(repo, times(1)).getLatest("device-123", 5);
    }
}
