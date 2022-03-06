package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.Price;
import kg.neobis.cardealership.Repository.PriceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PriceService {
    private PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public List<Price> all() {
        return priceRepository.findAll();
    }

    public Price getPriceById(Integer id) {
        return priceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find price ", id));
    }

    public void addNewPrice(@RequestBody Price newPrice) {
        priceRepository.save(newPrice);
    }

    public Price replacePrice(@RequestBody Price newPrice, @PathVariable Integer id) {
        return priceRepository.findById(id)
                .map(price -> {
                    price.setSalePrice(newPrice.getSalePrice());
                    return priceRepository.save(price);
                })
                .orElseGet(() -> {
                    newPrice.setPriceId(id);
                    return priceRepository.save(newPrice);
                });
    }

    public void deletePriceById(@PathVariable Integer id) {
        boolean exists = priceRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Could not find price ", id);
        }
        priceRepository.deleteById(id);
    }
}
