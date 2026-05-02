import java.util.ArrayList;
import java.util.Scanner;

/**
 * Driver class for working with phones.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Phone> phones = FileManager.loadFromFile("input.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Practice work 8");
        System.out.println("Hierarchy extension and polymorphism");

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1 - Create new object");
            System.out.println("2 - Show all objects");
            System.out.println("0 - Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                createObjectMenu(scanner, phones);
            } else if ("2".equals(choice)) {
                showPhones(phones);
            } else if ("0".equals(choice)) {
                running = false;
            } else {
                System.out.println("Invalid menu option.");
            }
        }

        scanner.close();
    }

    private static void createObjectMenu(Scanner scanner, ArrayList<Phone> phones) {
        System.out.println();
        System.out.println("Choose object type:");
        System.out.println("1 - Phone");
        System.out.println("2 - SmartPhone");
        System.out.println("3 - KeypadPhone");
        System.out.println("4 - GamingPhone");
        System.out.println("5 - BusinessPhone");
        System.out.println("0 - Back to main menu");
        System.out.print("Choose type: ");

        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            createBasePhone(scanner, phones);
        } else if ("2".equals(choice)) {
            createSmartPhone(scanner, phones);
        } else if ("3".equals(choice)) {
            createKeypadPhone(scanner, phones);
        } else if ("4".equals(choice)) {
            createGamingPhone(scanner, phones);
        } else if ("5".equals(choice)) {
            createBusinessPhone(scanner, phones);
        } else if ("0".equals(choice)) {
    	    running = false;
        } else {
            System.out.println("Invalid object type.");
        }
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

            System.out.println("Phone was created successfully.");
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

            System.out.println("SmartPhone was created successfully.");
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

            System.out.println("KeypadPhone was created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void createGamingPhone(Scanner scanner, ArrayList<Phone> phones) {
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

            System.out.print("Has cooling system (true/false): ");
            boolean hasCoolingSystem = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Battery capacity: ");
            int batteryCapacity = Integer.parseInt(scanner.nextLine());

            Phone phone = new GamingPhone(brand, model, price, year, memory,
                    operatingSystem, hasFiveG, hasCoolingSystem, batteryCapacity);
            phones.add(phone);

            System.out.println("GamingPhone was created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void createBusinessPhone(Scanner scanner, ArrayList<Phone> phones) {
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

            System.out.print("Has eSIM (true/false): ");
            boolean hasESim = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Security level: ");
            String securityLevel = scanner.nextLine();

            Phone phone = new BusinessPhone(brand, model, price, year, memory,
                    operatingSystem, hasFiveG, hasESim, securityLevel);
            phones.add(phone);

            System.out.println("BusinessPhone was created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showPhones(ArrayList<Phone> phones) {
        if (phones.isEmpty()) {
            System.out.println("No objects created.");
            return;
        }

        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }
}