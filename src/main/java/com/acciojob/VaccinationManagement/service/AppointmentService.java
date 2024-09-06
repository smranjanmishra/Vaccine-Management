package com.acciojob.VaccinationManagement.service;

import com.acciojob.VaccinationManagement.Enum.AppointmentStatus;
import com.acciojob.VaccinationManagement.dto.response.AppointmentResponse;
import com.acciojob.VaccinationManagement.dto.response.PatientResponse;
import com.acciojob.VaccinationManagement.exception.DoctorNotFoundException;
import com.acciojob.VaccinationManagement.exception.PatientNotFoundException;
import com.acciojob.VaccinationManagement.model.Appointment;
import com.acciojob.VaccinationManagement.model.Doctor;
import com.acciojob.VaccinationManagement.model.Patient;
import com.acciojob.VaccinationManagement.repository.AppointmentRepo;
import com.acciojob.VaccinationManagement.repository.DoctorRepository;
import com.acciojob.VaccinationManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AppointmentRepo appointmentRepo;

    public AppointmentResponse bookAppointment(int patientId, int doctorId) {
        Optional<Patient> patientOptional = patientRepository.findById(patientId);
        if(patientOptional.isEmpty()) {
            throw new PatientNotFoundException("Invalid patient id");
        }

        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        if(doctorOptional.isEmpty()) {
            throw new DoctorNotFoundException("Invalid doctor id");
        }

        Patient patient = patientOptional.get();
        Doctor doctor = doctorOptional.get();

        // book the appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setStatus(AppointmentStatus.BOOKED);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        Appointment savedAppiontment = appointmentRepo.save(appointment);

        // model to response dto
        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setAppointmentId(savedAppiontment.getAppointmentId());
        appointmentResponse.setStatus(savedAppiontment.getStatus());
        appointmentResponse.setDateOfApppointment(savedAppiontment.getDateOfApppointment());
        appointmentResponse.setDoctorName(savedAppiontment.getDoctor().getName());

        Patient savedPatient = savedAppiontment.getPatient();
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setName(savedPatient.getName());
        patientResponse.setEmailId(savedPatient.getEmailId());
        patientResponse.setVaccinated(savedPatient.isVaccinated());

        appointmentResponse.setPatientResponse(patientResponse);

        return appointmentResponse;
    }
}
