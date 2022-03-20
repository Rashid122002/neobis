package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.Car;
import kg.neobis.cardealership.entity.DeliveryOrder;
import kg.neobis.cardealership.entity.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationModel {
    private Long operationId;
    private LocalDate operationDate;
    private Car carId;
    private DeliveryOrder deliveryOrderId;
    private String operationDescription;
    private double factoryPrice;
    private double costUpTo;
    private double totalAmount;

    public static OperationModel operationToOperationModel(Operation operation) {
        OperationModel operationModel = new OperationModel();
        operationModel.setOperationId(operation.getOperationId());
        operationModel.setOperationDate(operation.getOperationDate());
        operationModel.setCarId(operation.getCarId());
        operationModel.setDeliveryOrderId(operation.getDeliveryOrderId());
        operationModel.setOperationDescription(operation.getOperationDescription());
        operationModel.setFactoryPrice(operation.getFactoryPrice());
        operationModel.setCostUpTo(operation.getCostUpTo());
        operationModel.setTotalAmount(operation.getTotalAmount());
        return operationModel;
    }
}
