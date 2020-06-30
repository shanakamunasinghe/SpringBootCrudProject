package com.company.springproject.dto;

import io.swagger.annotations.ApiModelProperty;

public class RetrieveDTO {
    @ApiModelProperty(notes = "The Role NIC Number")
    private String nicNo;
    @ApiModelProperty(notes = "The Role first name")
    private String firstName;
    @ApiModelProperty(notes = "The Role last name")
    private String lastName;

    public RetrieveDTO() {
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
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
}
