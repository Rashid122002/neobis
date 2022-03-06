package kg.neobis.cardealership.Controller;

import kg.neobis.cardealership.Model.Order;
import kg.neobis.cardealership.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.all();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public void registerNewOrder(@RequestBody Order newOrder) {
        orderService.addNewOrder(newOrder);
    }

    @PutMapping("/{id}")
    public Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {
        return orderService.replaceOrder(newOrder, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
}
