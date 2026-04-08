package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

public class DocumentData {

    private String event;
    private String description;
    private String type;

    public DocumentData(String event, String description, String type) {
        this.event = event;
        this.description = description;
        this.type = type;
    }

    public String getEvent() {
        return event;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}