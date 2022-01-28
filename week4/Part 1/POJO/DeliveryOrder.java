import java.util.Date;
import java.util.Objects;

public class DeliveryOrder {
    private long id;
    private String orderDescription;
    private Provider providerId;
    private Staff staffId;
    private Date placementDate;
    private Date executionDate;
    private PurchaseDescription purchaseId;

    public DeliveryOrder() {
    }

    public DeliveryOrder(long id,
                         String orderDescription,
                         Provider providerId,
                         Staff staffId,
                         Date placementDate,
                         Date executionDate,
                         PurchaseDescription purchaseId) {
        this.id = id;
        this.orderDescription = orderDescription;
        this.providerId = providerId;
        this.staffId = staffId;
        this.placementDate = placementDate;
        this.executionDate = executionDate;
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

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public PurchaseDescription getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(PurchaseDescription purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryOrder that = (DeliveryOrder) o;
        return id == that.id
                && Objects.equals(orderDescription, that.orderDescription)
                && Objects.equals(providerId, that.providerId)
                && Objects.equals(staffId, that.staffId)
                && Objects.equals(placementDate, that.placementDate)
                && Objects.equals(executionDate, that.executionDate)
                && Objects.equals(purchaseId, that.purchaseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderDescription, providerId, staffId, placementDate, executionDate, purchaseId);
    }

    @Override
    public String toString() {
        return "DeliveryOrder{" +
                "id=" + id +
                ", orderDescription='" + orderDescription + '\'' +
                ", providerId=" + providerId +
                ", staffId=" + staffId +
                ", placementDate=" + placementDate +
                ", executionDate=" + executionDate +
                ", purchaseId=" + purchaseId +
                '}';
    }
}
