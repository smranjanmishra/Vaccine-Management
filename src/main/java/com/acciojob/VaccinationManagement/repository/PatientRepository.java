package com.acciojob.VaccinationManagement.repository;

import com.acciojob.VaccinationManagement.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
