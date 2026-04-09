package com.example.immigrationconsultingfirm_project_cse213.Immegration_Consultant.Model;

import java.io.Serializable;

public class ClientAssessment implements Serializable {
    //Input scores (IELTS/TEF), Education (ECA), and Work Experience.
    protected double ieltsScore;
    protected String educationECA;
    protected int workExperience;

    public double getIeltsScore() {
        return ieltsScore;
    }

    public void setIeltsScore(double ieltsScore) {
        this.ieltsScore = ieltsScore;
    }

    public ClientAssessment(double ieltsScore) {
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
