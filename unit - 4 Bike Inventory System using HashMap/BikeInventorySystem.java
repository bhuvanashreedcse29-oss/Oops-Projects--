import java.util.*;

public class BikeInventorySystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> bikeStock = new HashMap<>();

        bikeStock.put("Yamaha", 10);
        bikeStock.put("Honda", 15);
        bikeStock.put("KTM", 8);

        int choice;

        do {
            System.out.println("\n===== BIKE INVENTORY MENU =====");
            System.out.println("1. Add New Bike Type");
            System.out.println("2. Sell Bike");
            System.out.println("3. Add Bike Stock");
            System.out.println("4. Show All Bikes");
            System.out.println("5. Show Low Stock Bikes");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter bike name: ");
                    String bike = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    bikeStock.put(bike, qty);
                    System.out.println("Bike added.");
                    break;

                case 2:
                    System.out.print("Enter bike name: ");
                    String sellBike = sc.nextLine();

                    if (bikeStock.containsKey(sellBike)) {

                        System.out.print("Enter quantity to sell: ");
                        int sellQty = sc.nextInt();

                        int current = bikeStock.get(sellBike);

                        if (sellQty <= current) {
                            bikeStock.put(sellBike, current - sellQty);
                            System.out.println("Bike sold.");
                        } else {
                            System.out.println("Not enough bikes.");
                        }

                    } else {
                        System.out.println("Bike type not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter bike name: ");
                    String restock = sc.nextLine();

                    if (bikeStock.containsKey(restock)) {

                        System.out.print("Enter quantity to add: ");
                        int add = sc.nextInt();

                        int current = bikeStock.get(restock);

                        bikeStock.put(restock, current + add);

                        System.out.println("Bike stock added.");

                    } else {
                        System.out.println("Bike type not found.");
                    }
                    break;

                case 4:
                    System.out.println("\nBike Inventory:");

                    for (String b : bikeStock.keySet()) {
                        System.out.println(b + " : " + bikeStock.get(b));
                    }
                    break;

                case 5:
                    System.out.println("\nLow Stock Bikes (Less than 5):");

                    for (String b : bikeStock.keySet()) {
                        if (bikeStock.get(b) < 5) {
                            System.out.println(b + " : " + bikeStock.get(b));
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);
    }
}