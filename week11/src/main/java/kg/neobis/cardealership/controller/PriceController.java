package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.entity.Price;
import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.model.PriceModel;
import kg.neobis.cardealership.service.PriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/prices")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<?> getPrices() {
        try{
            return ResponseEntity.ok(priceService.getAll());
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPriceById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(priceService.getById(id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewPrice(@RequestBody Price newPrice) {
        try {
            priceService.add(newPrice);
            return ResponseEntity.ok("Price was added successfully");
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replacePrice(@RequestBody PriceModel priceModel, @PathVariable Integer id) {
        try{
            return ResponseEntity.ok(priceService.update(priceModel, id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrice(@PathVariable Integer id) {
        try {
            priceService.delete(id);
            return ResponseEntity.ok("Deleted price with id = " + id);
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
