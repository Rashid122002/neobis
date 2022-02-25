package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.SaleDescription;
import kg.neobis.cardealership.Repository.SaleDescriptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class SaleDescriptionService {
    private SaleDescriptionRepository saleDescriptionRepository;

    public SaleDescriptionService(SaleDescriptionRepository saleDescriptionRepository) {
        this.saleDescriptionRepository = saleDescriptionRepository;
    }

    public List<SaleDescription> all() {
        return saleDescriptionRepository.findAll();
    }

    public SaleDescription getSaleDescriptionById(Integer id) {
        return saleDescriptionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find sale description ", id));
    }

    public void addNewSaleDescription(@RequestBody SaleDescription newSaleDescription) {
        saleDescriptionRepository.save(newSaleDescription);
    }

    public SaleDescription replaceSaleDescription(@RequestBody SaleDescription newSaleDescription, @PathVariable Integer id) {
        return saleDescriptionRepository.findById(id)
                .map(saleDescription -> {
                    saleDescription.setDescription(newSaleDescription.getDescription());
                    return saleDescriptionRepository.save(saleDescription);
                })
                .orElseGet(() -> {
                    newSaleDescription.setSaleId(id);
                    return saleDescriptionRepository.save(newSaleDescription);
                });
    }

    public void deleteSaleDescriptionById(@PathVariable Integer id) {
        boolean exists = saleDescriptionRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Could not find sale description ", id);
        }
        saleDescriptionRepository.deleteById(id);
    }
}
