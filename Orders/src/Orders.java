import java.util.HashMap;

public class Orders {
    private HashMap<Integer, Order> orders;

    public Orders() {
        orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public void deleteOrder(int orderId) {
        orders.remove(orderId);
    }

    public void modifyOrder(int orderId, int newQuantity) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setQuantity(newQuantity);
        }
    }

    public void printOrderBook() {
        System.out.println("Current Orders:");
        for (Order order : orders.values()) {
            System.out.println("Order ID: " + order.getId() + ", Price: " + order.getPrice() +
                    ", Quantity: " + order.getQuantity() + ", Side: " + order.getSide());
        }
    }
}

