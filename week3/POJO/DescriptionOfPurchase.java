public class DescriptionOfPurchase {
    private int purchaseId;
    private String descriptionOfPurchase;

    public DescriptionOfPurchase() {
    }

    public DescriptionOfPurchase(int purchaseId, String descriptionOfPurchase) {
        this.purchaseId = purchaseId;
        this.descriptionOfPurchase = descriptionOfPurchase;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getDescriptionOfPurchase() {
        return descriptionOfPurchase;
    }

    public void setDescriptionOfPurchase(String descriptionOfPurchase) {
        this.descriptionOfPurchase = descriptionOfPurchase;
    }

    @Override
    public String toString() {
        return "DescriptionOfPurchase{" +
                "purchaseId=" + purchaseId +
                ", descriptionOfPurchase='" + descriptionOfPurchase + '\'' +
                '}';
    }
}
