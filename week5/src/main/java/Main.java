import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------------Table purchase_descriptions-------------");
        PurchaseDescriptionsDBHandler purchaseDescriptionsDBHandler = new PurchaseDescriptionsDBHandler();
        purchaseDescriptionsDBHandler.insertPurchaseDescription("Заказано");
        purchaseDescriptionsDBHandler.insertPurchaseDescription("Поставлено");
        purchaseDescriptionsDBHandler.insertPurchaseDescription("Возвращено");
        purchaseDescriptionsDBHandler.insertPurchaseDescription("dsagfdgdsg");
        purchaseDescriptionsDBHandler.selectPurchaseDescriptions();
        purchaseDescriptionsDBHandler.updatePurchaseDescription(3, "Возврат");
        purchaseDescriptionsDBHandler.selectPurchaseDescriptions();
        purchaseDescriptionsDBHandler.deletePurchaseDescription(4);
        purchaseDescriptionsDBHandler.selectPurchaseDescriptions();

        System.out.println("\n-------------Table sale_descriptions-------------");
        SaleDescriptionsDBHandler saleDescriptionsDBHandler = new SaleDescriptionsDBHandler();
        saleDescriptionsDBHandler.insertSaleDescription("В наличии");
        saleDescriptionsDBHandler.insertSaleDescription("Продано");
        saleDescriptionsDBHandler.insertSaleDescription("Возвращено");
        saleDescriptionsDBHandler.insertSaleDescription("аыврыврыа");
        saleDescriptionsDBHandler.selectSaleDescriptions();
        saleDescriptionsDBHandler.updateSaleDescription(3, "Возврат");
        saleDescriptionsDBHandler.selectSaleDescriptions();
        saleDescriptionsDBHandler.deleteSaleDescription(4);
        saleDescriptionsDBHandler.selectSaleDescriptions();

        System.out.println("\n-------------Table prices-------------");
        PricesDBHandler pricesDBHandler = new PricesDBHandler();
        pricesDBHandler.insertPrice(1000_000);
        pricesDBHandler.insertPrice(2000_000);
        pricesDBHandler.selectPrices();
        pricesDBHandler.updatePrice(2, 2500_500);
        pricesDBHandler.selectPrices();
        pricesDBHandler.deletePrice(2);
        pricesDBHandler.selectPrices();

        System.out.println("\n-------------Table cars-------------");
        CarsDBHandler carsDBHandler = new CarsDBHandler();
        carsDBHandler.insertCar("Mersedes 500 E", "B 3342 DD", LocalDate.parse("1999-02-02"),
                "5.0", "Black", 1, "Хорошее состояние");
        carsDBHandler.insertCar("Toyota Camry", "T 5466 AA", LocalDate.parse("2019-01-01"),
                "4.5", "White", 1, "Отличное состояние");
        carsDBHandler.selectCars();
        carsDBHandler.updateCar(2, "Toyota Land Cruiser 300", "T 5466 AA", LocalDate.parse("2019-01-01"),
                "4.5", "White", 1, "Отличное состояние");
        carsDBHandler.selectCars();
        carsDBHandler.deleteCar(2);
        carsDBHandler.selectCars();

        System.out.println("\n-------------Table providers-------------");
        ProvidersDBHandler providersDBHandler = new ProvidersDBHandler();
        providersDBHandler.insertProvider("Mercedes", "Алымбеков Алим",
                "Управляющий", "ул. Западная 66", "Бишкек", "4326425463456", "3425246236534", "чек");
        providersDBHandler.insertProvider("Toyota", "Жаныбеков Элдос",
                "Менеджер", "ул. Киевская 506", "Бишкек", "54353645654", "35636346543643", "чек");
        providersDBHandler.selectProviders();
        providersDBHandler.updateProvider(2, "Nissan", "Жаныбеков Элдос", "Менеджер",
                "ул. Киевская 506", "Бишкек", "54353645654", "35636346543643", "чек");
        providersDBHandler.selectProviders();
        providersDBHandler.deleteStaff(2);
        providersDBHandler.selectProviders();

        System.out.println("\n-------------Table clients-------------");
        ClientDBHandler clientDBHandler = new ClientDBHandler();
        clientDBHandler.insertClient("Nazarbekov", "Rashid", "364563463456", "Let's go");
        clientDBHandler.insertClient("Belekov", "Urmat", "7458972857", "dfsfgds");
        clientDBHandler.selectClients();
        clientDBHandler.updateClient(2, "Mirbekov", "Urmat", "7458972857", "dfsfgds");
        clientDBHandler.selectClients();
        clientDBHandler.deleteClient(2);
        clientDBHandler.selectClients();

        System.out.println("\n-------------Table staff-------------");
        StaffDBHandler staffDBHandler = new StaffDBHandler();
        staffDBHandler.insertStaff("Ян", "Петр", "Менеджер", "845728572890");
        staffDBHandler.insertStaff("Коваль", "Павел", "Бухгалтер", "464536465643");
        staffDBHandler.insertStaff("Куттубаев", "Адилет", "Консультант", "423542364356");
        staffDBHandler.selectStaff();
        staffDBHandler.updateStaff(1, "Бакиев", "Эркин", "Менеджер", "758932789754");
        staffDBHandler.selectStaff();
        staffDBHandler.deleteStaff(2);
        staffDBHandler.selectStaff();

        System.out.println("\n-------------Table delivery_orders-------------");
        DeliveryOrderDBHandler deliveryOrderDBHandler = new DeliveryOrderDBHandler();
        deliveryOrderDBHandler.insertDeliveryOrder("", 1, 1, LocalDate.parse("2022-02-08"), LocalDate.parse("2022-02-10"), 1);
        deliveryOrderDBHandler.insertDeliveryOrder("", 1, 1, LocalDate.parse("2022-02-08"), LocalDate.parse("2022-02-10"), 2);
        deliveryOrderDBHandler.selectDeliveryOrders();
        deliveryOrderDBHandler.updateDeliveryOrder(2, "", 1, 1, LocalDate.parse("2022-02-08"), LocalDate.parse("2022-02-10"), 1);
        deliveryOrderDBHandler.selectDeliveryOrders();
        deliveryOrderDBHandler.deleteDeliveryOrder(2);
        deliveryOrderDBHandler.selectDeliveryOrders();

        System.out.println("\n-------------Table operations-------------");
        OperationsDBHandler operationsDBHandler = new OperationsDBHandler();
        operationsDBHandler.insertOperation(LocalDate.parse("2022-02-07"), 1, 1, "", 500000, 800000, 1000000);
        operationsDBHandler.insertOperation(LocalDate.parse("2022-02-07"), 1, 1, "", 500000, 800000, 1000000);
        operationsDBHandler.selectOperations();
        operationsDBHandler.updateOperation(2, LocalDate.parse("2022-02-07"), 1, 1, "", 700000, 900000, 1200000);
        operationsDBHandler.selectOperations();
        operationsDBHandler.deleteOperation(2);
        operationsDBHandler.selectOperations();

        System.out.println("\n-------------Table orders-------------");
        OrdersDBHandler ordersDBHandler = new OrdersDBHandler();
        ordersDBHandler.insertOrder(1, 1, LocalDate.parse("2022-02-10"), "1", "Passport", "324522332", "st. Chyi 88", 1);
        ordersDBHandler.insertOrder(1, 1, LocalDate.parse("2022-02-10"), "2", "Passport", "654364643", "st. Chyi 88", 2);
        ordersDBHandler.selectOrders();
        ordersDBHandler.updateOrder(2, 1, 1, LocalDate.parse("2022-02-10"), "2", "Passport", "654364643", "st. Chyi 88", 3);
        ordersDBHandler.selectOrders();
        ordersDBHandler.deleteOrder(2);
        ordersDBHandler.selectOrders();
    }
}
