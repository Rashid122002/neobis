package kg.neobis.cardealership.Controller;

import kg.neobis.cardealership.Model.PurchaseDescription;
import kg.neobis.cardealership.Service.PurchaseDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/purchasedescriptions")
public class PurchaseDescriptionController {
    private final PurchaseDescriptionService purchaseDescriptionService;

    @Autowired
    public PurchaseDescriptionController(PurchaseDescriptionService purchaseDescriptionService) {
        this.purchaseDescriptionService = purchaseDescriptionService;
    }

    @GetMapping
    public List<PurchaseDescription> getPurchaseDescriptions() {
        return purchaseDescriptionService.all();
    }

    @GetMapping("/{id}")
    public PurchaseDescription getPurchaseDescriptionById(@PathVariable Integer id) {
        return purchaseDescriptionService.getPurchaseDescriptionById(id);
    }

    @PostMapping
    public void registerNewPurchaseDescription(@RequestBody PurchaseDescription newPurchaseDescription) {
        purchaseDescriptionService.addNewPurchaseDescription(newPurchaseDescription);
    }

    @PutMapping("/{id}")
    public PurchaseDescription replacePurchaseDescription(@RequestBody PurchaseDescription newPurchaseDescription, @PathVariable Integer id) {
        return purchaseDescriptionService.replacePurchaseDescription(newPurchaseDescription, id);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseDescription(@PathVariable Integer id) {
        purchaseDescriptionService.deletePurchaseDescriptionById(id);
    }
}
