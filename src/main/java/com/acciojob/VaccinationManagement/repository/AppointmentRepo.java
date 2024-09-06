package com.acciojob.VaccinationManagement.repository;

import com.acciojob.VaccinationManagement.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {
}
