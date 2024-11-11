package tn.esprit.tpfoyer17.services.interfaces;

import tn.esprit.tpfoyer17.entities.Reservation;
import tn.esprit.tpfoyer17.entities.Universite;

import java.time.LocalDate;

import java.util.List;

public interface IUniversiteService {

    public List<Universite> retrieveAllUniversites();
    public Universite retrieveUniversite(Long idUniversite);
    public Universite addUniversite(Universite f);
    //public void removeUniversite(Long universiteId);
    public Universite modifyUniversite(Universite universite);

    // Here we will add later methods calling keywords and methods calling JPQL

}