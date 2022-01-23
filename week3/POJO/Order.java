import java.util.Date;

public class Order {
    private Long id;
    private Date orderDate;
    private Client client;
    private Car car;
    private int quantity;

    public Order() {
    }

    public Order(Long id, Date orderDate, Client client, Car car, int quantity) {
        this.id = id;
        this.orderDate = orderDate;
        this.client = client;
        this.car = car;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", client=" + client +
                ", car=" + car +
                ", quantity=" + quantity +
                '}';
    }
}