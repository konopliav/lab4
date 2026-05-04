import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Scanner sc = new Scanner(System.in);

        boolean run = true;

        while (run) {
            System.out.println("\n1 Add");
            System.out.println("2 Show");
            System.out.println("3 Search by UUID");
            System.out.println("0 Exit");

            String ch = sc.nextLine();

            if ("1".equals(ch)) {
                System.out.print("Brand: ");
                String b = sc.nextLine();

                System.out.print("Model: ");
                String m = sc.nextLine();

                System.out.print("Price: ");
                double p = Double.parseDouble(sc.nextLine());

                System.out.print("Year: ");
                int y = Integer.parseInt(sc.nextLine());

                System.out.print("Memory: ");
                int mem = Integer.parseInt(sc.nextLine());

                Phone phone = new SmartPhone(b, m, p, y, mem, "Android", true);
                store.addNewPhone(phone, 1);

            } else if ("2".equals(ch)) {
                store.showAll();

            } else if ("3".equals(ch)) {
                System.out.print("UUID: ");
                store.searchByUuid(sc.nextLine());

            } else if ("0".equals(ch)) {
                run = false;
            }
        }

        sc.close();
    }
}