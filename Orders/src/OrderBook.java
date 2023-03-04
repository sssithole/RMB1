import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class OrderBook {
    private HashMap<Double, PriorityQueue<Order>> bids;
    private HashMap<Double, PriorityQueue<Order>> asks;

    public OrderBook() {
        bids = new HashMap<>();
        asks = new HashMap<>();
    }

    public void addOrder(Order order) {
        HashMap<Double, PriorityQueue<Order>> orderList;
        if (order.getSide().equals("Buy")) {
            orderList = bids;
        } else {
            orderList = asks;
        }

        PriorityQueue<Order> orderQueue = orderList.get(order.getPrice());
        if (orderQueue == null) {
            orderQueue = new PriorityQueue<>(Comparator.comparingInt(Order::getId));
            orderList.put(order.getPrice(), orderQueue);
        }

        orderQueue.add(order);
    }

    public void deleteOrder(int orderId) {
        for (PriorityQueue<Order> queue : bids.values()) {
            deleteOrderFromQueue(queue, orderId);
        }
        for (PriorityQueue<Order> queue : asks.values()) {
            deleteOrderFromQueue(queue, orderId);
        }
    }

    private void deleteOrderFromQueue(PriorityQueue<Order> queue, int orderId) {
        List<Order> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            Order order = queue.poll();
            if (order.getId() == orderId) {
                break;
            } else {
                temp.add(order);
            }
        }
        queue.addAll(temp);
    }

    public void modifyOrder(int orderId, int newQuantity) {
        for (PriorityQueue<Order> queue : bids.values()) {
            modifyOrderInQueue(queue, orderId, newQuantity);
        }
        for (PriorityQueue<Order> queue : asks.values()) {
            modifyOrderInQueue(queue, orderId, newQuantity);
        }
    }

    private void modifyOrderInQueue(PriorityQueue<Order> queue, int orderId, int newQuantity) {
        List<Order> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            Order order = queue.poll();
            if (order.getId() == orderId) {
                order.setQuantity(newQuantity);
                break;
            } else {
                temp.add(order);
            }
        }
        queue.addAll(temp);
    }

    public void printOrderBook() {
        System.out.println("Current Order Book:");
        System.out.println("Bids:");
        for (double price : bids.keySet()) {
            System.out.println("Price: " + price);
            PriorityQueue<Order> queue = bids.get(price);
            for (Order order : queue) {
                System.out.println("Order ID: " + order.getId() + ", Quantity: " + "");
            }
        }
    }
}
