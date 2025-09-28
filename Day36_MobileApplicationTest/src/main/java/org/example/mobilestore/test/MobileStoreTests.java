package org.example.mobilestore.test;


// HOME TASK
//write Junit & Mockito testcases to verify mobileController and mobileServiceImplclasses.

//import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.example.mobilestore.controller.MobileController;
import org.example.mobilestore.dto.MobileDTO;
import org.example.mobilestore.entity.Mobile;
import org.example.mobilestore.exception.ResourceNotFoundException;
import org.example.mobilestore.repo.MobileRepository;
import org.example.mobilestore.service.MobileService;
import org.example.mobilestore.service.impl.MobileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MobileStoreTests {

    @Mock
    private MobileRepository mobileRepository;

    private MobileService mobileService;

    private MobileController mobileController;

    @BeforeEach
    void setup() {
        //MockitoAnnotations.openMocks(this);
        MockitoAnnotations.initMocks(this);
        mobileService = new MobileServiceImpl(mobileRepository);
        mobileController = new MobileController(mobileService);
    }

    // Helper to create Mobile entity
    private Mobile createMobile(Long id) {
        return new Mobile(id, "iPhone", 999.99, "Apple", "128GB", "6GB", "A14");
    }

    // Helper to create MobileDTO
    private MobileDTO createMobileDTO(Long id) {
        return new MobileDTO(id, "iPhone", 999.99, "Apple", "128GB", "6GB", "A14");
    }

    // ----- Service Layer Tests -----

    @Test
    void testGetMobileById_whenMobileExists() {
        Mobile mobile = createMobile(1L);
        when(mobileRepository.findById(1L)).thenReturn(Optional.of(mobile));

        MobileDTO dto = mobileService.getmobileById(1L);

        assertNotNull(dto);
        assertEquals("iPhone", dto.getName());
        verify(mobileRepository).findById(1L);
    }

    @Test
    void testGetMobileById_whenMobileNotFound() {
        when(mobileRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            mobileService.getmobileById(1L);
        });
        verify(mobileRepository).findById(1L);
    }

    @Test
    void testCreateMobile() {
        Mobile mobile = createMobile(null);
        Mobile savedMobile = createMobile(1L);

        when(mobileRepository.save(any(Mobile.class))).thenReturn(savedMobile);

        MobileDTO dtoToCreate = createMobileDTO(null);
        MobileDTO createdDto = mobileService.createmobile(dtoToCreate);

        assertNotNull(createdDto);
        assertEquals(1L, createdDto.getId());
        verify(mobileRepository).save(any(Mobile.class));
    }

    @Test
    void testDeleteMobile_whenMobileExists() {
        when(mobileRepository.existsById(1L)).thenReturn(true);
        doNothing().when(mobileRepository).deleteById(1L);

        boolean result = mobileService.deletemobile(1L);

        assertTrue(result);
        verify(mobileRepository).existsById(1L);
        verify(mobileRepository).deleteById(1L);
    }

    @Test
    void testDeleteMobile_whenMobileDoesNotExist() {
        when(mobileRepository.existsById(1L)).thenReturn(false);

        assertThrows(ResourceNotFoundException.class, () -> {
            mobileService.deletemobile(1L);
        });
        verify(mobileRepository).existsById(1L);
        verify(mobileRepository, never()).deleteById(anyLong());
    }

    // ----- Controller Layer Tests -----

    @Test
    void testCreateMobile_controller() {
        MobileDTO dtoToCreate = createMobileDTO(null);
        MobileDTO createdDto = createMobileDTO(1L);

        // Mock service method
        MobileService mockService = mock(MobileService.class);
        when(mockService.createmobile(any(MobileDTO.class))).thenReturn(createdDto);

        MobileController controller = new MobileController(mockService);

        ResponseEntity<MobileDTO> response = controller.createmobile(dtoToCreate);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdDto.getId(), response.getBody().getId());
        verify(mockService).createmobile(dtoToCreate);
    }

    @Test
    void testGetMobileById_controller() {
        MobileDTO existingDto = createMobileDTO(1L);

        MobileService mockService = mock(MobileService.class);
        when(mockService.getmobileById(1L)).thenReturn(existingDto);

        MobileController controller = new MobileController(mockService);

        ResponseEntity<MobileDTO> response = controller.getmobileById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(existingDto.getName(), response.getBody().getName());
        verify(mockService).getmobileById(1L);
    }


    @Test
    void testDeleteMobile_controller() {
        MobileService mockService = mock(MobileService.class);
        when(mockService.deletemobile(1L)).thenReturn(true); // ✅ return value, not doNothing

        MobileController controller = new MobileController(mockService);

        ResponseEntity<Void> response = controller.deletemobile(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(mockService).deletemobile(1L);
    }
}


