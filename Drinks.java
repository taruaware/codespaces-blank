public class Drinks {
    private String name;
    private double price;
    private String size;
    private String info;

    public Drinks(String name, double price, String size, String info) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getInfo() {
        return info;
    }

    public void changeSize(String newSize) {
        this.size = newSize;
    }
}
    

