import java.util.Objects;

/**
 * Class that represents a phone.
 */
public class Phone {

    private String brand;
    private String model;
    private double price;
    private int year;
    private int memory;

    public Phone(String brand, String model, double price, int year, int memory) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setYear(year);
        setMemory(memory);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty.");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty.");
        }
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 2000 || year > 2026) {
            throw new IllegalArgumentException("Year must be between 2000 and 2026.");
        }
        this.year = year;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        if (memory <= 0) {
            throw new IllegalArgumentException("Memory must be greater than 0.");
        }
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", memory=" + memory +
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
                && year == phone.year
                && memory == phone.memory
                && Objects.equals(brand, phone.brand)
                && Objects.equals(model, phone.model);
    }
}