package kg.neobis.cardealership.service;

import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.entity.PurchaseDescription;
import kg.neobis.cardealership.model.PurchaseDescriptionModel;
import kg.neobis.cardealership.repository.PurchaseDescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static kg.neobis.cardealership.model.PurchaseDescriptionModel.purchaseDescriptionToPurchaseDescriptionModeL;

@Service
public class PurchaseDescriptionService implements DAO<PurchaseDescription, PurchaseDescriptionModel, Integer> {
    private PurchaseDescriptionRepository purchaseDescriptionRepository;

    public PurchaseDescriptionService(PurchaseDescriptionRepository purchaseDescriptionRepository) {
        this.purchaseDescriptionRepository = purchaseDescriptionRepository;
    }

    @Override
    public List<PurchaseDescriptionModel> entityListToModelList(Iterable<PurchaseDescription> purchaseDescriptions) {
        List<PurchaseDescriptionModel> purchaseDescriptionModelList = new ArrayList<PurchaseDescriptionModel>();
        for (PurchaseDescription purchaseDescription : purchaseDescriptions)
        {
            purchaseDescriptionModelList.add(purchaseDescriptionToPurchaseDescriptionModeL(purchaseDescription));
        }
        return purchaseDescriptionModelList;
    }

    @Override
    public List<PurchaseDescriptionModel> getAll() {
        return entityListToModelList(purchaseDescriptionRepository.findAll());
    }

    @Override
    public PurchaseDescriptionModel getById(Integer id) throws EntityNotFoundException {
        PurchaseDescription purchaseDescription = purchaseDescriptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found purchase description: ", id));
        return purchaseDescriptionToPurchaseDescriptionModeL(purchaseDescription);
    }

    @Override
    public void add(PurchaseDescription purchaseDescription) {
        purchaseDescriptionRepository.save(purchaseDescription);
    }

    @Override
    public PurchaseDescription update(PurchaseDescriptionModel purchaseDescriptionModel, Integer id) throws EntityNotFoundException {
        PurchaseDescription purchaseDescription = purchaseDescriptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found purchase description: ", id));
        purchaseDescription.setDescription(purchaseDescriptionModel.getDescription());
        return purchaseDescriptionRepository.save(purchaseDescription);
    }

    @Override
    public Integer delete(Integer id) throws EntityNotFoundException {
        if(!purchaseDescriptionRepository.existsById(id)) {
            throw new EntityNotFoundException("Could not found purchase description: ", id);
        }
        purchaseDescriptionRepository.deleteById(id);
        return id;
    }
}
