package kg.neobis.cardealership.service;

import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.entity.SaleDescription;
import kg.neobis.cardealership.model.SaleDescriptionModel;
import kg.neobis.cardealership.repository.SaleDescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static kg.neobis.cardealership.model.SaleDescriptionModel.saleDescriptionModelToSaleDescriptionModelModeL;

@Service
public class SaleDescriptionService implements DAO<SaleDescription, SaleDescriptionModel, Integer> {
    private SaleDescriptionRepository saleDescriptionRepository;

    public SaleDescriptionService(SaleDescriptionRepository saleDescriptionRepository) {
        this.saleDescriptionRepository = saleDescriptionRepository;
    }

    @Override
    public List<SaleDescriptionModel> entityListToModelList(Iterable<SaleDescription> saleDescriptions) {
        List<SaleDescriptionModel> saleDescriptionModelModelList = new ArrayList<SaleDescriptionModel>();
        for (SaleDescription saleDescription : saleDescriptions)
        {
            saleDescriptionModelModelList.add(saleDescriptionModelToSaleDescriptionModelModeL(saleDescription));
        }
        return saleDescriptionModelModelList;
    }

    @Override
    public List<SaleDescriptionModel> getAll() {
        return entityListToModelList(saleDescriptionRepository.findAll());
    }

    @Override
    public SaleDescriptionModel getById(Integer id) throws EntityNotFoundException {
        SaleDescription saleDescription = saleDescriptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found sale description: ", id));
        return saleDescriptionModelToSaleDescriptionModelModeL(saleDescription);
    }

    @Override
    public void add(SaleDescription saleDescription) {
        saleDescriptionRepository.save(saleDescription);
    }

    @Override
    public SaleDescription update(SaleDescriptionModel saleDescriptionModel, Integer id) throws EntityNotFoundException {
        SaleDescription saleDescription = saleDescriptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found sale description: ", id));
        saleDescription.setDescription(saleDescriptionModel.getDescription());
        return saleDescriptionRepository.save(saleDescription);
    }

    @Override
    public Integer delete(Integer id) throws EntityNotFoundException {
        if(!saleDescriptionRepository.existsById(id)) {
            throw new EntityNotFoundException("Could not found sale description: ", id);
        }
        saleDescriptionRepository.deleteById(id);
        return id;
    }
}
