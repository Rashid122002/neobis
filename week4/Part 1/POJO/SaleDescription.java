import java.util.Objects;

public class SaleDescription {
    private int saleId;
    private String description;

    public SaleDescription() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleDescription that = (SaleDescription) o;
        return saleId == that.saleId && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saleId, description);
    }

    @Override
    public String toString() {
        return "SaleDescription{" +
                "saleId=" + saleId +
                ", description='" + description + '\'' +
                '}';
    }
}
