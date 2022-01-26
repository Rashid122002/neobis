public class DescriptionOfSale {
    private int saleId;
    private String descriptionOfSale;

    public DescriptionOfSale() {
    }

    public DescriptionOfSale(int saleId, String descriptionOfSale) {
        this.saleId = saleId;
        this.descriptionOfSale = descriptionOfSale;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getDescriptionOfSale() {
        return descriptionOfSale;
    }

    public void setDescriptionOfSale(String descriptionOfSale) {
        this.descriptionOfSale = descriptionOfSale;
    }

    @Override
    public String toString() {
        return "DescriptionOfSale{" +
                "saleId=" + saleId +
                ", descriptionOfSale='" + descriptionOfSale + '\'' +
                '}';
    }
}
