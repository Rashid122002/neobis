package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.Provider;
import kg.neobis.cardealership.Repository.ProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProviderService {
    private ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> all() {
        return providerRepository.findAll();
    }

    public Provider getProviderById(Long id) {
        return providerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find provider ", id));
    }

    public void addNewProvider(@RequestBody Provider newProvider) {
        providerRepository.save(newProvider);
    }

    public Provider replaceProvider(@RequestBody Provider newProvider, @PathVariable Long id) {
        return providerRepository.findById(id)
                .map(provider -> {
                    provider.setCompanyName(newProvider.getCompanyName());
                    provider.setCompanyOfficialName(newProvider.getCompanyOfficialName());
                    provider.setPosition(newProvider.getPosition());
                    provider.setAddress(newProvider.getAddress());
                    provider.setCity(newProvider.getCity());
                    provider.setProviderId(newProvider.getProviderId());
                    provider.setFax(newProvider.getFax());
                    provider.setPaymentTerm(newProvider.getPaymentTerm());
                    return providerRepository.save(provider);
                })
                .orElseGet(() -> {
                    newProvider.setProviderId(id);
                    return providerRepository.save(newProvider);
                });
    }

    public void deleteProviderById(@PathVariable Long id) {
        boolean exists = providerRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Could not find provider ", id);
        }
        providerRepository.deleteById(id);
    }
}
