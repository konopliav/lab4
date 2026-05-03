import java.util.Scanner;

/**
 * Driver class for working with phone store.
 */
public class Main {

    public static void main(String[] args) {
        Store store = FileManager.loadStoreFromFile("input.txt");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Practice work 13");
        System.out.println("Abstract classes, interfaces, Comparable");

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1 - Search object");
            System.out.println("2 - Create new object");
            System.out.println("3 - Show all objects");
            System.out.println("4 - Show sorted objects");
            System.out.println("0 - Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                searchMenu(scanner, store);
            } else if ("2".equals(choice)) {
                createObjectMenu(scanner, store);
            } else if ("3".equals(choice)) {
                store.showAll();
            } else if ("4".equals(choice)) {
                store.showSorted();
            } else if ("0".equals(choice)) {
                FileManager.saveStoreToFile(store, "input.txt");
                System.out.println("Data saved to input.txt.");
                running = false;
            } else {
                System.out.println("Invalid menu option.");
            }
        }

        scanner.close();
    }

    private static void searchMenu(Scanner scanner, Store store) {
        System.out.println();
        System.out.println("Search by:");
        System.out.println("1 - Brand");
        System.out.println("2 - Year");
        System.out.println("3 - Maximum price");
        System.out.println("0 - Back to main menu");
        System.out.print("Choose option: ");

        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            System.out.print("Enter brand: ");
            String brand = scanner.nextLine();
            store.searchByBrand(brand);
        } else if ("2".equals(choice)) {
            try {
                System.out.print("Enter year: ");
                int year = Integer.parseInt(scanner.nextLine());
                store.searchByYear(year);
            } catch (NumberFormatException e) {
                System.out.println("Error: year must be numeric.");
            }
        } else if ("3".equals(choice)) {
            try {
                System.out.print("Enter maximum price: ");
                double maxPrice = Double.parseDouble(scanner.nextLine());
                store.searchByMaxPrice(maxPrice);
            } catch (NumberFormatException e) {
                System.out.println("Error: price must be numeric.");
            }
        } else if ("0".equals(choice)) {
            System.out.println("Back to main menu.");
        } else {
            System.out.println("Invalid search option.");
        }
    }

    private static void createObjectMenu(Scanner scanner, Store store) {
        System.out.println();
        System.out.println("Choose object type:");
        System.out.println("1 - SmartPhone");
        System.out.println("2 - KeypadPhone");
        System.out.println("3 - GamingPhone");
        System.out.println("4 - BusinessPhone");
        System.out.println("0 - Back to main menu");
        System.out.print("Choose type: ");

        String choice = scanner.nextLine();

        if ("1".equals(choice)) {
            createSmartPhone(scanner, store);
        } else if ("2".equals(choice)) {
            createKeypadPhone(scanner, store);
        } else if ("3".equals(choice)) {
            createGamingPhone(scanner, store);
        } else if ("4".equals(choice)) {
            createBusinessPhone(scanner, store);
        } else if ("0".equals(choice)) {
            System.out.println("Back to main menu.");
        } else {
            System.out.println("Invalid object type.");
        }
    }

    private static int readQuantity(Scanner scanner) {
        System.out.print("Quantity: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static void createSmartPhone(Scanner scanner, Store store) {
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

            int quantity = readQuantity(scanner);

            Phone phone = new SmartPhone(brand, model, price, year, memory,
                    operatingSystem, hasFiveG);
            store.addNewPhone(phone, quantity);

            System.out.println("SmartPhone was added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void createKeypadPhone(Scanner scanner, Store store) {
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

            int quantity = readQuantity(scanner);

            Phone phone = new KeypadPhone(brand, model, price, year, memory,
                    hasTorch, keyboardType);
            store.addNewPhone(phone, quantity);

            System.out.println("KeypadPhone was added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void createGamingPhone(Scanner scanner, Store store) {
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

            int quantity = readQuantity(scanner);

            Phone phone = new GamingPhone(brand, model, price, year, memory,
                    operatingSystem, hasFiveG, hasCoolingSystem, batteryCapacity);
            store.addNewPhone(phone, quantity);

            System.out.println("GamingPhone was added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void createBusinessPhone(Scanner scanner, Store store) {
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

            int quantity = readQuantity(scanner);

            Phone phone = new BusinessPhone(brand, model, price, year, memory,
                    operatingSystem, hasFiveG, hasESim, securityLevel);
            store.addNewPhone(phone, quantity);

            System.out.println("BusinessPhone was added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}