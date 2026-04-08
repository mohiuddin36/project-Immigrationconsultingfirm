package com.example.immigrationconsultingfirm_project_cse213.DocumentationAndTranslation;

public class DocumentData {

    private String fileName;
    private String fileType;

    public DocumentData(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}