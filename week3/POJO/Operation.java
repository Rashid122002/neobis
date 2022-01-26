import java.util.Date;

public class Operation {
    private long transactionId;
    private Date dateOfOperation;
    private Car carId;
    private DeliveryOrder deliveryOrderId;
    private String descriptionOfOperation;
    private double factoryPrice;
    private double costUpTo;
    private double totalAmount;

    public Operation() {
    }

    public Operation(long transactionId,
                     Date dateOfOperation,
                     Car carId,
                     DeliveryOrder deliveryOrderId,
                     String descriptionOfOperation,
                     double factoryPrice,
                     double costUpTo,
                     double totalAmount) {
        this.transactionId = transactionId;
        this.dateOfOperation = dateOfOperation;
        this.carId = carId;
        this.deliveryOrderId = deliveryOrderId;
        this.descriptionOfOperation = descriptionOfOperation;
        this.factoryPrice = factoryPrice;
        this.costUpTo = costUpTo;
        this.totalAmount = totalAmount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDateOfOperation() {
        return dateOfOperation;
    }

    public void setDateOfOperation(Date dateOfOperation) {
        this.dateOfOperation = dateOfOperation;
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

    public String getDescriptionOfOperation() {
        return descriptionOfOperation;
    }

    public void setDescriptionOfOperation(String descriptionOfOperation) {
        this.descriptionOfOperation = descriptionOfOperation;
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
                "transactionId=" + transactionId +
                ", dateOfOperation=" + dateOfOperation +
                ", carId=" + carId +
                ", deliveryOrderId=" + deliveryOrderId +
                ", descriptionOfOperation='" + descriptionOfOperation + '\'' +
                ", factoryPrice=" + factoryPrice +
                ", costUpTo=" + costUpTo +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
