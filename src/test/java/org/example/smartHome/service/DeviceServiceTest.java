package org.example.smartHome.service;

import org.example.smartHome.model.Customer;
import org.example.smartHome.model.Device;
import org.example.smartHome.repository.DeviceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for DeviceService class.
 * Tests cover device registration, listing, and status toggling.
 * Uses Mockito to mock the DynamoDB repository and static network client.
 */
@ExtendWith(MockitoExtension.class)
class DeviceServiceTest {

    @Mock
    private DeviceRepository repo; // Mock for DynamoDB access

    @InjectMocks
    private DeviceService service; // Injects mock repo into DeviceService

    private Customer customer;
    private Device device;

    @BeforeEach
    void setup() {
        // Create sample customer and device before each test
        customer = new Customer("John Doe", "john@gmail.com", "Pass@123");
        device = new Device(customer.getCustomerId(), "Sony", "TV", "Hall");
    }

    // TEST 1: Successful registration of a device
    @Test
    void testRegisterDevice_Success() {
        // Mock successful save (no exception)
        doNothing().when(repo).save(any(Device.class));

        // Call service method
        Device result = service.registerDevice(customer, "Sony", "TV", "Hall");

        // Assertions
        assertNotNull(result, "Device should be returned after successful registration");
        assertEquals("Sony", result.getModel());
        verify(repo, times(1)).save(any(Device.class)); // save should be called once
    }

    // TEST 2: Failed registration (simulated DB exception)
    @Test
    void testRegisterDevice_Failure() {
        // Simulate DynamoDB failure
        doThrow(new RuntimeException("DB write failed")).when(repo).save(any(Device.class));

        // Call service
        Device result = service.registerDevice(customer, "LG", "AC", "Bedroom");

        // Assert null (service should handle error gracefully)
        assertNull(result, "Expected null when registration fails due to DB error");

        // Verify that save() was still called
        verify(repo, times(1)).save(any(Device.class));
    }

    // TEST 3: List devices for a customer
    @Test
    void testListDevices() {
        // Mock DynamoDB response
        Device device2 = new Device(customer.getCustomerId(), "LG", "AC", "Bedroom");
        when(repo.listByCustomer(customer.getCustomerId())).thenReturn(List.of(device, device2));

        // Call service
        List<Device> result = service.listDevices(customer);

        // Verify correctness
        assertEquals(2, result.size(), "Expected 2 devices returned from repo");
        verify(repo, times(1)).listByCustomer(customer.getCustomerId());
    }

    // TEST 4: Toggle device status - SUCCESS from server
    @Test
    void testChangeDeviceStatus_Success() {
        // Mock static method DeviceNetworkClient.sendCommand()
        try (MockedStatic<org.example.smartHome.network.DeviceNetworkClient> mockNetwork =
                     mockStatic(org.example.smartHome.network.DeviceNetworkClient.class)) {

            // Simulate success response
            mockNetwork.when(() ->
                            org.example.smartHome.network.DeviceNetworkClient.sendCommand(anyString()))
                    .thenReturn("SUCCESS");

            // Mock repo.update() to succeed
            doNothing().when(repo).update(any(Device.class));

            // Call method
            boolean result = service.changeDeviceStatus(device);

            // Assertions
            assertTrue(result, "Device status toggle should succeed");
            assertEquals("ON", device.getStatus(), "Device status should toggle to ON");

            // Verify database update once
            verify(repo, times(1)).update(any(Device.class));

            // Verify network call once
            mockNetwork.verify(() ->
                    org.example.smartHome.network.DeviceNetworkClient.sendCommand(anyString()), times(1));
        }
    }

    // TEST 5: Toggle device status - FAIL (server returns error)
    @Test
    void testChangeDeviceStatus_FailureResponse() {
        try (MockedStatic<org.example.smartHome.network.DeviceNetworkClient> mockNetwork =
                     mockStatic(org.example.smartHome.network.DeviceNetworkClient.class)) {

            // Simulate failure response
            mockNetwork.when(() ->
                            org.example.smartHome.network.DeviceNetworkClient.sendCommand(anyString()))
                    .thenReturn("ERROR");

            // Call service method
            boolean result = service.changeDeviceStatus(device);

            // Assert failure (no update should occur)
            assertFalse(result, "Status toggle should fail due to server error");
            assertEquals("OFF", device.getStatus(), "Device should remain OFF");

            // Verify no database update
            verify(repo, never()).update(any(Device.class));
        }
    }
}
