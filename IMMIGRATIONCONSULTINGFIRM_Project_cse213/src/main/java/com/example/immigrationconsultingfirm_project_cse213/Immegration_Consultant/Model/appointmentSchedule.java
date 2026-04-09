package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;

public class appointmentSchedule implements Serializable {
    //Input date, time, and appointment type (Interview/Prep)
    protected String appointmentDate,appointmentType,appointmentTime;

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public appointmentSchedule(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "appointmentSchedule{" +
                "appointmentDate='" + appointmentDate + '\'' +
                ", appointmentType='" + appointmentType + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                '}';
    }
}
