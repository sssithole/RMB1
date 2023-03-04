public class Main {
    public static void main(String[] args) {
        Orders orders = new Orders();
        OrderBook orderBook = new OrderBook();

        // add some orders to the order book
        Order order1 = new Order(1, 100.0, 10, "Buy");
        Order order2 = new Order(2, 99.0, 20, "Buy");
        Order order3 = new Order(3, 101.0, 5, "Sell");
        Order order4 = new Order(4, 102.0, 15, "Sell");
        orderBook.addOrder(order1);
        orderBook.addOrder(order2);
        orderBook.addOrder(order3);
        orderBook.addOrder(order4);
        orders.addOrder(order1);
        orders.addOrder(order2);
        orders.addOrder(order3);
        orders.addOrder(order4);

        // print out the current order book
        System.out.println("Current Order Book:");
        orderBook.printOrderBook();

        // modify an order
        System.out.println("Modifying order 2");
        orders.modifyOrder(2, 25);
        orderBook.modifyOrder(2, 25);
        System.out.println("Current Order Book after modifying order 2:");
        orderBook.printOrderBook();

        // delete an order
        System.out.println("Deleting order 1");
        orders.deleteOrder(1);
        orderBook.deleteOrder(1);
        System.out.println("Current Order Book after deleting order 1:");
        orderBook.printOrderBook();
    }
}
