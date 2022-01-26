import java.util.Date;

public class DeliveryOrder {
    private long id;
    private String orderDescription;
    private Provider providerId;
    private Staff staffId;
    private Date dateOfPlacement;
    private Date dateOfExecution;
    private DescriptionOfPurchase purchaseId;

    public DeliveryOrder(long id,
                         String orderDescription,
                         Provider providerId,
                         Staff staffId,
                         Date dateOfPlacement,
                         Date dateOfExecution,
                         DescriptionOfPurchase purchaseId) {
        this.id = id;
        this.orderDescription = orderDescription;
        this.providerId = providerId;
        this.staffId = staffId;
        this.dateOfPlacement = dateOfPlacement;
        this.dateOfExecution = dateOfExecution;
        this.purchaseId = purchaseId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Provider getProviderId() {
        return providerId;
    }

    public void setProviderId(Provider providerId) {
        this.providerId = providerId;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Date getDateOfPlacement() {
        return dateOfPlacement;
    }

    public void setDateOfPlacement(Date dateOfPlacement) {
        this.dateOfPlacement = dateOfPlacement;
    }

    public Date getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(Date dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public DescriptionOfPurchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(DescriptionOfPurchase purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "id=" + id +
                ", orderDescription='" + orderDescription + '\'' +
                ", providerId=" + providerId +
                ", staffId=" + staffId +
                ", dateOfPlacement=" + dateOfPlacement +
                ", dateOfExecution=" + dateOfExecution +
                ", purchaseId=" + purchaseId +
                '}';
    }
}
