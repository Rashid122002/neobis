public class Price {
    private int priceId;
    private double salePrice;

    public Price() {
    }

    public Price(int priceId, double salePrice) {
        this.priceId = priceId;
        this.salePrice = salePrice;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Price{" +
                "priceId=" + priceId +
                ", salePrice=" + salePrice +
                '}';
    }
}
