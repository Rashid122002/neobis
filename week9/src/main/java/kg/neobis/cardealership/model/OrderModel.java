package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.Car;
import kg.neobis.cardealership.entity.Order;
import kg.neobis.cardealership.entity.SaleDescription;
import kg.neobis.cardealership.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    private Long orderId;
    private User userId;
    private Car carId;
    private LocalDate placementDate;
    private String orderNumber;
    private String documentType;
    private String documentNumber;
    private String address;
    private SaleDescription saleId;

    public static OrderModel orderToOrderModel(Order order) {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderId(order.getOrderId());
        orderModel.setUserId(order.getUserId());
        orderModel.setCarId(order.getCarId());
        orderModel.setPlacementDate(order.getPlacementDate());
        orderModel.setOrderNumber(order.getOrderNumber());
        orderModel.setDocumentType(order.getDocumentType());
        orderModel.setDocumentNumber(order.getDocumentNumber());
        orderModel.setAddress(order.getAddress());
        orderModel.setSaleId(order.getSaleId());
        return orderModel;
    }
}
