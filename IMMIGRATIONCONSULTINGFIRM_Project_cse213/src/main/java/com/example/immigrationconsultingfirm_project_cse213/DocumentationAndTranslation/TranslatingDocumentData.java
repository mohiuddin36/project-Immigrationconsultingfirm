package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

public class TranslatingDocumentData {
    private String name;
    private String language;  // for TranslatingController
    private String deadline;  // new field for DeadlinesController
    private String status;

    public TranslatingDocumentData(String name, String language, String deadline, String status) {
        this.name = name;
        this.language = language;
        this.deadline = deadline;
        this.status = status;
    }

    // Name
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    // Language (used in TranslatingController)
    public String getLanguage() { return language; }

    public void setLanguage(String language) { this.language = language; }

    // Deadline (used in DeadlinesController)
    public String getDeadline() { return deadline; }

    public void setDeadline(String deadline) { this.deadline = deadline; }

    // Status
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
