package com.company.springproject.dto;

import java.util.Date;

public class RoleDTO {
    private int id;
    private String organization;
    private String firstName;
    private String lastName;
    private String nicNo;
    private String role;

    public RoleDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
