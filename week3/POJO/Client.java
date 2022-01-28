import java.util.Objects;

public class Client {
    private long clientId;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String notes;

    public Client() {
    }

    public Client(long clientId, String lastName, String firstName, String phoneNumber, String notes) {
        this.clientId = clientId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId && Objects.equals(lastName, client.lastName) && Objects.equals(firstName, client.firstName) && Objects.equals(phoneNumber, client.phoneNumber) && Objects.equals(notes, client.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, lastName, firstName, phoneNumber, notes);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
