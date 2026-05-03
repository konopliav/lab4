import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class for loading and saving store data.
 */
public class FileManager {

    /**
     * Loads store from file.
     *
     * @param fileName file name
     * @return loaded store
     */
    public static Store loadStoreFromFile(String fileName) {
        Store store = new Store();

        try {
            File file = new File(fileName);

            if (!file.exists()) {
                return store;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    Phone phone = parsePhone(line);
                    int quantity = parseQuantity(line);
                    store.addNewPhone(phone, quantity);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid line skipped: " + line);
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }

        return store;
    }

    /**
     * Saves store to file.
     *
     * @param store store object
     * @param fileName file name
     */
    public static void saveStoreToFile(Store store, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < store.size(); i++) {
                writer.write(formatPhone(store.getPhone(i), store.getQuantity(i)) + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }
    }

    private static int parseQuantity(String line) {
        String[] parts = line.split(";");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    private static Phone parsePhone(String line) {
        String[] parts = line.split(";");

        if (parts.length < 1) {
            throw new IllegalArgumentException("Empty line.");
        }

        String type = parts[0];

        if ("PHONE".equals(type)) {
            if (parts.length != 8) {
                throw new IllegalArgumentException("Invalid PHONE data.");
            }

            return new KeypadPhone(
                    parts[1],
                    parts[2],
                    Double.parseDouble(parts[3]),
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    false,
                    "basic"
            );
        }

        if ("SMARTPHONE".equals(type)) {
            if (parts.length != 9) {
                throw new IllegalArgumentException("Invalid SMARTPHONE data.");
            }

            return new SmartPhone(
                    parts[1],
                    parts[2],
                    Double.parseDouble(parts[3]),
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    parts[6],
                    Boolean.parseBoolean(parts[7])
            );
        }

        if ("KEYPADPHONE".equals(type)) {
            if (parts.length != 9) {
                throw new IllegalArgumentException("Invalid KEYPADPHONE data.");
            }

            return new KeypadPhone(
                    parts[1],
                    parts[2],
                    Double.parseDouble(parts[3]),
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    Boolean.parseBoolean(parts[6]),
                    parts[7]
            );
        }

        if ("GAMINGPHONE".equals(type)) {
            if (parts.length != 11) {
                throw new IllegalArgumentException("Invalid GAMINGPHONE data.");
            }

            return new GamingPhone(
                    parts[1],
                    parts[2],
                    Double.parseDouble(parts[3]),
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    parts[6],
                    Boolean.parseBoolean(parts[7]),
                    Boolean.parseBoolean(parts[8]),
                    Integer.parseInt(parts[9])
            );
        }

        if ("BUSINESSPHONE".equals(type)) {
            if (parts.length != 11) {
                throw new IllegalArgumentException("Invalid BUSINESSPHONE data.");
            }

            return new BusinessPhone(
                    parts[1],
                    parts[2],
                    Double.parseDouble(parts[3]),
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    parts[6],
                    Boolean.parseBoolean(parts[7]),
                    Boolean.parseBoolean(parts[8]),
                    parts[9]
            );
        }

        throw new IllegalArgumentException("Unknown phone type.");
    }

    private static String formatPhone(Phone phone, int quantity) {
        if (phone instanceof GamingPhone) {
            GamingPhone gamingPhone = (GamingPhone) phone;

            return "GAMINGPHONE;" +
                    gamingPhone.getBrand() + ";" +
                    gamingPhone.getModel() + ";" +
                    gamingPhone.getPrice() + ";" +
                    gamingPhone.getYear() + ";" +
                    gamingPhone.getMemory() + ";" +
                    gamingPhone.getOperatingSystem() + ";" +
                    gamingPhone.isHasFiveG() + ";" +
                    gamingPhone.isHasCoolingSystem() + ";" +
                    gamingPhone.getBatteryCapacity() + ";" +
                    quantity;
        }

        if (phone instanceof BusinessPhone) {
            BusinessPhone businessPhone = (BusinessPhone) phone;

            return "BUSINESSPHONE;" +
                    businessPhone.getBrand() + ";" +
                    businessPhone.getModel() + ";" +
                    businessPhone.getPrice() + ";" +
                    businessPhone.getYear() + ";" +
                    businessPhone.getMemory() + ";" +
                    businessPhone.getOperatingSystem() + ";" +
                    businessPhone.isHasFiveG() + ";" +
                    businessPhone.isHasESim() + ";" +
                    businessPhone.getSecurityLevel() + ";" +
                    quantity;
        }

        if (phone instanceof SmartPhone) {
            SmartPhone smartPhone = (SmartPhone) phone;

            return "SMARTPHONE;" +
                    smartPhone.getBrand() + ";" +
                    smartPhone.getModel() + ";" +
                    smartPhone.getPrice() + ";" +
                    smartPhone.getYear() + ";" +
                    smartPhone.getMemory() + ";" +
                    smartPhone.getOperatingSystem() + ";" +
                    smartPhone.isHasFiveG() + ";" +
                    quantity;
        }

        if (phone instanceof KeypadPhone) {
            KeypadPhone keypadPhone = (KeypadPhone) phone;

            return "KEYPADPHONE;" +
                    keypadPhone.getBrand() + ";" +
                    keypadPhone.getModel() + ";" +
                    keypadPhone.getPrice() + ";" +
                    keypadPhone.getYear() + ";" +
                    keypadPhone.getMemory() + ";" +
                    keypadPhone.isHasTorch() + ";" +
                    keypadPhone.getKeyboardType() + ";" +
                    quantity;
        }

        return "";
    }
}