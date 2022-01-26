import java.util.Date;

public class Order {
    private long orderId;
    private Client clientId;
    private Car carId;
    private Date dateOfPlacement;
    private String orderNumber;
    private String typeOfDocument;
    private String documentNumber;
    private String address;
    private DescriptionOfSale saleId;

    public Order() {
    }

    public Order(long orderId,
                 Client clientId,
                 Car carId,
                 Date dateOfPlacement,
                 String orderNumber,
                 String typeOfDocument,
                 String documentNumber,
                 String address,
                 DescriptionOfSale saleId) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.carId = carId;
        this.dateOfPlacement = dateOfPlacement;
        this.orderNumber = orderNumber;
        this.typeOfDocument = typeOfDocument;
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

    public Date getDateOfPlacement() {
        return dateOfPlacement;
    }

    public void setDateOfPlacement(Date dateOfPlacement) {
        this.dateOfPlacement = dateOfPlacement;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
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

    public DescriptionOfSale getSaleId() {
        return saleId;
    }

    public void setSaleId(DescriptionOfSale saleId) {
        this.saleId = saleId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", carId=" + carId +
                ", dateOfPlacement=" + dateOfPlacement +
                ", orderNumber='" + orderNumber + '\'' +
                ", typeOfDocument='" + typeOfDocument + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", address='" + address + '\'' +
                ", saleId=" + saleId +
                '}';
    }
}
