package com.example.patientsmvc;

import com.example.patientsmvc.entities.Patient;
import com.example.patientsmvc.repositories.IpatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;
import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication implements CommandLineRunner {

    @Autowired
    private IpatientRepository patientRepository;

    public static void main(String[] args) {

        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Ajouter des patients */
        patientRepository.save(new Patient(null, "Abdessamad", new Date(), false, 30));
        patientRepository.save(new Patient(null, "Laloui", new Date(), true, 60));
        patientRepository.save(new Patient(null, "Lucifer", new Date(), false, 120));

        /*afficher tous les patients*/
        patientRepository.findAll().forEach(p -> {
            System.out.println(p.getNom());
        });
    }




}
