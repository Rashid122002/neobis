package com.neobis.week6.model;

import com.neobis.week6.entity.Client;

public class ClientModel {
    private Long clientId;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String notes;

    public static ClientModel entityToModel(Client client) {
        ClientModel clientModel = new ClientModel();
        clientModel.setClientId(client.getClientId());
        clientModel.setLastName(client.getLastName());
        clientModel.setFirstName(client.getFirstName());
        clientModel.setPhoneNumber(client.getPhoneNumber());
        clientModel.setNotes(client.getNotes());
        return clientModel;
    }

    public ClientModel() {
    }

    public ClientModel(String lastName, String firstName, String phoneNumber, String notes) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }

    public ClientModel(Long clientId, String lastName, String firstName, String phoneNumber, String notes) {
        this.clientId = clientId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "ClientModel{" +
                "clientId=" + clientId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
