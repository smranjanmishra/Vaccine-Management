package com.acciojob.VaccinationManagement.controller;

import com.acciojob.VaccinationManagement.dto.response.AppointmentResponse;
import com.acciojob.VaccinationManagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity bookAppointment(@RequestParam("pid") int patientId,
                                          @RequestParam("did") int doctorId) {
        try{
            AppointmentResponse bookedAppointment = appointmentService.bookAppointment(patientId,doctorId);
            return new ResponseEntity(bookedAppointment, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

        // get all the appointment after a particular date

        // get all the appoitments with a particular doctor

        // make api to change the status of appointment

        // get appointment details of a particular patient

    }
}
