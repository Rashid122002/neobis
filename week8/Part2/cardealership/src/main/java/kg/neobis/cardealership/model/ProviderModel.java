package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderModel {
    private Long providerId;
    private String companyName;
    private String companyOfficialName;
    private String position;
    private String address;
    private String city;
    private String phoneNumber;
    private String fax;
    private String paymentTerm;

    public static ProviderModel providerToProviderModel(Provider provider) {
        ProviderModel providerModel = new ProviderModel();
        providerModel.setProviderId(provider.getProviderId());
        providerModel.setCompanyName(provider.getCompanyName());
        providerModel.setCompanyOfficialName(provider.getCompanyOfficialName());
        providerModel.setPosition(provider.getPosition());
        providerModel.setAddress(provider.getAddress());
        providerModel.setCity(provider.getCity());
        providerModel.setPhoneNumber(provider.getPhoneNumber());
        providerModel.setFax(provider.getFax());
        providerModel.setPaymentTerm(provider.getPaymentTerm());
        return providerModel;
    }
}
