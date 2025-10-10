package org.example.smartHome.service;

import org.example.smartHome.model.Customer;
import org.example.smartHome.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for CustomerService class.
 * Uses Mockito to mock database repository calls.
 */
@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository repo;  // mock DynamoDB layer

    @InjectMocks
    private CustomerService service;  // injects mock repo into service

    private Customer mockCustomer;

    @BeforeEach
    void setup() {
        mockCustomer = new Customer("John Doe", "johny@gmail.com", "Pass@123");
    }

    // TEST 1: Successful registration of new customer
    @Test
    void testRegisterCustomerSuccess() {
        // repo.save() is called without errors
        doNothing().when(repo).save(any(Customer.class));

        boolean result = service.registerCustomer("John", "john@gmail.com", "Pass@123");

        assertTrue(result, "Registration should succeed");
        verify(repo, times(1)).save(any(Customer.class)); // verify save called once
    }

    // TEST 2: Exception during registration (simulate DynamoDB failure)
    @Test
    void testRegisterCustomerFailure() {
        // Simulate exception from repo.save()
        doThrow(new RuntimeException("DB error")).when(repo).save(any(Customer.class));

        boolean result = service.registerCustomer("John", "john@gmail.com", "Pass@123");

        assertFalse(result, "Registration should fail when exception occurs");
        verify(repo, times(1)).save(any(Customer.class));
    }

    // TEST 3: Successful login (password correct)
    @Test
    void testLoginSuccess() {
        boolean result = service.login("john@gmail.com", "Pass@123", mockCustomer);

        assertTrue(result, "Login should succeed with correct password");
    }

    // TEST 4: Invalid password (password mismatch)
    @Test
    void testLoginInvalidPassword() {
        boolean result = service.login("john@gmail.com", "WrongPass", mockCustomer);

        assertFalse(result, "Login should fail when password is incorrect");
    }

    // TEST 5: Null customer (email not found)
    @Test
    void testLoginCustomerNotFound() {
        boolean result = service.login("john@gmail.com", "Pass@123", null);

        assertFalse(result, "Login should fail when customer does not exist");
    }


}
