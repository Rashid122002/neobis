import java.util.Objects;

public class Provider {
    private long providerId;
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

    public Provider(long providerId,
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

    public long getProviderId() {
        return providerId;
    }

    public void setProviderId(long providerId) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return providerId == provider.providerId
                && Objects.equals(companyName, provider.companyName)
                && Objects.equals(companyOfficialName, provider.companyOfficialName)
                && Objects.equals(post, provider.post)
                && Objects.equals(address, provider.address)
                && Objects.equals(city, provider.city)
                && Objects.equals(phoneNumber, provider.phoneNumber)
                && Objects.equals(fax, provider.fax)
                && Objects.equals(paymentTerms, provider.paymentTerms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerId, companyName, companyOfficialName, post, address, city, phoneNumber, fax, paymentTerms);
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
