public class Order {
    private int id;
    private double price;
    private int quantity;
    private String side;

    public Order(int id, double price, int quantity, String side) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
    }

    // getters and setters for fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}
