package com.example.immigrationconsultingfirm_project_cse213.mohiuddinmodel;

public class ClientDetails {
    private String name;
    private int age;
    private String educationQualification;

    @Override
    public String toString() {
        return "ClientDetails{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", educationQualification='" + educationQualification + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducationQualification() {
        return educationQualification;
    }

    public void setEducationQualification(String educationQualification) {
        this.educationQualification = educationQualification;
    }

    public ClientDetails(String name, int age, String educationQualification) {
        this.name = name;
        this.age = age;
        this.educationQualification = educationQualification;
    }
}
