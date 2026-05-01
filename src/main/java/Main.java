import java.util.ArrayList;

/**
 * Driver class for testing Phone objects.
 */
public class Main {

    /**
     * Program entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        ArrayList<Phone> phones = new ArrayList<>();

        phones.add(new Phone("Apple", "iPhone 15", 999.99));
        phones.add(new Phone("Samsung", "Galaxy S24", 899.99));
        phones.add(new Phone("Xiaomi", "Redmi Note 13", 299.99));
        phones.add(new Phone("Google", "Pixel 8", 799.99));
        phones.add(new Phone("OnePlus", "12", 749.99));

        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }
}