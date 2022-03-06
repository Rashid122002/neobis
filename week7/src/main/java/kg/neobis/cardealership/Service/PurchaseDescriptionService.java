package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.PurchaseDescription;
import kg.neobis.cardealership.Repository.PurchaseDescriptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PurchaseDescriptionService {
    private PurchaseDescriptionRepository purchaseDescriptionRepository;

    public PurchaseDescriptionService(PurchaseDescriptionRepository purchaseDescriptionRepository) {
        this.purchaseDescriptionRepository = purchaseDescriptionRepository;
    }

    public List<PurchaseDescription> all() {
        return purchaseDescriptionRepository.findAll();
    }

    public PurchaseDescription getPurchaseDescriptionById(Integer id) {
        return purchaseDescriptionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find purchase description ", id));
    }

    public void addNewPurchaseDescription(@RequestBody PurchaseDescription newPurchaseDescription) {
        purchaseDescriptionRepository.save(newPurchaseDescription);
    }

    public PurchaseDescription replacePurchaseDescription(@RequestBody PurchaseDescription newPurchaseDescription, @PathVariable Integer id) {
        return purchaseDescriptionRepository.findById(id)
                .map(purchaseDescription -> {
                    purchaseDescription.setDescription(newPurchaseDescription.getDescription());
                    return purchaseDescriptionRepository.save(purchaseDescription);
                })
                .orElseGet(() -> {
                    newPurchaseDescription.setPurchaseId(id);
                    return purchaseDescriptionRepository.save(newPurchaseDescription);
                });
    }

    public void deletePurchaseDescriptionById(@PathVariable Integer id) {
        boolean exists = purchaseDescriptionRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Could not find purchase description ", id);
        }
        purchaseDescriptionRepository.deleteById(id);
    }
}
