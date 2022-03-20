package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.DeliveryOrder;
import kg.neobis.cardealership.entity.Provider;
import kg.neobis.cardealership.entity.PurchaseDescription;
import kg.neobis.cardealership.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryOrderModel {
    private Long deliveryOrderId;
    private String orderDescription;
    private Provider providerId;
    private Staff staffId;
    private LocalDate placementDate;
    private LocalDate executionDate;
    private PurchaseDescription purchaseId;

    public static DeliveryOrderModel deliveryOrderToDeliveryOrderModel(DeliveryOrder deliveryOrder) {
        DeliveryOrderModel deliveryOrderModel = new DeliveryOrderModel();
        deliveryOrderModel.setDeliveryOrderId(deliveryOrder.getDeliveryOrderId());
        deliveryOrderModel.setOrderDescription(deliveryOrder.getOrderDescription());
        deliveryOrderModel.setProviderId(deliveryOrder.getProviderId());
        deliveryOrderModel.setStaffId(deliveryOrder.getStaffId());
        deliveryOrderModel.setPlacementDate(deliveryOrder.getPlacementDate());
        deliveryOrderModel.setExecutionDate(deliveryOrder.getExecutionDate());
        deliveryOrderModel.setPurchaseId(deliveryOrder.getPurchaseId());
        return deliveryOrderModel;
    }
}
