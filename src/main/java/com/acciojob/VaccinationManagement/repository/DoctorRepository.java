package com.acciojob.VaccinationManagement.repository;

import com.acciojob.VaccinationManagement.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
