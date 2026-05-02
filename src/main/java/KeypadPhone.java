import java.util.Objects;

/**
 * Derived class that represents a keypad phone.
 */
public class KeypadPhone extends Phone {

    private boolean hasTorch;
    private String keyboardType;

    /**
     * Creates a keypad phone object.
     *
     * @param brand phone brand
     * @param model phone model
     * @param price phone price
     * @param year release year
     * @param memory phone memory in GB
     * @param hasTorch torch availability
     * @param keyboardType keyboard type
     */
    public KeypadPhone(String brand, String model, double price, int year,
                       int memory, boolean hasTorch, String keyboardType) {
        super(brand, model, price, year, memory, PhoneType.BUTTON_PHONE);
        this.hasTorch = hasTorch;
        setKeyboardType(keyboardType);
    }

    public boolean isHasTorch() {
        return hasTorch;
    }

    public void setHasTorch(boolean hasTorch) {
        this.hasTorch = hasTorch;
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        if (keyboardType == null || keyboardType.trim().isEmpty()) {
            throw new IllegalArgumentException("Keyboard type cannot be empty.");
        }

        this.keyboardType = keyboardType;
    }

    @Override
    public String toString() {
        return "KeypadPhone{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", price=" + getPrice() +
                ", year=" + getYear() +
                ", memory=" + getMemory() +
                ", type=" + getType() +
                ", hasTorch=" + hasTorch +
                ", keyboardType='" + keyboardType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof KeypadPhone)) {
            return false;
        }

        KeypadPhone phone = (KeypadPhone) obj;

        return hasTorch == phone.hasTorch
                && Objects.equals(keyboardType, phone.keyboardType);
    }
}