public class Provider {
    private Long providerId;
    private String companyName;
    private String companyOfficialName;
    private String post;
    private String address;
    private String city;
    private String phoneNumber;
    private String fax;
    private String paymentTerms;

    public Provider() {
    }

    public Provider(String companyName, String companyOfficialName, String post, String address, String city, String phoneNumber, String fax, String paymentTerms) {
        this.companyName = companyName;
        this.companyOfficialName = companyOfficialName;
        this.post = post;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.fax = fax;
        this.paymentTerms = paymentTerms;
    }

    public Provider(Long providerId,
                    String companyName,
                    String companyOfficialName,
                    String post,
                    String address,
                    String city,
                    String phoneNumber,
                    String fax,
                    String paymentTerms) {
        this.providerId = providerId;
        this.companyName = companyName;
        this.companyOfficialName = companyOfficialName;
        this.post = post;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.fax = fax;
        this.paymentTerms = paymentTerms;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyOfficialName() {
        return companyOfficialName;
    }

    public void setCompanyOfficialName(String companyOfficialName) {
        this.companyOfficialName = companyOfficialName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerId=" + providerId +
                ", companyName='" + companyName + '\'' +
                ", companyOfficialName='" + companyOfficialName + '\'' +
                ", post='" + post + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fax='" + fax + '\'' +
                ", paymentTerms='" + paymentTerms + '\'' +
                '}';
    }
}
