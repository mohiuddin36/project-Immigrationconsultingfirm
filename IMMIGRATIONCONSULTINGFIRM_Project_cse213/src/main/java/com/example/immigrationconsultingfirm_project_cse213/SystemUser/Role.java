package com.example.immigrationconsultingfirm_project_cse213.SystemUser;

public class Role {
    private String roleName;
    private String accessLevel;

    public Role(String roleName, String accessLevel) {
        this.roleName = roleName;
        this.accessLevel = accessLevel;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

}
