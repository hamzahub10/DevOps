package tn.esprit.tpfoyer17.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer17.entities.Universite;
import tn.esprit.tpfoyer17.services.interfaces.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/univeristes")
public class UniversiteController {
    @GetMapping("/retrieveAllUniversities")
    public List<Universite> retrieveAllUniversities() {
        return universiteService.retrieveAllUniversites();
    }
@PostMapping("/addUniversity")
    public Universite addUniversity(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }
@PutMapping("/updateUniversity")
    public Universite updateUniversity(@RequestBody Universite u) {
        return universiteService.modifyUniversite(u);
    }
@GetMapping("/retrieveUniversity/{idUniversity}")
    public Universite retrieveUniversity(@PathVariable("idUniversity") long idUniversity) {
        return universiteService.retrieveUniversite(idUniversity);
    }


    IUniversiteService universiteService;
}
