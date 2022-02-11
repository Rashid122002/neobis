public class PurchaseDescription {
    private int purchaseId;
    private String description;

    public PurchaseDescription() {
    }

    public PurchaseDescription(String description) {
        this.description = description;
    }

    public PurchaseDescription(int purchaseId, String description) {
        this.purchaseId = purchaseId;
        this.description = description;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PurchaseDescription{" +
                "purchaseId=" + purchaseId +
                ", description='" + description + '\'' +
                '}';
    }
}
