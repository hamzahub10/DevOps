package tn.esprit.tpfoyer17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer17.entities.Etudiant;
import tn.esprit.tpfoyer17.repositories.EtudiantRepository;
import tn.esprit.tpfoyer17.services.impementations.EtudiantService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceTest {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantService etudiantService;

    private Etudiant etudiant;

    @BeforeEach
    public void setUp() {
        etudiant = Etudiant.builder()
                .nomEtudiant("Doe")
                .prenomEtudiant("John")
                .cinEtudiant(12345678)
                .dateNaissance(new Date(2000 - 1900, 0, 1)) // Date du 1er janvier 2000
                .build();
    }

    @Test
    public void testRetrieveAllEtudiants() {
        // Mock de la méthode findAll
        when(etudiantRepository.findAll()).thenReturn(Arrays.asList(etudiant));

        // Appel de la méthode du service
        List<Etudiant> etudiants = etudiantService.retrieveAllEtudiants();

        // Vérification
        verify(etudiantRepository, times(1)).findAll();
        assertThat(etudiants).isNotEmpty();
        assertThat(etudiants.get(0).getNomEtudiant()).isEqualTo("Doe");
    }

    @Test
    public void testAddEtudiants() {
        // Mock de la méthode saveAll
        when(etudiantRepository.saveAll(anyList())).thenReturn(Arrays.asList(etudiant));

        // Appel de la méthode du service
        List<Etudiant> createdEtudiants = etudiantService.addEtudiants(Arrays.asList(etudiant));

        // Vérification
        verify(etudiantRepository, times(1)).saveAll(anyList());
        assertThat(createdEtudiants).isNotEmpty();
        assertThat(createdEtudiants.get(0).getNomEtudiant()).isEqualTo("Doe");
    }

    @Test
    public void testUpdateEtudiant() {
        etudiant.setNomEtudiant("Updated Name");

        // Mock de la méthode save
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);

        // Appel de la méthode du service
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(etudiant);

        // Vérification
        verify(etudiantRepository, times(1)).save(etudiant);
        assertThat(updatedEtudiant.getNomEtudiant()).isEqualTo("Updated Name");
    }

    @Test
    public void testRetrieveEtudiant() {
        // Mock de la méthode findById
        when(etudiantRepository.findById(1L)).thenReturn(Optional.of(etudiant));

        // Appel de la méthode du service
        Etudiant foundEtudiant = etudiantService.retrieveEtudiant(1L);

        // Vérification
        verify(etudiantRepository, times(1)).findById(1L);
        assertThat(foundEtudiant).isNotNull();
        assertThat(foundEtudiant.getNomEtudiant()).isEqualTo("Doe");
    }

    @Test
    public void testRemoveEtudiant() {
        // Mock de la méthode deleteById
        doNothing().when(etudiantRepository).deleteById(1L);

        // Appel de la méthode du service
        etudiantService.removeEtudiant(1L);

        // Vérification
        verify(etudiantRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindByReservationsAnneeUniversitaire() {
        // Mock de la méthode findByReservationsAnneeUniversitaire
        when(etudiantRepository.findByReservationsAnneeUniversitaire(any(LocalDate.class))).thenReturn(Arrays.asList(etudiant));

        // Appel de la méthode du service
        List<Etudiant> etudiants = etudiantService.findByReservationsAnneeUniversitaire();

        // Vérification
        verify(etudiantRepository, times(1)).findByReservationsAnneeUniversitaire(any(LocalDate.class));
        assertThat(etudiants).isNotEmpty();
        assertThat(etudiants.get(0).getNomEtudiant()).isEqualTo("Doe");
    }
}
