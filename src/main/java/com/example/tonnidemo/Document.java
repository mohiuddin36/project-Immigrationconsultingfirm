package com.example.tonnidemo;

public class Document {

    private String documentId;
    private String clientName;
    private String type;
    private String filePath;
    private String status;

    public Document(String documentId, String clientName, String type, String filePath) {
        this.documentId = documentId;
        this.clientName = clientName;
        this.type = type;
        this.filePath = filePath;
        this.status = "Pending";
    }

    public String getDocumentId() { return documentId; }
    public String getClientName() { return clientName; }
    public String getType() { return type; }
    public String getFilePath() { return filePath; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}