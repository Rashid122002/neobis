package kg.neobis.cardealership.Controller;

import kg.neobis.cardealership.Model.Price;
import kg.neobis.cardealership.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/prices")
public class PriceController {
    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public List<Price> getPrices() {
        return priceService.all();
    }

    @GetMapping("/{id}")
    public Price getPriceById(@PathVariable Integer id) {
        return priceService.getPriceById(id);
    }

    @PostMapping
    public void registerNewPrice(@RequestBody Price newPrice) {
        priceService.addNewPrice(newPrice);
    }

    @PutMapping("/{id}")
    public Price replacePrice(@RequestBody Price newPrice, @PathVariable Integer id) {
        return priceService.replacePrice(newPrice, id);
    }

    @DeleteMapping("/{id}")
    public void deletePrice(@PathVariable Integer id) {
        priceService.deletePriceById(id);
    }
}
