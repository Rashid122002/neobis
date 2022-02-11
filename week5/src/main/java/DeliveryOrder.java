import java.util.Date;

public class DeliveryOrder {
    private Long id;
    private String orderDescription;
    private Long providerId;
    private Long staffId;
    private Date placementDate;
    private Date executionDate;
    private int purchaseId;

    public DeliveryOrder() {
    }

    public DeliveryOrder(String orderDescription, Long providerId, Long staffId, Date placementDate, Date executionDate, int purchaseId) {
        this.orderDescription = orderDescription;
        this.providerId = providerId;
        this.staffId = staffId;
        this.placementDate = placementDate;
        this.executionDate = executionDate;
        this.purchaseId = purchaseId;
    }

    public DeliveryOrder(Long id,
                         String orderDescription,
                         Long providerId,
                         Long staffId,
                         Date placementDate,
                         Date executionDate,
                         int purchaseId) {
        this.id = id;
        this.orderDescription = orderDescription;
        this.providerId = providerId;
        this.staffId = staffId;
        this.placementDate = placementDate;
        this.executionDate = executionDate;
        this.purchaseId = purchaseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
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

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
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
