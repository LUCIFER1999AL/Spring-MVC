package com.example.patientsmvc.repositories;

import com.example.patientsmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface IpatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNomContains(String nom, PageRequest of);
}
