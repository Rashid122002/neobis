package kg.neobis.cardealership.service;

import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.entity.Order;
import kg.neobis.cardealership.model.OrderModel;
import kg.neobis.cardealership.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static kg.neobis.cardealership.model.OrderModel.orderToOrderModel;

@Service
public class OrderService implements DAO<Order, OrderModel, Long>  {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderModel> entityListToModelList(Iterable<Order> orders) {
        List<OrderModel> orderModelList = new ArrayList<OrderModel>();
        for (Order order : orders)
        {
            orderModelList.add(orderToOrderModel(order));
        }
        return orderModelList;
    }

    @Override
    public List<OrderModel> getAll() {
        return entityListToModelList(orderRepository.findAll());
    }

    @Override
    public OrderModel getById(Long id) throws EntityNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found order: ", id));
        return orderToOrderModel(order);
    }

    @Override
    public void add(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order update(OrderModel orderModel, Long id) throws EntityNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found order: ", id));
        order.setUserId(orderModel.getUserId());
        order.setCarId(orderModel.getCarId());
        order.setPlacementDate(orderModel.getPlacementDate());
        order.setOrderNumber(orderModel.getOrderNumber());
        order.setDocumentType(orderModel.getDocumentType());
        order.setDocumentNumber(orderModel.getDocumentNumber());
        order.setAddress(orderModel.getAddress());
        order.setSaleId(orderModel.getSaleId());
        return orderRepository.save(order);
    }

    @Override
    public Long delete(Long id) throws EntityNotFoundException {
        if(!orderRepository.existsById(id)) {
            throw new EntityNotFoundException("Could not found order: ", id);
        }
        orderRepository.deleteById(id);
        return id;
    }
}
