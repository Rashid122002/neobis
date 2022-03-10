package kg.neobis.cardealership.service;

import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.entity.Price;
import kg.neobis.cardealership.model.PriceModel;
import kg.neobis.cardealership.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static kg.neobis.cardealership.model.PriceModel.priceToPriceModel;

@Service
public class PriceService implements DAO<Price, PriceModel, Integer> {
    private PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<PriceModel> entityListToModelList(Iterable<Price> prices) {
        List<PriceModel> priceModelList = new ArrayList<PriceModel>();
        for (Price price : prices)
        {
            priceModelList.add(priceToPriceModel(price));
        }
        return priceModelList;
    }

    @Override
    public List<PriceModel> getAll() {
        return entityListToModelList(priceRepository.findAll());
    }

    @Override
    public PriceModel getById(Integer id) throws EntityNotFoundException {
        Price price = priceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found price ", id));
        return priceToPriceModel(price);
    }

    @Override
    public void add(Price price) {
        priceRepository.save(price);
    }

    @Override
    public Price update(PriceModel priceModel, Integer id) throws EntityNotFoundException {
        Price price = priceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found price: ", id));
        price.setSalePrice(priceModel.getSalePrice());
        return priceRepository.save(price);
    }

    @Override
    public Integer delete(Integer id) throws EntityNotFoundException {
        if(!priceRepository.existsById(id)) {
            throw new EntityNotFoundException("Could not found price: ", id);
        }
        priceRepository.deleteById(id);
        return id;
    }
}
