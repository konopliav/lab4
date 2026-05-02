import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for loading and saving phone objects from and to file.
 */
public class FileManager {

    /**
     * Loads phones from file.
     *
     * @param fileName file name
     * @return list of phones
     */
    public static ArrayList<Phone> loadFromFile(String fileName) {
        ArrayList<Phone> phones = new ArrayList<>();

        try {
            File file = new File(fileName);

            if (!file.exists()) {
                return phones;
            }

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    Phone phone = parsePhone(line);
                    phones.add(phone);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid line skipped: " + line);
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("File reading error: " + e.getMessage());
        }

        return phones;
    }

    /**
     * Saves phones to file.
     *
     * @param phones list of phones
     * @param fileName file name
     */
    public static void saveToFile(ArrayList<Phone> phones, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (Phone phone : phones) {
                writer.write(formatPhone(phone) + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }
    }

    /**
     * Parses one line from file and creates phone object.
     *
     * @param line file line
     * @return phone object
     */
    private static Phone parsePhone(String line) {
        String[] parts = line.split(";");

        if (parts.length < 1) {
            throw new IllegalArgumentException("Empty line.");
        }

        String type = parts[0];

        if ("PHONE".equals(type)) {
            if (parts.length != 7) {
                throw new IllegalArgumentException("Invalid PHONE data.");
            }

            return new Phone(
                    parts[1],
                    parts[2],
                    Double.parseDouble(parts[3]),
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    PhoneType.valueOf(parts[6])
            );
        }

        if ("SMARTPHONE".equals(type)) {
            if (parts.length != 8) {
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
            if (parts.length != 8) {
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
            if (parts.length != 10) {
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
            if (parts.length != 10) {
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

    /**
     * Converts phone object to file line.
     *
     * @param phone phone object
     * @return formatted line
     */
    private static String formatPhone(Phone phone) {
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
                    gamingPhone.getBatteryCapacity();
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
                    businessPhone.getSecurityLevel();
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
                    smartPhone.isHasFiveG();
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
                    keypadPhone.getKeyboardType();
        }

        return "PHONE;" +
                phone.getBrand() + ";" +
                phone.getModel() + ";" +
                phone.getPrice() + ";" +
                phone.getYear() + ";" +
                phone.getMemory() + ";" +
                phone.getType();
    }
}