package com.example.immigrationconsultingfirm_project_cse213.Finance_Officer.Model;

import java.io.Serializable;

public class VisaRuleCheck implements Serializable {
    //Enter Refund ID or Application ID to check policy compliance.
    protected int refundId, applicationId;
    protected String name;

    public int getRefundId() {
        return refundId;
    }

    public void setRefundId(int refundId) {
        this.refundId = refundId;
    }

    public VisaRuleCheck(int refundId) {
        this.refundId = refundId;
    }

    @Override
    public String toString() {
        return "VisaRuleCheck{" +
                "refundId=" + refundId +
                ", applicationId=" + applicationId +
                ", name='" + name + '\'' +
                '}';
    }
}

