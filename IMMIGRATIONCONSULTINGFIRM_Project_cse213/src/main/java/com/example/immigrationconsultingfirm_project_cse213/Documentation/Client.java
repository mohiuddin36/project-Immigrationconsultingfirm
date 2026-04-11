package com.example.immigrationconsultingfirm_project_cse213.Documentation;
import java.time.LocalDate;

public class Client {

        private String name;
        private String id;
        private String docType;
        private LocalDate date;

        // Constructor: Used to create a new Client object
        public Client(String name, String id, String docType, LocalDate date) {
            this.name = name;
            this.id = id;
            this.docType = docType;
            this.date = date;
        }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDocType() {
        return docType;
    }

    public LocalDate getDate() {
        return date;
    }

    // 🔹 Setters (used in Goal-2 for editing)
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
