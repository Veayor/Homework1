import java.util.Scanner;

public class validate {
    private static int[][] busSeats;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("------------- Bus Management System --------------");
            System.out.println("1- Check Bus");
            System.out.println("2- Setup Bus");
            System.out.println("3- Booking Bus");
            System.out.println("4- Cancel Booking");
            System.out.println("5- Reset Bus");
            System.out.println("6- Exit");
            System.out.println("---------------------------------------------");
            System.out.print("-> Choose option (1-6): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllBusInformation();
                    break;
                case 2:
                    setupBus(scanner);
                    break;
                case 3:
                    // Implement booking bus functionality
                    break;
                case 4:
                    // Implement cancel booking functionality
                    break;
                case 5:
                    // Implement reset bus functionality
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);
    }

    private static void setupBus(Scanner scanner) {
        System.out.println("---------- Setting up Bus ----------");
        System.out.print("-> Enter number of Buses: ");
        int numBuses = scanner.nextInt();
        busSeats = new int[numBuses][];
        for (int i = 0; i < numBuses; i++) {
            System.out.print("-> Enter number of seats for bus " + (i + 1) + ": ");
            int numSeats = scanner.nextInt();
            busSeats[i] = new int[numSeats];
        }
        System.out.println("Buses have been set up successfully!");
    }

    private static void displayAllBusInformation() {
        // Display all bus information
    }
}