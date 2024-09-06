package com.acciojob.VaccinationManagement.service;

import com.acciojob.VaccinationManagement.Enum.VaccineBrand;
import com.acciojob.VaccinationManagement.exception.PatientNotFoundException;
import com.acciojob.VaccinationManagement.model.Dose;
import com.acciojob.VaccinationManagement.model.Patient;
import com.acciojob.VaccinationManagement.repository.DoseRepository;
import com.acciojob.VaccinationManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PatientRepository patientRepository;

    public Dose addDose(int patientId, VaccineBrand vaccineBrand) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if (patientOptional.isEmpty()) {
            throw new PatientNotFoundException("Invalid patient id");
        }

        Patient patient = patientOptional.get();
        if (patient.isVaccinated()) {
            throw new RuntimeException("Patient is already vaccinated");
        }

        patient.setVaccinated(true);

        Dose dose = new Dose();
        dose.setVaccineBrand(vaccineBrand);
        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));
        dose.setPatient(patient); // setting the FK

        patientRepository.save(patient);
        return doseRepository.save(dose);
    }
}
