package com.acciojob.VaccinationManagement.repository;

import com.acciojob.VaccinationManagement.model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
