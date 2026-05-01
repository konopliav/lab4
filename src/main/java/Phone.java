import java.util.Objects;

/**
 * Class that represents a phone.
 */
public class Phone {

    private String brand;
    private String model;
    private double price;

    /**
     * Creates a phone object.
     *
     * @param brand phone brand
     * @param model phone model
     * @param price phone price
     */
    public Phone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Phone)) {
            return false;
        }

        Phone phone = (Phone) obj;

        return Double.compare(phone.price, price) == 0
                && Objects.equals(brand, phone.brand)
                && Objects.equals(model, phone.model);
    }
}