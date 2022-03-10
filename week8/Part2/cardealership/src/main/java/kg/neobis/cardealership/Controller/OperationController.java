package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.entity.Operation;
import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.model.OperationModel;
import kg.neobis.cardealership.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/operations")
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public ResponseEntity<?> getOperations() {
        try{
            return ResponseEntity.ok(operationService.getAll());
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOperationById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(operationService.getById(id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewOperation(@RequestBody Operation newOperation) {
        try {
            operationService.add(newOperation);
            return ResponseEntity.ok("Operation was added successfully");
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceOperation(@RequestBody OperationModel operationModel, @PathVariable Long id) {
        try{
            return ResponseEntity.ok(operationService.update(operationModel, id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOperation(@PathVariable Long id) {
        try {
            operationService.delete(id);
            return ResponseEntity.ok("Deleted operation with id = " + id);
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
