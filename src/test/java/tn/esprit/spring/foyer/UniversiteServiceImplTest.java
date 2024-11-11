package tn.esprit.spring.foyer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.tpfoyer17.entities.Universite;
import tn.esprit.tpfoyer17.repositories.UniversiteRepository;
import tn.esprit.tpfoyer17.services.interfaces.IUniversiteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UniversiteServiceImplTest {

    @Mock
    private UniversiteRepository universiteRepository;

    @InjectMocks
    private IUniversiteService universiteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllUniversites() {
        List<Universite> mockUniversites = new ArrayList<>();
        when(universiteRepository.findAll()).thenReturn(mockUniversites);

        List<Universite> result = universiteService.retrieveAllUniversities();

        assertEquals(mockUniversites, result);
        verify(universiteRepository, times(1)).findAll();
    }

    @Test
    void testRetrieveUniversite() {
        Long universiteId = 1L;
        Universite mockUniversite = new Universite();
        when(universiteRepository.findById(universiteId)).thenReturn(Optional.of(mockUniversite));

        Universite result = universiteService.retrieveUniversity(universiteId);

        assertEquals(mockUniversite, result);
        verify(universiteRepository, times(1)).findById(universiteId);
    }

    @Test
    void testAddUniversite() {
        Universite universite = new Universite();
        when(universiteRepository.save(universite)).thenReturn(universite);

        Universite result = universiteService.addUniversity(universite);

        assertEquals(universite, result);
        verify(universiteRepository, times(1)).save(universite);
    }

    @Test
    void testModifyUniversite() {
        Universite universite = new Universite();
        when(universiteRepository.save(universite)).thenReturn(universite);

        Universite result = universiteService.updateUniversity(universite);

        assertEquals(universite, result);
        verify(universiteRepository, times(1)).save(universite);
    }

    @Test
    void testRemoveUniversite() {
        Long universiteId = 1L;

        universiteService.desaffecterFoyerAUniversite(universiteId);

        verify(universiteRepository, times(1)).deleteById(universiteId);
    }
}
