package kg.neobis.cardealership.service;

import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.entity.DeliveryOrder;
import kg.neobis.cardealership.model.DeliveryOrderModel;
import kg.neobis.cardealership.repository.DeliveryOrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static kg.neobis.cardealership.model.DeliveryOrderModel.deliveryOrderToDeliveryOrderModel;

@Service
public class DeliveryOrderService implements DAO<DeliveryOrder, DeliveryOrderModel, Long>  {
    private DeliveryOrderRepository deliveryOrderRepository;

    public DeliveryOrderService(DeliveryOrderRepository deliveryOrderRepository) {
        this.deliveryOrderRepository = deliveryOrderRepository;
    }

    @Override
    public List<DeliveryOrderModel> entityListToModelList(Iterable<DeliveryOrder> deliveryOrders) {
        List<DeliveryOrderModel> deliveryOrderModelList = new ArrayList<>();
        for (DeliveryOrder deliveryOrder : deliveryOrders)
        {
            deliveryOrderModelList.add(deliveryOrderToDeliveryOrderModel(deliveryOrder));
        }
        return deliveryOrderModelList;
    }

    @Override
    public List<DeliveryOrderModel> getAll() {
        return entityListToModelList(deliveryOrderRepository.findAll());
    }

    @Override
    public DeliveryOrderModel getById(Long id) throws EntityNotFoundException {
        DeliveryOrder deliveryOrder = deliveryOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found delivery order: ", id));
        return deliveryOrderToDeliveryOrderModel(deliveryOrder);
    }

    @Override
    public void add(DeliveryOrder deliveryOrder) {
        deliveryOrderRepository.save(deliveryOrder);
    }

    @Override
    public DeliveryOrder update(DeliveryOrderModel deliveryOrderModel, Long id) throws EntityNotFoundException {
        DeliveryOrder deliveryOrder = deliveryOrderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found delivery order: ", id));
        deliveryOrder.setOrderDescription(deliveryOrderModel.getOrderDescription());
        deliveryOrder.setProviderId(deliveryOrderModel.getProviderId());
        deliveryOrder.setStaffId(deliveryOrderModel.getStaffId());
        deliveryOrder.setPlacementDate(deliveryOrderModel.getPlacementDate());
        deliveryOrder.setExecutionDate(deliveryOrderModel.getExecutionDate());
        deliveryOrder.setPurchaseId(deliveryOrderModel.getPurchaseId());
        return deliveryOrderRepository.save(deliveryOrder);
    }

    @Override
    public Long delete(Long id) throws EntityNotFoundException {
        if(!deliveryOrderRepository.existsById(id)) {
            throw new EntityNotFoundException("Could not found delivery order: ", id);
        }
        deliveryOrderRepository.deleteById(id);
        return id;
    }
}
