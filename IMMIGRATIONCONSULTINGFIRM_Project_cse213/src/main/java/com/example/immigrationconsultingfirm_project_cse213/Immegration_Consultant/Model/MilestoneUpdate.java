package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;
import java.time.LocalDate;

public class MilestoneUpdate  implements Serializable {
    //Update status (AOR received, PIN requested, PPR)
    protected String applicationStatus,username, password;
    protected LocalDate updateDate;

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public MilestoneUpdate(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "MilestoneUpdate{" +
                "applicationStatus='" + applicationStatus + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }
}
