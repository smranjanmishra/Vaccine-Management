package com.acciojob.VaccinationManagement.service;

import com.acciojob.VaccinationManagement.model.Doctor;
import com.acciojob.VaccinationManagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "Doctor saved successfully";
    }

    public String deleteDoctor(int id) {
        doctorRepository.deleteById(id);
        return "Doctor has been deleted";
    }
}
