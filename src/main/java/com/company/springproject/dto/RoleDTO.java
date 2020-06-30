package com.company.springproject.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class RoleDTO {
    @ApiModelProperty(notes = "The database generated product ID")
    private int id;
    @ApiModelProperty(notes = "The Role-specific organization")
    private String organization;
    @ApiModelProperty(notes = "The Role first name")
    private String firstName;
    @ApiModelProperty(notes = "The Role last name")
    private String lastName;
    @ApiModelProperty(notes = "The Role NIC Number")
    private String nicNo;
    @ApiModelProperty(notes = "The Role role Driver or Assistant")
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
