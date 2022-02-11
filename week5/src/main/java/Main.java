import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------------Table purchase_descriptions-------------");
        PurchaseDescriptionsDBHandler purchaseDescriptionsDBHandler = new PurchaseDescriptionsDBHandler();
        PurchaseDescription purchaseDescription1 = new PurchaseDescription("Заказано");
        PurchaseDescription purchaseDescription2 = new PurchaseDescription("Поставлено");
        PurchaseDescription purchaseDescription3 = new PurchaseDescription("Возвращено");
        PurchaseDescription purchaseDescription4 = new PurchaseDescription("dsagfdgdsg");
        purchaseDescriptionsDBHandler.add(purchaseDescription1);
        purchaseDescriptionsDBHandler.add(purchaseDescription2);
        purchaseDescriptionsDBHandler.add(purchaseDescription3);
        purchaseDescriptionsDBHandler.add(purchaseDescription4);
        List<PurchaseDescription> purchaseDescriptions = purchaseDescriptionsDBHandler.getAll();
        for(PurchaseDescription purchaseDescription : purchaseDescriptions) {
            System.out.println(purchaseDescription);
        }
        PurchaseDescription purchaseDescription5 = purchaseDescriptionsDBHandler.getById(3);
        purchaseDescription5.setDescription("Возврат");
        purchaseDescriptionsDBHandler.update(purchaseDescription5);
        purchaseDescriptions = purchaseDescriptionsDBHandler.getAll();
        for(PurchaseDescription purchaseDescription : purchaseDescriptions) {
            System.out.println(purchaseDescription);
        }
        purchaseDescriptionsDBHandler.delete(4);
        purchaseDescriptions = purchaseDescriptionsDBHandler.getAll();
        for(PurchaseDescription purchaseDescription : purchaseDescriptions) {
            System.out.println(purchaseDescription);
        }

        System.out.println("\n-------------Table sale_descriptions-------------");
        SaleDescriptionsDBHandler saleDescriptionsDBHandler = new SaleDescriptionsDBHandler();
        SaleDescription saleDescription = new SaleDescription("В наличии");
        SaleDescription saleDescription1= new SaleDescription("Продано");
        SaleDescription saleDescription2 = new SaleDescription("Возвращено");
        SaleDescription saleDescription3 = new SaleDescription("аыврыврыа");
        saleDescriptionsDBHandler.add(saleDescription);
        saleDescriptionsDBHandler.add(saleDescription1);
        saleDescriptionsDBHandler.add(saleDescription2);
        saleDescriptionsDBHandler.add(saleDescription3);
        List<SaleDescription> saleDescriptions = saleDescriptionsDBHandler.getAll();
        for (SaleDescription s : saleDescriptions) {
            System.out.println(s);
        }
        SaleDescription saleDescription4 = saleDescriptionsDBHandler.getById(3);
        saleDescriptionsDBHandler.update(saleDescription4);
        saleDescriptions = saleDescriptionsDBHandler.getAll();
        for (SaleDescription s : saleDescriptions) {
            System.out.println(s);
        }
        saleDescriptionsDBHandler.delete(4);
        saleDescriptions = saleDescriptionsDBHandler.getAll();
        for (SaleDescription s : saleDescriptions) {
            System.out.println(s);
        }

        System.out.println("\n-------------Table prices-------------");
        PricesDBHandler pricesDBHandler = new PricesDBHandler();
        Price price1 = new Price(1000_000);
        Price price2 = new Price(2000_000);
        pricesDBHandler.add(price1);
        pricesDBHandler.add(price2);
        List<Price> prices = pricesDBHandler.getAll();
        for(Price price : prices) {
            System.out.println(price);
        }
        Price price3 = pricesDBHandler.getById(2);
        price3.setSalePrice(2500_500);
        pricesDBHandler.update(price3);
        prices = pricesDBHandler.getAll();
        for(Price price : prices) {
            System.out.println(price);
        }
        pricesDBHandler.delete(2);
        prices = pricesDBHandler.getAll();
        for(Price price : prices) {
            System.out.println(price);
        }

        System.out.println("\n-------------Table cars-------------");
        CarsDBHandler carsDBHandler = new CarsDBHandler();
        Car car1 = new Car("Mersedes 500 E", "B 3342 DD", Date.valueOf("1999-02-02"),
                "5.0", "Black", 1, "Хорошее состояние");
        Car car2 = new Car("Toyota Camry", "T 5466 AA", Date.valueOf("2019-01-01"),
                "4.5", "White", 1, "Отличное состояние");
        carsDBHandler.add(car1);
        carsDBHandler.add(car2);
        List<Car> cars = carsDBHandler.getAll();
        for(Car car : cars) {
            System.out.println(car);
        }
        Car car3 = carsDBHandler.getById(2L);
        car3.setCarBrand("Toyota Land Cruiser 300");
        carsDBHandler.update(car3);
        cars = carsDBHandler.getAll();
        for(Car car : cars) {
            System.out.println(car);
        }
        carsDBHandler.delete(2L);
        cars = carsDBHandler.getAll();
        for(Car car : cars) {
            System.out.println(car);
        }

        System.out.println("\n-------------Table providers-------------");
        ProvidersDBHandler providersDBHandler = new ProvidersDBHandler();
        Provider provider1 = new Provider("Mercedes", "Алымбеков Алим",
                "Управляющий", "ул. Западная 66", "Бишкек", "4326425463456", "3425246236534", "чек");
        Provider provider2 = new Provider("Toyota", "Жаныбеков Элдос",
                "Менеджер", "ул. Киевская 506", "Бишкек", "54353645654", "35636346543643", "чек");
        providersDBHandler.add(provider1);
        providersDBHandler.add(provider2);
        List<Provider> providers = providersDBHandler.getAll();
        for(Provider provider : providers) {
            System.out.println(provider);
        }
        Provider provider3 = providersDBHandler.getById(2L);
        provider3.setCompanyName("Nissan");
        providersDBHandler.update(provider3);
        providers = providersDBHandler.getAll();
        for(Provider provider : providers) {
            System.out.println(provider);
        }
        providersDBHandler.delete(2L);
        providers = providersDBHandler.getAll();
        for(Provider provider : providers) {
            System.out.println(provider);
        }

        System.out.println("\n-------------Table clients-------------");
        ClientDBHandler clientDBHandler = new ClientDBHandler();
        Client client1 = new Client("Nazarbekov", "Rashid", "364563463456", "Let's go");
        Client client2 = new Client("Belekov", "Urmat", "7458972857", "dfsfgds");
        clientDBHandler.add(client1);
        clientDBHandler.add(client2);
        List<Client> clientList = clientDBHandler.getAll();
        for(Client client : clientList) {
            System.out.println(client);
        }
        Client client3 = clientDBHandler.getById(2L);
        client3.setLastName("Mirbekov");
        clientDBHandler.update(client3);
        clientList = clientDBHandler.getAll();
        for(Client client : clientList) {
            System.out.println(client);
        }
        clientDBHandler.delete(2L);
        clientList = clientDBHandler.getAll();
        for(Client client : clientList) {
            System.out.println(client);
        }

        System.out.println("\n-------------Table staff-------------");
        StaffDBHandler staffDBHandler = new StaffDBHandler();
        Staff staff1 = new Staff("Ян", "Петр", "Менеджер", "845728572890");
        Staff staff2 = new Staff("Коваль", "Павел", "Бухгалтер", "464536465643");
        Staff staff3 = new Staff("Куттубаев", "Адилет", "Консультант", "423542364356");
        staffDBHandler.add(staff1);
        staffDBHandler.add(staff2);
        staffDBHandler.add(staff3);
        List<Staff> staffs = staffDBHandler.getAll();
        for(Staff staff : staffs) {
            System.out.println(staff);
        }
        Staff staff4 = staffDBHandler.getById(1L);
        staff4.setLastName("Бакиев");
        staff4.setFirstName("Эркин");
        staffDBHandler.update(staff4);
        staffs = staffDBHandler.getAll();
        for(Staff staff : staffs) {
            System.out.println(staff);
        }
        staffDBHandler.delete(2L);
        staffs = staffDBHandler.getAll();
        for(Staff staff : staffs) {
            System.out.println(staff);
        }

        System.out.println("\n-------------Table delivery_orders-------------");
        DeliveryOrderDBHandler deliveryOrderDBHandler = new DeliveryOrderDBHandler();
        DeliveryOrder deliveryOrder1 = new DeliveryOrder("", 1L, 1L, Date.valueOf("2022-02-08"), Date.valueOf("2022-02-10"), 1);
        DeliveryOrder deliveryOrder2 = new DeliveryOrder("", 1L, 1L, Date.valueOf("2022-02-08"), Date.valueOf("2022-02-10"), 2);
        deliveryOrderDBHandler.add(deliveryOrder1);
        deliveryOrderDBHandler.add(deliveryOrder2);
        List<DeliveryOrder> deliveryOrders = deliveryOrderDBHandler.getAll();
        for(DeliveryOrder deliveryOrder : deliveryOrders) {
            System.out.println(deliveryOrder);
        }
        DeliveryOrder deliveryOrder3 = deliveryOrderDBHandler.getById(2L);
        deliveryOrder3.setPurchaseId(2);
        deliveryOrderDBHandler.update(deliveryOrder3);
        for(DeliveryOrder deliveryOrder : deliveryOrders) {
            System.out.println(deliveryOrder);
        }
        deliveryOrderDBHandler.delete(2L);
        for(DeliveryOrder deliveryOrder : deliveryOrders) {
            System.out.println(deliveryOrder);
        }

        System.out.println("\n-------------Table operations-------------");
        OperationsDBHandler operationsDBHandler = new OperationsDBHandler();
        Operation operation1 = new Operation(Date.valueOf("2022-02-07"), 1L, 1L, "", 500000, 800000, 1000000);
        Operation operation2 = new Operation(Date.valueOf("2022-02-07"), 1L, 1L, "", 500000, 800000, 1000000);
        operationsDBHandler.add(operation1);
        operationsDBHandler.add(operation2);
        List<Operation> operations = operationsDBHandler.getAll();
        for(Operation operation : operations) {
            System.out.println(operation);
        }
        Operation operation3 = operationsDBHandler.getById(2L);
        operation3.setFactoryPrice(700000);
        operation3.setCostUpTo(900000);
        operation3.setTotalAmount(1200000);
        operationsDBHandler.update(operation3);
        for(Operation operation : operations) {
            System.out.println(operation);
        }
        operationsDBHandler.delete(2L);
        for(Operation operation : operations) {
            System.out.println(operation);
        }

        System.out.println("\n-------------Table orders-------------");
        OrdersDBHandler ordersDBHandler = new OrdersDBHandler();
        Order order1 = new Order(1L, 1L, Date.valueOf("2022-02-10"), "1", "Passport", "324522332", "st. Chyi 88", 1);
        Order order2 = new Order(1L, 1L, Date.valueOf("2022-02-10"), "2", "Passport", "654364643", "st. Chyi 88", 2);
        ordersDBHandler.add(order1);
        ordersDBHandler.add(order2);
        List<Order> orders = ordersDBHandler.getAll();
        for(Order order : orders) {
            System.out.println(order);
        }
        Order order3 = ordersDBHandler.getById(2L);
        order3.setSaleId(3);
        ordersDBHandler.update(order3);
        for(Order order : orders) {
            System.out.println(order);
        }
        ordersDBHandler.delete(2L);
        for(Order order : orders) {
            System.out.println(order);
        }
    }
}
