import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Scanner sc = new Scanner(System.in);

        boolean run = true;

        while (run) {
            System.out.println();
            System.out.println("1 - Add phone");
            System.out.println("2 - Show all phones");
            System.out.println("3 - Modify phone");
            System.out.println("4 - Delete phone");
            System.out.println("5 - Search by UUID");
            System.out.println("6 - Sort phones");
            System.out.println("0 - Exit");
            System.out.print("Choose option: ");

            String choice = sc.nextLine();

            if ("1".equals(choice)) {
                addPhone(sc, store);
            } else if ("2".equals(choice)) {
                store.showAll();
            } else if ("3".equals(choice)) {
                modifyPhone(sc, store);
            } else if ("4".equals(choice)) {
                deletePhone(sc, store);
            } else if ("5".equals(choice)) {
                System.out.print("UUID: ");
                store.searchByUuid(sc.nextLine());
            } else if ("6".equals(choice)) {
                sortMenu(sc, store);
            } else if ("0".equals(choice)) {
                run = false;
            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }

    private static void addPhone(Scanner sc, Store store) {
        try {
            System.out.print("Brand: ");
            String brand = sc.nextLine();

            System.out.print("Model: ");
            String model = sc.nextLine();

            System.out.print("Price: ");
            double price = Double.parseDouble(sc.nextLine());

            System.out.print("Year: ");
            int year = Integer.parseInt(sc.nextLine());

            System.out.print("Memory: ");
            int memory = Integer.parseInt(sc.nextLine());

            System.out.print("Operating system: ");
            String operatingSystem = sc.nextLine();

            System.out.print("Has 5G (true/false): ");
            boolean hasFiveG = Boolean.parseBoolean(sc.nextLine());

            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());

            Phone phone = new SmartPhone(
                    brand,
                    model,
                    price,
                    year,
                    memory,
                    operatingSystem,
                    hasFiveG
            );

            store.addNewPhone(phone, quantity);
            System.out.println("Phone added.");
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void modifyPhone(Scanner sc, Store store) {
        if (store.size() == 0) {
            System.out.println("Store is empty.");
            return;
        }

        try {
            store.showAll();

            System.out.print("Enter index of phone to modify: ");
            int index = Integer.parseInt(sc.nextLine());

            if (index < 0 || index >= store.size()) {
                System.out.println("Invalid index.");
                return;
            }

            Phone oldPhone = store.getPhone(index);

            System.out.println("Choose field to modify:");
            System.out.println("1 - Brand");
            System.out.println("2 - Model");
            System.out.println("3 - Price");
            System.out.println("4 - Year");
            System.out.println("5 - Memory");
            System.out.print("Choose option: ");

            String option = sc.nextLine();

            String brand = oldPhone.getBrand();
            String model = oldPhone.getModel();
            double price = oldPhone.getPrice();
            int year = oldPhone.getYear();
            int memory = oldPhone.getMemory();

            if ("1".equals(option)) {
                System.out.print("New brand: ");
                brand = sc.nextLine();
            } else if ("2".equals(option)) {
                System.out.print("New model: ");
                model = sc.nextLine();
            } else if ("3".equals(option)) {
                System.out.print("New price: ");
                price = Double.parseDouble(sc.nextLine());
            } else if ("4".equals(option)) {
                System.out.print("New year: ");
                year = Integer.parseInt(sc.nextLine());
            } else if ("5".equals(option)) {
                System.out.print("New memory: ");
                memory = Integer.parseInt(sc.nextLine());
            } else {
                System.out.println("Invalid field.");
                return;
            }

            Phone newPhone = new SmartPhone(
                    brand,
                    model,
                    price,
                    year,
                    memory,
                    "Android",
                    true
            );

            boolean result = store.update(oldPhone, newPhone);

            if (result) {
                System.out.println("Phone updated.");
            } else {
                System.out.println("Phone not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: numeric value expected.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deletePhone(Scanner sc, Store store) {
        if (store.size() == 0) {
            System.out.println("Store is empty.");
            return;
        }

        try {
            store.showAll();

            System.out.print("Enter index of phone to delete: ");
            int index = Integer.parseInt(sc.nextLine());

            if (index < 0 || index >= store.size()) {
                System.out.println("Invalid index.");
                return;
            }

            Phone phone = store.getPhone(index);

            System.out.print("Are you sure? (yes/no): ");
            String confirmation = sc.nextLine();

            if (!"yes".equalsIgnoreCase(confirmation)) {
                System.out.println("Deletion cancelled.");
                return;
            }

            boolean result = store.delete(phone);

            if (result) {
                System.out.println("Phone deleted.");
            } else {
                System.out.println("Phone not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: index must be numeric.");
        }
    }

    private static void sortMenu(Scanner sc, Store store) {
        System.out.println("Sort by:");
        System.out.println("1 - Brand");
        System.out.println("2 - Price");
        System.out.println("3 - Year");
        System.out.println("0 - Back");
        System.out.print("Choose option: ");

        String option = sc.nextLine();

        if ("1".equals(option)) {
            store.showSortedWithComparator(1);
        } else if ("2".equals(option)) {
            store.showSortedWithComparator(2);
        } else if ("3".equals(option)) {
            store.showSortedWithComparator(3);
        } else if ("0".equals(option)) {
            System.out.println("Back to main menu.");
        } else {
            System.out.println("Invalid option.");
        }
    }
}