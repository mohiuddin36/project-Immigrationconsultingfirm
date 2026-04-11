package com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes;

public class Document {
    private String documentType;
    private String fileName;
    private String uploadDate;
    private String status;

    public Document(String documentType, String fileName, String uploadDate, String status) {
        this.documentType = documentType;
        this.fileName = fileName;
        this.uploadDate = uploadDate;
        this.status = status;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public String getStatus() {
        return status;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentType='" + documentType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", uploadDate='" + uploadDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}