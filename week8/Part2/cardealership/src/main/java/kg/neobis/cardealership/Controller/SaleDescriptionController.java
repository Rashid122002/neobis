package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.entity.SaleDescription;
import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.model.SaleDescriptionModel;
import kg.neobis.cardealership.service.SaleDescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/saledescription")
public class SaleDescriptionController {
    private final SaleDescriptionService saleDescriptionService;

    public SaleDescriptionController(SaleDescriptionService saleDescriptionService) {
        this.saleDescriptionService = saleDescriptionService;
    }

    @GetMapping
    public ResponseEntity<?> getSaleDescriptions() {
        try{
            return ResponseEntity.ok(saleDescriptionService.getAll());
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSaleDescriptionById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(saleDescriptionService.getById(id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewSaleDescription(@RequestBody SaleDescription newSaleDescription) {
        try {
            saleDescriptionService.add(newSaleDescription);
            return ResponseEntity.ok("SaleDescription was added successfully");
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceSaleDescription(@RequestBody SaleDescriptionModel saleDescriptionModel, @PathVariable Integer id) {
        try{
            return ResponseEntity.ok(saleDescriptionService.update(saleDescriptionModel, id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSaleDescription(@PathVariable Integer id) {
        try {
            saleDescriptionService.delete(id);
            return ResponseEntity.ok("Deleted sale description with id = " + id);
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
