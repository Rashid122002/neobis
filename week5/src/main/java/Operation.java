import java.util.Date;

public class Operation {
    private Long operationId;
    private Date operationDate;
    private Long carId;
    private Long deliveryOrderId;
    private String operationDescription;
    private double factoryPrice;
    private double costUpTo;
    private double totalAmount;

    public Operation() {
    }

    public Operation(Date operationDate, Long carId, Long deliveryOrderId, String operationDescription, double factoryPrice, double costUpTo, double totalAmount) {
        this.operationDate = operationDate;
        this.carId = carId;
        this.deliveryOrderId = deliveryOrderId;
        this.operationDescription = operationDescription;
        this.factoryPrice = factoryPrice;
        this.costUpTo = costUpTo;
        this.totalAmount = totalAmount;
    }

    public Operation(Long operationId,
                     Date operationDate,
                     Long carId,
                     Long deliveryOrderId,
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

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(Long deliveryOrderId) {
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
