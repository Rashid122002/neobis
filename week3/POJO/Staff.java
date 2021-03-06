import java.util.Objects;

public class Staff {
    private int staffId;
    private String lastName;
    private String firstName;
    private String post;
    private String phoneNumber;

    public Staff() {
    }

    public Staff(int staffId, String lastName, String firstName, String post, String phoneNumber) {
        this.staffId = staffId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.post = post;
        this.phoneNumber = phoneNumber;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return staffId == staff.staffId
                && Objects.equals(lastName, staff.lastName)
                && Objects.equals(firstName, staff.firstName)
                && Objects.equals(post, staff.post)
                && Objects.equals(phoneNumber, staff.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, lastName, firstName, post, phoneNumber);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", post='" + post + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
