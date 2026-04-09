package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;

public class ClientAssessment implements Serializable {
    //Input scores (IELTS/TEF), Education (ECA), and Work Experience.
    protected int ieltsScore;
    protected String educationECA;
    protected int workExperience;

    public int getIeltsScore() {
        return ieltsScore;
    }

    public void setIeltsScore(int ieltsScore) {
        this.ieltsScore = ieltsScore;
    }

    public ClientAssessment(int ieltsScore) {
        this.ieltsScore = ieltsScore;
    }

    @Override
    public String toString() {
        return "ClientAssessment{" +
                "ieltsScore=" + ieltsScore +
                ", educationECA='" + educationECA + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }
}


