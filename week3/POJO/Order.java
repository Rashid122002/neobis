import java.util.Date;
import java.util.Objects;

public class Order {
    private long orderId;
    private Client clientId;
    private Car carId;
    private Date placementDate;
    private String orderNumber;
    private String documentType;
    private String documentNumber;
    private String address;
    private SaleDescription saleId;

    public Order() {
    }

    public Order(long orderId,
                 Client clientId,
                 Car carId,
                 Date placementDate,
                 String orderNumber,
                 String documentType,
                 String documentNumber,
                 String address,
                 SaleDescription saleId) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.carId = carId;
        this.placementDate = placementDate;
        this.orderNumber = orderNumber;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.address = address;
        this.saleId = saleId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SaleDescription getSaleId() {
        return saleId;
    }

    public void setSaleId(SaleDescription saleId) {
        this.saleId = saleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId
                && Objects.equals(clientId, order.clientId)
                && Objects.equals(carId, order.carId)
                && Objects.equals(placementDate, order.placementDate)
                && Objects.equals(orderNumber, order.orderNumber)
                && Objects.equals(documentType, order.documentType)
                && Objects.equals(documentNumber, order.documentNumber)
                && Objects.equals(address, order.address)
                && Objects.equals(saleId, order.saleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, clientId, carId, placementDate, orderNumber, documentType, documentNumber, address, saleId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", carId=" + carId +
                ", placementDate=" + placementDate +
                ", orderNumber='" + orderNumber + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", address='" + address + '\'' +
                ", saleId=" + saleId +
                '}';
    }
}
