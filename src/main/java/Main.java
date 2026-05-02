import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class for working with phones.
 */
public class Main {

    /**
     * Program entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        ArrayList<Phone> phones = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Practice work 7");
        System.out.println("Inheritance, polymorphism, ArrayList");

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1 - Create base phone");
            System.out.println("2 - Create smartphone");
            System.out.println("3 - Create keypad phone");
            System.out.println("4 - Show all phones");
            System.out.println("0 - Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                createBasePhone(scanner, phones);
            } else if ("2".equals(choice)) {
                createSmartPhone(scanner, phones);
            } else if ("3".equals(choice)) {
                createKeypadPhone(scanner, phones);
            } else if ("4".equals(choice)) {
                showPhones(phones);
            } else if ("0".equals(choice)) {
                running = false;
            } else {
                System.out.println("Invalid menu option.");
            }
        }

        scanner.close();
    }

    private static void createBasePhone(Scanner scanner, ArrayList<Phone> phones) {
        try {
            System.out.print("Brand: ");
            String brand = scanner.nextLine();

            System.out.print("Model: ");
            String model = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Memory (GB): ");
            int memory = Integer.parseInt(scanner.nextLine());

            Phone phone = new Phone(brand, model, price, year, memory, PhoneType.BUTTON_PHONE);
            phones.add(phone);

            System.out.println("Base phone was created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void createSmartPhone(Scanner scanner, ArrayList<Phone> phones) {
        try {
            System.out.print("Brand: ");
            String brand = scanner.nextLine();

            System.out.print("Model: ");
            String model = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Memory (GB): ");
            int memory = Integer.parseInt(scanner.nextLine());

            System.out.print("Operating system: ");
            String operatingSystem = scanner.nextLine();

            System.out.print("Has 5G (true/false): ");
            boolean hasFiveG = Boolean.parseBoolean(scanner.nextLine());

            Phone phone = new SmartPhone(brand, model, price, year, memory,
                    operatingSystem, hasFiveG);
            phones.add(phone);

            System.out.println("Smartphone was created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void createKeypadPhone(Scanner scanner, ArrayList<Phone> phones) {
        try {
            System.out.print("Brand: ");
            String brand = scanner.nextLine();

            System.out.print("Model: ");
            String model = scanner.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Memory (GB): ");
            int memory = Integer.parseInt(scanner.nextLine());

            System.out.print("Has torch (true/false): ");
            boolean hasTorch = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Keyboard type: ");
            String keyboardType = scanner.nextLine();

            Phone phone = new KeypadPhone(brand, model, price, year, memory,
                    hasTorch, keyboardType);
            phones.add(phone);

            System.out.println("Keypad phone was created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showPhones(ArrayList<Phone> phones) {
        if (phones.isEmpty()) {
            System.out.println("No phones created.");
            return;
        }

        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }
}