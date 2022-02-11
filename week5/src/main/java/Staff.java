public class Staff {
    private Long staffId;
    private String lastName;
    private String firstName;
    private String post;
    private String phoneNumber;

    public Staff() {
    }

    public Staff(String lastName, String firstName, String post, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.post = post;
        this.phoneNumber = phoneNumber;
    }

    public Staff(Long staffId, String lastName, String firstName, String post, String phoneNumber) {
        this.staffId = staffId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.post = post;
        this.phoneNumber = phoneNumber;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
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
