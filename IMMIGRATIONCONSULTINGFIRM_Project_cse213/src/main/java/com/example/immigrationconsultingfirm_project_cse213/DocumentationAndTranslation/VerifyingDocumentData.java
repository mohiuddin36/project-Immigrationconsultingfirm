package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

public class VerifyingDocumentData {
    private String name;
    private String type;
    private String status;

    public VerifyingDocumentData(String name, String type, String status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {   // <-- THIS IS REQUIRED
        return status;
    }

    // SETTERS (optional but useful if you want to update)
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}