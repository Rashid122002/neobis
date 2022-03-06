package kg.neobis.cardealership.Controller;

import kg.neobis.cardealership.Model.SaleDescription;
import kg.neobis.cardealership.Service.SaleDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/saledescription")
public class SaleDescriptionController {
    private final SaleDescriptionService saleDescriptionService;

    @Autowired
    public SaleDescriptionController(SaleDescriptionService saleDescriptionService) {
        this.saleDescriptionService = saleDescriptionService;
    }

    @GetMapping
    public List<SaleDescription> getSaleDescriptions() {
        return saleDescriptionService.all();
    }

    @GetMapping("/{id}")
    public SaleDescription getSaleDescriptionById(@PathVariable Integer id) {
        return saleDescriptionService.getSaleDescriptionById(id);
    }

    @PostMapping
    public void registerNewSaleDescription(@RequestBody SaleDescription newSaleDescription) {
        saleDescriptionService.addNewSaleDescription(newSaleDescription);
    }

    @PutMapping("/{id}")
    public SaleDescription replaceSaleDescription(@RequestBody SaleDescription newSaleDescription, @PathVariable Integer id) {
        return saleDescriptionService.replaceSaleDescription(newSaleDescription, id);
    }

    @DeleteMapping("/{id}")
    public void deleteSaleDescription(@PathVariable Integer id) {
        saleDescriptionService.deleteSaleDescriptionById(id);
    }
}
