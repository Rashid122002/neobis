package kg.neobis.cardealership.Controller;

import kg.neobis.cardealership.Model.DeliveryOrder;
import kg.neobis.cardealership.Service.DeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/deliveryorders")
public class DeliveryOrderController {
    private final DeliveryOrderService deliveryOrderService;

    @Autowired
    public DeliveryOrderController(DeliveryOrderService deliveryOrderService) {
        this.deliveryOrderService = deliveryOrderService;
    }

    @GetMapping
    public List<DeliveryOrder> getDeliveryOrders() {
        return deliveryOrderService.all();
    }

    @GetMapping("/{id}")
    public DeliveryOrder getDeliveryOrderById(@PathVariable Long id) {
        return deliveryOrderService.getDeliveryOrderById(id);
    }

    @PostMapping
    public void registerNewDeliveryOrder(@RequestBody DeliveryOrder newDeliveryOrder) {
        deliveryOrderService.addNewDeliveryOrder(newDeliveryOrder);
    }

    @PutMapping("/{id}")
    public DeliveryOrder replaceDeliveryOrder(@RequestBody DeliveryOrder newDeliveryOrder, @PathVariable Long id) {
        return deliveryOrderService.replaceDeliveryOrder(newDeliveryOrder, id);
    }

    @DeleteMapping("/{id}")
    public void deleteDeliveryOrder(@PathVariable Long id) {
        deliveryOrderService.deleteDeliveryOrderById(id);
    }
}
