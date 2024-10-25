package tn.esprit.tpfoyer17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.tpfoyer17.controllers.UniversiteController;
import tn.esprit.tpfoyer17.entities.Universite;
import tn.esprit.tpfoyer17.services.interfaces.IUniversiteService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class UniversiteControllerTest {

    @Mock
    IUniversiteService universiteService;

    @InjectMocks
    UniversiteController universiteController;

    Universite mockUniversity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        // Initialize mock data
        mockUniversity = Universite.builder()
                .idUniversite(1L)
                .nomUniversite("Test University")
                .adresse("123 Test St.")
                .foyer(null)
                .build();
    }

    @Test
    public void testRetrieveAllUniversities() {
        // Arrange
        List<Universite> mockUniversities = Arrays.asList(mockUniversity);
        when(universiteService.retrieveAllUniversities()).thenReturn(mockUniversities);

        List<Universite> result = universiteController.retrieveAllUniversities();

        assertEquals(1, result.size());
        assertEquals("Test University", result.get(0).getNomUniversite());
        verify(universiteService, times(1)).retrieveAllUniversities();
    }

    @Test
    public void testAddUniversity() {
        // Arrange
        when(universiteService.addUniversity(any(Universite.class))).thenReturn(mockUniversity);

        Universite result = universiteController.addUniversity(mockUniversity);

        assertEquals("Test University", result.getNomUniversite());
        verify(universiteService, times(1)).addUniversity(any(Universite.class));
    }

    @Test
    public void testUpdateUniversity() {
        when(universiteService.updateUniversity(any(Universite.class))).thenReturn(mockUniversity);

        Universite result = universiteController.updateUniversity(mockUniversity);

        assertEquals("Test University", result.getNomUniversite());
        verify(universiteService, times(1)).updateUniversity(any(Universite.class));
    }

    @Test
    public void testRetrieveUniversity() {
        when(universiteService.retrieveUniversity(anyLong())).thenReturn(mockUniversity);

        Universite result = universiteController.retrieveUniversity(1L);

        assertEquals(1L, result.getIdUniversite());
        assertEquals("Test University", result.getNomUniversite());
        verify(universiteService, times(1)).retrieveUniversity(anyLong());
    }

    @Test
    public void testAffecterFoyerAUniversite() {
        when(universiteService.affecterFoyerAUniversite(anyLong(), anyString())).thenReturn(mockUniversity);

        Universite result = universiteController.affecterFoyerAUniversite(1L, "Test University");

        assertEquals("Test University", result.getNomUniversite());
        verify(universiteService, times(1)).affecterFoyerAUniversite(anyLong(), anyString());
    }

    @Test
    public void testDesaffecterFoyerAUniversite() {
        when(universiteService.desaffecterFoyerAUniversite(anyLong())).thenReturn(mockUniversity);

        Universite result = universiteController.desaffecterFoyerAUniversite(1L);

        assertEquals("Test University", result.getNomUniversite());
        verify(universiteService, times(1)).desaffecterFoyerAUniversite(anyLong());
    }
}

