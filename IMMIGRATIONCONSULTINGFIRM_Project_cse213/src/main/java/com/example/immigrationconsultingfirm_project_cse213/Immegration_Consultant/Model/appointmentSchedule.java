package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class appointmentSchedule implements Serializable {
    //Input date, time, and appointment type (Interview/Prep)
    protected String appointmentType,appointmentTime;
    protected LocalDate appointmentDate;

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public appointmentSchedule(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    @Override
    public String toString() {
        return "appointmentSchedule{" +
                "appointmentType='" + appointmentType + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}

