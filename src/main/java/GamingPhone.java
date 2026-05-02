/**
 * Derived class that represents a gaming phone.
 */
public class GamingPhone extends SmartPhone {

    private boolean hasCoolingSystem;
    private int batteryCapacity;

    public GamingPhone(String brand, String model, double price, int year,
                       int memory, String operatingSystem, boolean hasFiveG,
                       boolean hasCoolingSystem, int batteryCapacity) {
        super(brand, model, price, year, memory, operatingSystem, hasFiveG);
        setHasCoolingSystem(hasCoolingSystem);
        setBatteryCapacity(batteryCapacity);
    }

    public boolean isHasCoolingSystem() {
        return hasCoolingSystem;
    }

    public void setHasCoolingSystem(boolean hasCoolingSystem) {
        this.hasCoolingSystem = hasCoolingSystem;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        if (batteryCapacity <= 0) {
            throw new IllegalArgumentException("Battery capacity must be greater than 0.");
        }

        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return "GamingPhone{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", memory=" + getMemory() +
                ", type=" + getType() +
                ", operatingSystem='" + getOperatingSystem() + '\'' +
                ", hasFiveG=" + isHasFiveG() +
                ", hasCoolingSystem=" + hasCoolingSystem +
                ", batteryCapacity=" + batteryCapacity +
                '}';
    }
}