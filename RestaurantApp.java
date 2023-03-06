import java.util.Scanner;
import java.util.ArrayList;
public class RestaurantApp {
    public static void main(String[] args) {
        int[] tableCapacities = {4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
Restaurant restaurant = new Restaurant(tableCapacities);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. View table availability");
            System.out.println("2. Reserve a table");
            System.out.println("3. Release a table");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    // View table availability
                    ArrayList<Table> tables = restaurant.getTables();
                    for (Table table : tables) {
                        System.out.println("Table number: " + table.getTableNumber() + ", capacity: " + table.getCapacity() + ", availability: " + table.getAvailability() / (60 * 1000) + " minutes.");
                    }
                    break;

                    case 2:
                    // Reserve a table
                    System.out.println("Please enter the number of people in your group:");
                    int groupSize = scanner.nextInt();
                    Table reservedTable = restaurant.findTable(groupSize);
                    if (reservedTable != null) {
                        long waitTime = reservedTable.getAvailability() / (60 * 1000);
                        reservedTable.reserve(waitTime);
                        System.out.println("Table " + reservedTable.getTableNumber() + " has been reserved for your group.");
                    } else {
                        System.out.println("Sorry, no tables are available for your group size.");
                    }
                    break;

                case 3:
                    // Release a table
                    System.out.println("Please enter the table number to release:");
                    int tableNumber = scanner.nextInt();
                    Table releasedTable = restaurant.releaseTable(tableNumber);
                    if (releasedTable != null) {
                        System.out.println("Table " + releasedTable.getTableNumber() + " has been released.");
                    } else {
                        System.out.println("Sorry, there is no table with that number.");
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }
}
