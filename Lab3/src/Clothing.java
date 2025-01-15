import java.util.*;

class Clothing {
    private String name;
    private String type;
    private String size;
    private String color;
    private double price;

    public Clothing(String name, String type, String size, String color, double price) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Clothing clothing = (Clothing) obj;
        return Double.compare(clothing.price, price) == 0 &&
                Objects.equals(name, clothing.name) &&
                Objects.equals(type, clothing.type) &&
                Objects.equals(size, clothing.size) &&
                Objects.equals(color, clothing.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, size, color, price);
    }

    @Override
    public String toString() {
        return String.format("Clothing{name='%s', type='%s', size='%s', color='%s', price=%.2f}",
                name, type, size, color, price);
    }
}