package com.acciojob.VaccinationManagement.dto.response;

import com.acciojob.VaccinationManagement.Enum.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AppointmentResponse {
    private String appointmentId;

    private Date dateOfApppointment;

    private AppointmentStatus status;

    private PatientResponse patientResponse;

    private String doctorName;
}
