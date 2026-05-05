import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Store class that contains phones and their quantities.
 */
public class Store {

    private ArrayList<Phone> phones;
    private ArrayList<Integer> quantities;

    public Store() {
        phones = new ArrayList<>();
        quantities = new ArrayList<>();
    }

    public void addNewPhone(Phone phone, int quantity) {
        if (phone == null) {
            throw new InvalidFieldValueException("Phone cannot be null.");
        }

        if (quantity <= 0) {
            throw new InvalidFieldValueException("Quantity must be greater than 0.");
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

    public boolean update(Phone existingObject, Phone newObject) {
        if (existingObject == null || newObject == null) {
            throw new InvalidFieldValueException("Phone cannot be null.");
        }

        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).equals(existingObject)) {
                phones.set(i, newObject);
                return true;
            }
        }

        throw new ObjectNotFoundException("Phone for update was not found.");
    }

    public boolean delete(Phone existingObject) {
        if (existingObject == null) {
            throw new InvalidFieldValueException("Phone cannot be null.");
        }

        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).equals(existingObject)) {
                phones.remove(i);
                quantities.remove(i);
                return true;
            }
        }

        throw new ObjectNotFoundException("Phone for delete was not found.");
    }

    public void showAll() {
        if (phones.isEmpty()) {
            System.out.println("Store is empty.");
            return;
        }

        for (int i = 0; i < phones.size(); i++) {
            System.out.println(i + " - " + phones.get(i) + " | quantity: " + quantities.get(i));
        }
    }

    public void searchByUuid(String uuidText) {
        try {
            java.util.UUID uuid = java.util.UUID.fromString(uuidText);

            for (int i = 0; i < phones.size(); i++) {
                if (phones.get(i).getUuid().equals(uuid)) {
                    System.out.println(phones.get(i) + " | quantity: " + quantities.get(i));
                    return;
                }
            }

            System.out.println("Object not found.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid UUID format.");
        }
    }

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

    public void showSortedWithComparator(int option) {
        if (phones.isEmpty()) {
            System.out.println("Store is empty.");
            return;
        }

        ArrayList<Phone> sortedPhones = new ArrayList<>();

        for (Phone phone : phones) {
            sortedPhones.add(phone);
        }

        Comparator<Phone> comparator;

        if (option == 1) {
            comparator = (first, second) ->
                    first.getBrand().compareToIgnoreCase(second.getBrand());
        } else if (option == 2) {
            comparator = (first, second) ->
                    Double.compare(first.getPrice(), second.getPrice());
        } else if (option == 3) {
            comparator = (first, second) ->
                    Integer.compare(first.getYear(), second.getYear());
        } else {
            System.out.println("Invalid sorting option.");
            return;
        }

        Collections.sort(sortedPhones, comparator);

        for (Phone phone : sortedPhones) {
            int index = phones.indexOf(phone);
            System.out.println(phone + " | quantity: " + quantities.get(index));
        }
    }

    public int size() {
        return phones.size();
    }

    public Phone getPhone(int index) {
        return phones.get(index);
    }

    public Phone get(int index) {
        return phones.get(index);
    }

    public int getQuantity(int index) {
        return quantities.get(index);
    }
}