package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.DeliveryOrder;
import kg.neobis.cardealership.Repository.DeliveryOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DeliveryOrderService {
    private DeliveryOrderRepository deliveryOrderRepository;

    public DeliveryOrderService(DeliveryOrderRepository deliveryOrderRepository) {
        this.deliveryOrderRepository = deliveryOrderRepository;
    }

    public List<DeliveryOrder> all() {
        return deliveryOrderRepository.findAll();
    }

    public DeliveryOrder getDeliveryOrderById(Long id) {
        return deliveryOrderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find delivery order ", id));
    }

    public void addNewDeliveryOrder(@RequestBody DeliveryOrder newDeliveryOrder) {
        deliveryOrderRepository.save(newDeliveryOrder);
    }

    public DeliveryOrder replaceDeliveryOrder(@RequestBody DeliveryOrder newDeliveryOrder, @PathVariable Long id) {
        return deliveryOrderRepository.findById(id)
                .map(deliveryOrder -> {
                    deliveryOrder.setOrderDescription(newDeliveryOrder.getOrderDescription());
                    deliveryOrder.setProviderId(newDeliveryOrder.getProviderId());
                    deliveryOrder.setStaffId(newDeliveryOrder.getStaffId());
                    deliveryOrder.setPlacementDate(newDeliveryOrder.getPlacementDate());
                    deliveryOrder.setExecutionDate(newDeliveryOrder.getExecutionDate());
                    deliveryOrder.setPurchaseId(newDeliveryOrder.getPurchaseId());
                    return deliveryOrderRepository.save(deliveryOrder);
                })
                .orElseGet(() -> {
                    newDeliveryOrder.setDeliveryOrderId(id);
                    return deliveryOrderRepository.save(newDeliveryOrder);
                });
    }

    public void deleteDeliveryOrderById(@PathVariable Long id) {
        boolean exists = deliveryOrderRepository.existsById(id);
        if (!exists) {
            throw new EntityNotFoundException("Could not find delivery order ", id);
        }
    }
}
