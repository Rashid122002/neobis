import java.sql.Date;

public class Car {
    private Long carId;
    private String carBrand;
    private String serialNumber;
    private Date yearOfManufacture;
    private String engineCapacity;
    private String carColor;
    private int priceId;
    private String notes;

    public Car() {
    }

    public Car(String carBrand, String serialNumber, Date yearOfManufacture, String engineCapacity, String carColor, int priceId, String notes) {
        this.carBrand = carBrand;
        this.serialNumber = serialNumber;
        this.yearOfManufacture = yearOfManufacture;
        this.engineCapacity = engineCapacity;
        this.carColor = carColor;
        this.priceId = priceId;
        this.notes = notes;
    }

    public Car(Long carId,
               String carBrand,
               String serialNumber,
               Date yearOfManufacture,
               String engineCapacity,
               String carColor,
               int priceId,
               String notes) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.serialNumber = serialNumber;
        this.yearOfManufacture = yearOfManufacture;
        this.engineCapacity = engineCapacity;
        this.carColor = carColor;
        this.priceId = priceId;
        this.notes = notes;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Date yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carBrand='" + carBrand + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", engineCapacity=" + engineCapacity +
                ", carColor='" + carColor + '\'' +
                ", priceId=" + priceId +
                ", notes='" + notes + '\'' +
                '}';
    }
}
