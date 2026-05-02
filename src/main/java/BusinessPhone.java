/**
 * Derived class that represents a business phone.
 */
public class BusinessPhone extends SmartPhone {

    private boolean hasESim;
    private String securityLevel;

    public BusinessPhone(String brand, String model, double price, int year,
                         int memory, String operatingSystem, boolean hasFiveG,
                         boolean hasESim, String securityLevel) {
        super(brand, model, price, year, memory, operatingSystem, hasFiveG);
        setHasESim(hasESim);
        setSecurityLevel(securityLevel);
    }

    public boolean isHasESim() {
        return hasESim;
    }

    public void setHasESim(boolean hasESim) {
        this.hasESim = hasESim;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        if (securityLevel == null || securityLevel.trim().isEmpty()) {
            throw new IllegalArgumentException("Security level cannot be empty.");
        }

        this.securityLevel = securityLevel;
    }

    @Override
    public String toString() {
        return "BusinessPhone{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", memory=" + getMemory() +
                ", type=" + getType() +
                ", operatingSystem='" + getOperatingSystem() + '\'' +
                ", hasFiveG=" + isHasFiveG() +
                ", hasESim=" + hasESim +
                ", securityLevel='" + securityLevel + '\'' +
                '}';
    }
}