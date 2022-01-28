import java.util.Objects;

public class PurchaseDescription {
    private int purchaseId;
    private String description;

    public PurchaseDescription() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseDescription that = (PurchaseDescription) o;
        return purchaseId == that.purchaseId && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, description);
    }

    @Override
    public String toString() {
        return "PurchaseDescription{" +
                "purchaseId=" + purchaseId +
                ", description='" + description + '\'' +
                '}';
    }
}
