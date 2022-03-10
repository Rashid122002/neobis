package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.entity.PurchaseDescription;
import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.model.PurchaseDescriptionModel;
import kg.neobis.cardealership.service.PurchaseDescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/purchasedescriptions")
public class PurchaseDescriptionController {
    private final PurchaseDescriptionService purchaseDescriptionService;

    public PurchaseDescriptionController(PurchaseDescriptionService purchaseDescriptionService) {
        this.purchaseDescriptionService = purchaseDescriptionService;
    }

    @GetMapping
    public ResponseEntity<?> getPurchaseDescriptions() {
        try{
            return ResponseEntity.ok(purchaseDescriptionService.getAll());
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseDescriptionById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(purchaseDescriptionService.getById(id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewPurchaseDescription(@RequestBody PurchaseDescription newPurchaseDescription) {
        try {
            purchaseDescriptionService.add(newPurchaseDescription);
            return ResponseEntity.ok("PurchaseDescription was added successfully");
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replacePurchaseDescription(@RequestBody PurchaseDescriptionModel purchaseDescriptionModel, @PathVariable Integer id) {
        try{
            return ResponseEntity.ok(purchaseDescriptionService.update(purchaseDescriptionModel, id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchaseDescription(@PathVariable Integer id) {
        try {
            purchaseDescriptionService.delete(id);
            return ResponseEntity.ok("Deleted purchase description with id = " + id);
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
