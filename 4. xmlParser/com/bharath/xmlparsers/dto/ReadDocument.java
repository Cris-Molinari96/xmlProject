package com.bharath.xmlparsers.dto;

import java.util.Date;

public class ReadDocument {

    private String name;
    private String surname;
    private String DateOfBirth;
    private String VehicleType;
    private String DateOfIssue;
    private String ExpirtyDate;
    private String photLlocation;
    private ReadParagraph readParagraph;

    public ReadDocument() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getDateOfIssue() {
        return DateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        DateOfIssue = dateOfIssue;
    }

    public String getExpirtyDate() {
        return ExpirtyDate;
    }

    public void setExpirtyDate(String expirtyDate) {
        ExpirtyDate = expirtyDate;
    }

    public String getPhotLlocation() {
        return photLlocation;
    }

    public void setPhotLlocation(String photLlocation) {
        this.photLlocation = photLlocation;
    }

    public ReadParagraph getReadParagraph() {
        return readParagraph;
    }

    public void setReadParagraph(ReadParagraph readParagraph) {
        this.readParagraph = readParagraph;
    }
}
