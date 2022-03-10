package kg.neobis.cardealership.service;

import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.entity.Provider;
import kg.neobis.cardealership.model.ProviderModel;
import kg.neobis.cardealership.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static kg.neobis.cardealership.model.ProviderModel.providerToProviderModel;

@Service
public class ProviderService implements DAO<Provider, ProviderModel, Long>  {
    private ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public List<ProviderModel> entityListToModelList(Iterable<Provider> providers) {
        List<ProviderModel> providerModelList = new ArrayList<ProviderModel>();
        for (Provider provider : providers)
        {
            providerModelList.add(providerToProviderModel(provider));
        }
        return providerModelList;
    }

    @Override
    public List<ProviderModel> getAll() {
        return entityListToModelList(providerRepository.findAll());
    }

    @Override
    public ProviderModel getById(Long id) throws EntityNotFoundException {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found provider: ", id));
        return providerToProviderModel(provider);
    }

    @Override
    public void add(Provider provider) {
        providerRepository.save(provider);
    }

    @Override
    public Provider update(ProviderModel providerModel, Long id) throws EntityNotFoundException {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found provider: ", id));
        provider.setCompanyName(providerModel.getCompanyName());
        provider.setCompanyOfficialName(providerModel.getCompanyOfficialName());
        provider.setPosition(providerModel.getPosition());
        provider.setAddress(providerModel.getAddress());
        provider.setCity(providerModel.getCity());
        provider.setPhoneNumber(providerModel.getPhoneNumber());
        provider.setFax(providerModel.getFax());
        provider.setPaymentTerm(providerModel.getPaymentTerm());
        return providerRepository.save(provider);
    }

    @Override
    public Long delete(Long id) throws EntityNotFoundException {
        if(!providerRepository.existsById(id)) {
            throw new EntityNotFoundException("Could not found provider: ", id);
        }
        providerRepository.deleteById(id);
        return id;
    }
}
