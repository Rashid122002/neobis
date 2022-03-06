package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.Order;
import kg.neobis.cardealership.Repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> all() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find order ", id));
    }

    public void addNewOrder(@RequestBody Order newOrder) {
        orderRepository.save(newOrder);
    }

    public Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setClientId(newOrder.getClientId());
                    order.setCarId(newOrder.getCarId());
                    order.setPlacementDate(newOrder.getPlacementDate());
                    order.setOrderNumber(newOrder.getOrderNumber());
                    order.setDocumentType(newOrder.getDocumentType());
                    order.setDocumentNumber(newOrder.getDocumentNumber());
                    order.setAddress(newOrder.getAddress());
                    order.setSaleId(newOrder.getSaleId());
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setOrderId(id);
                    return orderRepository.save(newOrder);
                });
    }

    public void deleteOrderById(@PathVariable Long id) {
        boolean exists = orderRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Could not find order ", id);
        }
        orderRepository.deleteById(id);
    }
}
