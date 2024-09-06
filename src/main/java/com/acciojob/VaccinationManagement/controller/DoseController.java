package com.acciojob.VaccinationManagement.controller;

import com.acciojob.VaccinationManagement.Enum.VaccineBrand;
import com.acciojob.VaccinationManagement.model.Dose;
import com.acciojob.VaccinationManagement.service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;

    @PostMapping("/vaccinate")
    public Dose addDose(@RequestParam("id") int patientId,
                        @RequestParam("brand") VaccineBrand vaccineBrand) {
        return doseService.addDose(patientId,vaccineBrand);
    }

    // homework
    // 1) Make entity relationships
    // 2) Make doctor APIs
    // 3) Make api to vaccinate a patient
}
