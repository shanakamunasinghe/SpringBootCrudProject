package com.company.springproject.dto;

import io.swagger.annotations.ApiModelProperty;

public class RequestDTO {
    @ApiModelProperty(notes = "The Roles organization")
    private String organization;
    @ApiModelProperty(notes = "The Roles role type")
    private String role;

    public RequestDTO() {
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
