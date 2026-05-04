import java.util.Objects;

/**
 * Derived class that represents a smartphone.
 */
public class SmartPhone extends Phone {

    private String operatingSystem;
    private boolean hasFiveG;

    public SmartPhone(String brand, String model, double price, int year,
                      int memory, String operatingSystem, boolean hasFiveG) {
        super(brand, model, price, year, memory, PhoneType.SMARTPHONE);
        setOperatingSystem(operatingSystem);
        this.hasFiveG = hasFiveG;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        if (operatingSystem == null || operatingSystem.trim().isEmpty()) {
            throw new IllegalArgumentException("Operating system cannot be empty.");
        }
        this.operatingSystem = operatingSystem;
    }

    public boolean isHasFiveG() {
        return hasFiveG;
    }

    public void setHasFiveG(boolean hasFiveG) {
        this.hasFiveG = hasFiveG;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "uuid=" + getUuid() +
                ", brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", memory=" + getMemory() +
                ", type=" + getType() +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", hasFiveG=" + hasFiveG +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof SmartPhone)) {
            return false;
        }

        SmartPhone phone = (SmartPhone) obj;

        return hasFiveG == phone.hasFiveG
                && Objects.equals(operatingSystem, phone.operatingSystem);
    }
}