package com.example.immigrationconsultingfirm_project_cse213.Client.Model_Classes;

public class Document {
    private final String docId;   // immutable
    private String docType;
    private boolean verified;

    public Document(String docId, String docType) {
        this.docId = docId;
        this.docType = docType;
        this.verified = false; // default not verified
    }

    public String getDocId() {
        return docId;
    }

    public String getDocType() {
        return docType;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "Document{" +
                "docId='" + docId + '\'' +
                ", docType='" + docType + '\'' +
                ", verified=" + verified +
                '}';
    }
}
