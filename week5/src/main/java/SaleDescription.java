public class SaleDescription {
    private int saleId;
    private String description;

    public SaleDescription() {
    }

    public SaleDescription(String description) {
        this.description = description;
    }

    public SaleDescription(int saleId, String description) {
        this.saleId = saleId;
        this.description = description;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SaleDescription{" +
                "saleId=" + saleId +
                ", description='" + description + '\'' +
                '}';
    }
}
