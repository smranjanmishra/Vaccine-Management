package com.acciojob.VaccinationManagement.controller;

import com.acciojob.VaccinationManagement.model.Doctor;
import com.acciojob.VaccinationManagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    // get the doctor by id

    // delete a doctor by id
    @DeleteMapping("/delete")
    public String deleteDoctor(@RequestParam("id") int id) {
        return doctorService.deleteDoctor(id);
    }
}
