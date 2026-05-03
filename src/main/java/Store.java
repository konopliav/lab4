import java.util.ArrayList;

/**
 * Store class that contains phones and their quantities.
 */
public class Store {

    private ArrayList<Phone> phones;
    private ArrayList<Integer> quantities;

    /**
     * Creates empty store.
     */
    public Store() {
        phones = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    /**
     * Adds new phone or increases quantity if phone already exists.
     *
     * @param phone phone object
     * @param quantity phone quantity
     */
    public void addNewPhone(Phone phone, int quantity) {
        if (phone == null) {
            throw new IllegalArgumentException("Phone cannot be null.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }

        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).equals(phone)) {
                quantities.set(i, quantities.get(i) + quantity);
                return;
            }
        }

        phones.add(phone);
        quantities.add(quantity);
    }

    /**
     * Shows all phones with quantity.
     */
    public void showAll() {
        if (phones.isEmpty()) {
            System.out.println("Store is empty.");
            return;
        }

        for (int i = 0; i < phones.size(); i++) {
            System.out.println(phones.get(i) + " | quantity: " + quantities.get(i));
        }
    }

    /**
     * Searches phones by brand.
     *
     * @param brand phone brand
     */
    public void searchByBrand(String brand) {
        boolean found = false;

        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getBrand().equalsIgnoreCase(brand)) {
                System.out.println(phones.get(i) + " | quantity: " + quantities.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No objects found.");
        }
    }

    /**
     * Searches phones by year.
     *
     * @param year phone release year
     */
    public void searchByYear(int year) {
        boolean found = false;

        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getYear() == year) {
                System.out.println(phones.get(i) + " | quantity: " + quantities.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No objects found.");
        }
    }

    /**
     * Searches phones by maximum price.
     *
     * @param maxPrice maximum phone price
     */
    public void searchByMaxPrice(double maxPrice) {
        boolean found = false;

        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getPrice() <= maxPrice) {
                System.out.println(phones.get(i) + " | quantity: " + quantities.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No objects found.");
        }
    }

    public int size() {
        return phones.size();
    }

    public Phone getPhone(int index) {
        return phones.get(index);
    }

    public int getQuantity(int index) {
        return quantities.get(index);
    }
}