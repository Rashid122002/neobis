import java.util.Date;
import java.util.Objects;

public class Operation {
    private long operationId;
    private Date operationDate;
    private Car carId;
    private DeliveryOrder deliveryOrderId;
    private String operationDescription;
    private double factoryPrice;
    private double costUpTo;
    private double totalAmount;

    public Operation() {
    }

    public Operation(long operationId,
                     Date operationDate,
                     Car carId,
                     DeliveryOrder deliveryOrderId,
                     String operationDescription,
                     double factoryPrice,
                     double costUpTo,
                     double totalAmount) {
        this.operationId = operationId;
        this.operationDate = operationDate;
        this.carId = carId;
        this.deliveryOrderId = deliveryOrderId;
        this.operationDescription = operationDescription;
        this.factoryPrice = factoryPrice;
        this.costUpTo = costUpTo;
        this.totalAmount = totalAmount;
    }

    public long getOperationId() {
        return operationId;
    }

    public void setOperationId(long operationId) {
        this.operationId = operationId;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public DeliveryOrder getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(DeliveryOrder deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public double getFactoryPrice() {
        return factoryPrice;
    }

    public void setFactoryPrice(double factoryPrice) {
        this.factoryPrice = factoryPrice;
    }

    public double getCostUpTo() {
        return costUpTo;
    }

    public void setCostUpTo(double costUpTo) {
        this.costUpTo = costUpTo;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationId == operation.operationId
                && Double.compare(operation.factoryPrice, factoryPrice) == 0
                && Double.compare(operation.costUpTo, costUpTo) == 0
                && Double.compare(operation.totalAmount, totalAmount) == 0
                && Objects.equals(operationDate, operation.operationDate)
                && Objects.equals(carId, operation.carId)
                && Objects.equals(deliveryOrderId, operation.deliveryOrderId)
                && Objects.equals(operationDescription, operation.operationDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, operationDate, carId, deliveryOrderId, operationDescription, factoryPrice, costUpTo, totalAmount);
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationId=" + operationId +
                ", operationDate=" + operationDate +
                ", carId=" + carId +
                ", deliveryOrderId=" + deliveryOrderId +
                ", operationDescription='" + operationDescription + '\'' +
                ", factoryPrice=" + factoryPrice +
                ", costUpTo=" + costUpTo +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
