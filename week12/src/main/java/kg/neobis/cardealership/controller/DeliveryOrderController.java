package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.entity.DeliveryOrder;
import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.model.DeliveryOrderModel;
import kg.neobis.cardealership.service.DeliveryOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/deliveryorders")
public class DeliveryOrderController {
    private final DeliveryOrderService deliveryOrderService;

    public DeliveryOrderController(DeliveryOrderService deliveryOrderService) {
        this.deliveryOrderService = deliveryOrderService;
    }

    @GetMapping
    public ResponseEntity<?> getDeliveryOrders() {
        try{
            return ResponseEntity.ok(deliveryOrderService.getAll());
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeliveryOrderById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(deliveryOrderService.getById(id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewDeliveryOrder(@RequestBody DeliveryOrder newDeliveryOrder) {
        try {
            deliveryOrderService.add(newDeliveryOrder);
            return ResponseEntity.ok("Delivery order was added successfully");
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replaceDeliveryOrder(@RequestBody DeliveryOrderModel deliveryOrderModel, @PathVariable Long id) {
        try{
            return ResponseEntity.ok(deliveryOrderService.update(deliveryOrderModel, id));
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDeliveryOrder(@PathVariable Long id) {
        try {
            deliveryOrderService.delete(id);
            return ResponseEntity.ok("Deleted delivery order with id = " + id);
        } catch (EntityNotFoundException cnfe) {
            return new ResponseEntity(cnfe.getMessage(), cnfe.getNOT_FOUND_STATUS());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
