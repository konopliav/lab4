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

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1 - Create new phone");
            System.out.println("2 - Show all phones");
            System.out.println("0 - Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                createPhone(scanner, phones);
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

	    phones.add(new Phone(brand, model, price, year, memory));


            System.out.println("Phone was created successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: price and year must be numeric.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
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
}