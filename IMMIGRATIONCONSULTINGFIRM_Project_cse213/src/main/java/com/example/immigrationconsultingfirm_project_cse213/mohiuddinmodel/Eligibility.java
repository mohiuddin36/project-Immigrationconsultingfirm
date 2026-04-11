package com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel;

public class Eligibility {
    private String country;
    private String program;
    private String requirements;

    @Override
    public String toString() {
        return "Eligibility{" +
                "country='" + country + '\'' +
                ", program='" + program + '\'' +
                ", requirements='" + requirements + '\'' +
                '}';
    }

    public Eligibility(String country, String program, String requirements) {
        this.country = country;
        this.program = program;
        this.requirements = requirements;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
