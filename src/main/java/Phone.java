import java.util.Objects;

/**
 * Class that represents a phone.
 */
public class Phone {

    private static int createdCount = 0;

    private String brand;
    private String model;
    private double price;
    private int year;
    private int memory;
    private PhoneType type;
    private Manufacturer manufacturer;

    /**
     * Creates a phone object.
     *
     * @param brand phone brand
     * @param model phone model
     * @param price phone price
     * @param year release year
     * @param memory phone memory in GB
     * @param type phone type
     * @param manufacturer phone manufacturer
     */
    public Phone(String brand, String model, double price, int year,
                 int memory, PhoneType type, Manufacturer manufacturer) {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setYear(year);
        setMemory(memory);
        setType(type);
        setManufacturer(manufacturer);
        createdCount++;
    }

    /**
     * Copy constructor.
     *
     * @param other phone to copy
     */
    public Phone(Phone other) {
        if (other == null) {
            throw new IllegalArgumentException("Phone cannot be null.");
        }

        setBrand(other.brand);
        setModel(other.model);
        setPrice(other.price);
        setYear(other.year);
        setMemory(other.memory);
        setType(other.type);
        setManufacturer(new Manufacturer(other.manufacturer));
        createdCount++;
    }

    /**
     * Returns count of created phone objects.
     *
     * @return created phone count
     */
    public static int getCreatedCount() {
        return createdCount;
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

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        if (type == null) {
            throw new IllegalArgumentException("Phone type cannot be null.");
        }

        this.type = type;
    }

    public Manufacturer getManufacturer() {
        return new Manufacturer(manufacturer);
    }

    public void setManufacturer(Manufacturer manufacturer) {
        if (manufacturer == null) {
            throw new IllegalArgumentException("Manufacturer cannot be null.");
        }

        this.manufacturer = new Manufacturer(manufacturer);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", memory=" + memory +
                ", type=" + type +
                ", manufacturer=" + manufacturer +
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
                && Objects.equals(model, phone.model)
                && type == phone.type
                && Objects.equals(manufacturer, phone.manufacturer);
    }
}