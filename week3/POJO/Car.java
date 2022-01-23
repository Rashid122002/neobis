public class Car {
    private Long id;
    private String manufacturer;
    private String modelName;
    private String color;
    private String transmisson;
    private String carType;
    private double price;

    public Car() {
    }

    public Car(Long id, String manufacturer, String modelName, String color, String transmisson, String carType, double price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.color = color;
        this.transmisson = transmisson;
        this.carType = carType;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmisson() {
        return transmisson;
    }

    public void setTransmisson(String transmisson) {
        this.transmisson = transmisson;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public java.lang.String toString() {
        return "Car{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", color='" + color + '\'' +
                ", transmisson='" + transmisson + '\'' +
                ", carType='" + carType + '\'' +
                ", price=" + price +
                '}';
    }
}