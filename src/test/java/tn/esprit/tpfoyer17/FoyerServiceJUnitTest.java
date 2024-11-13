package tn.esprit.tpfoyer17;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.tpfoyer17.entities.Foyer;
import tn.esprit.tpfoyer17.entities.Universite;
import tn.esprit.tpfoyer17.repositories.FoyerRepository;
import tn.esprit.tpfoyer17.repositories.BlocRepository;
import tn.esprit.tpfoyer17.repositories.UniversiteRepository;

import jakarta.persistence.EntityNotFoundException;
import tn.esprit.tpfoyer17.services.impementations.FoyerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(SpringExtension.class)
public class FoyerServiceJUnitTest {

    private static final Logger logger = LoggerFactory.getLogger(FoyerServiceJUnitTest.class); // Logger initialization

    @Mock
    private FoyerRepository foyerRepository;
    @Mock
    private BlocRepository blocRepository;
    @Mock
    private UniversiteRepository universiteRepository;

    @InjectMocks
    private FoyerService foyerService;

    private Foyer foyer;
    private Universite universite;

    @BeforeEach
    public void setUp() {
        logger.info("Setting up the test data..."); // Logging setup
        // Créer un foyer et une université pour les tests
        foyer = Foyer.builder()
                .idFoyer(1L)
                .nomFoyer("Foyer 1")
                .capaciteFoyer(100)
                .build();
        universite = new Universite();
        universite.setNomUniversite("Université 1");
    }

    @Test
    public void testAddFoyer() {
        logger.info("Running testAddFoyer..."); // Log method execution
        when(foyerRepository.save(any(Foyer.class))).thenReturn(foyer);

        Foyer result = foyerService.addFoyer(foyer);

        assertNotNull(result);
        assertEquals(foyer.getNomFoyer(), result.getNomFoyer());
        verify(foyerRepository, times(1)).save(foyer);

        logger.info("testAddFoyer passed."); // Log after test
    }

    @Test
    public void testRetrieveFoyer_Success() {
        logger.info("Running testRetrieveFoyer_Success..."); // Log method execution
        when(foyerRepository.findById(1L)).thenReturn(java.util.Optional.of(foyer));

        Foyer result = foyerService.retrieveFoyer(1L);

        assertNotNull(result);
        assertEquals(foyer.getIdFoyer(), result.getIdFoyer());
        verify(foyerRepository, times(1)).findById(1L);

        logger.info("testRetrieveFoyer_Success passed."); // Log after test
    }

    @Test
    public void testRetrieveFoyer_NotFound() {
        logger.info("Running testRetrieveFoyer_NotFound..."); // Log method execution
        when(foyerRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> foyerService.retrieveFoyer(1L));

        logger.error("testRetrieveFoyer_NotFound: Foyer not found, EntityNotFoundException thrown."); // Log error
    }

    @Test
    public void testRemoveFoyer_Success() {
        logger.info("Running testRemoveFoyer_Success..."); // Log method execution
        when(foyerRepository.existsById(1L)).thenReturn(true);

        foyerService.removeFoyer(1L);

        verify(foyerRepository, times(1)).deleteById(1L);

        logger.info("testRemoveFoyer_Success passed."); // Log after test
    }

    @Test
    public void testRemoveFoyer_NotFound() {
        logger.info("Running testRemoveFoyer_NotFound..."); // Log method execution
        when(foyerRepository.existsById(1L)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> foyerService.removeFoyer(1L));

        logger.error("testRemoveFoyer_NotFound: Foyer not found, EntityNotFoundException thrown."); // Log error
    }
}
