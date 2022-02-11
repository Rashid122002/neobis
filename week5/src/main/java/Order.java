import java.util.Date;

public class Order {
    private Long orderId;
    private Long clientId;
    private Long carId;
    private Date placementDate;
    private String orderNumber;
    private String documentType;
    private String documentNumber;
    private String address;
    private int saleId;

    public Order() {
    }

    public Order(Long clientId, Long carId, Date placementDate, String orderNumber, String documentType, String documentNumber, String address, int saleId) {
        this.clientId = clientId;
        this.carId = carId;
        this.placementDate = placementDate;
        this.orderNumber = orderNumber;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.address = address;
        this.saleId = saleId;
    }

    public Order(Long orderId,
                 Long clientId,
                 Long carId,
                 Date placementDate,
                 String orderNumber,
                 String documentType,
                 String documentNumber,
                 String address,
                 int saleId) {
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
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

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
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