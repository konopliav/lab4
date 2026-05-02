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

        System.out.println("Practice work 6");
        System.out.println("Classes, static members, aggregation, enum");

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1 - Create new phone");
            System.out.println("2 - Show all phones");
            System.out.println("3 - Copy first phone");
            System.out.println("4 - Show created phone count");
            System.out.println("0 - Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                createPhone(scanner, phones);
            } else if ("2".equals(choice)) {
                showPhones(phones);
            } else if ("3".equals(choice)) {
                copyFirstPhone(phones);
            } else if ("4".equals(choice)) {
                System.out.println("Created phone count: " + Phone.getCreatedCount());
            } else if ("0".equals(choice)) {
                running = false;
            } else {
                System.out.println("Invalid menu option.");
            }
        }

        scanner.close();
    }

    /**
     * Creates a phone from console input.
     *
     * @param scanner scanner for input
     * @param phones list of phones
     */
    private static void createPhone(Scanner scanner, ArrayList<Phone> phones) {
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

            System.out.println("Phone type:");
            System.out.println("1 - SMARTPHONE");
            System.out.println("2 - BUTTON_PHONE");
            System.out.println("3 - FOLDABLE");
            System.out.print("Choose type: ");
            PhoneType type = readPhoneType(scanner.nextLine());

            System.out.print("Manufacturer name: ");
            String manufacturerName = scanner.nextLine();

            System.out.print("Manufacturer country: ");
            String manufacturerCountry = scanner.nextLine();

            Manufacturer manufacturer = new Manufacturer(manufacturerName, manufacturerCountry);
            Phone phone = new Phone(brand, model, price, year, memory, type, manufacturer);

            phones.add(phone);

            System.out.println("Phone was created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Reads phone type from user input.
     *
     * @param value user value
     * @return phone type
     */
    private static PhoneType readPhoneType(String value) {
        if ("1".equals(value)) {
            return PhoneType.SMARTPHONE;
        }

        if ("2".equals(value)) {
            return PhoneType.BUTTON_PHONE;
        }

        if ("3".equals(value)) {
            return PhoneType.FOLDABLE;
        }

        throw new IllegalArgumentException("Invalid phone type.");
    }

    /**
     * Shows all created phones.
     *
     * @param phones list of phones
     */
    private static void showPhones(ArrayList<Phone> phones) {
        if (phones.isEmpty()) {
            System.out.println("No phones created.");
            return;
        }

        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }

    /**
     * Copies the first phone in the list.
     *
     * @param phones list of phones
     */
    private static void copyFirstPhone(ArrayList<Phone> phones) {
        if (phones.isEmpty()) {
            System.out.println("No phone to copy.");
            return;
        }

        Phone copiedPhone = new Phone(phones.get(0));
        phones.add(copiedPhone);

        System.out.println("First phone was copied.");
    }
}