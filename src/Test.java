import java.util.Scanner;

class Bus {
    private int id;
    private int totalSeats;
    private int availableSeats;

    public Bus(int id, int totalSeats) {
        this.id = id;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public int getId() {
        return id;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getUnavailableSeats() {
        return totalSeats - availableSeats;
    }

    public void bookSeats(int seatsToBook) {
        if (seatsToBook <= availableSeats) {
            availableSeats -= seatsToBook;
            System.out.println(seatsToBook + " seat(s) booked successfully.");
        } else {
            System.out.println("Not enough available seats.");
        }
    }

    public void cancelBooking(int seatsToCancel) {
        if (seatsToCancel <= getUnavailableSeats()) {
            availableSeats += seatsToCancel;
            System.out.println(seatsToCancel + " seat(s) canceled successfully.");
        } else {
            System.out.println("Invalid number of seats to cancel.");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bus[] buses = new Bus[2]; // Assuming 2 buses for simplicity

        // Setup Buses
        for (int i = 0; i < buses.length; i++) {
            System.out.println("Setting up Bus " + (i + 1));
            System.out.print("Enter number of seats for Bus " + (i + 1) + ": ");
            int totalSeats = scanner.nextInt();
            buses[i] = new Bus(i + 1, totalSeats);
        }

        int choice;
        do {
            // Display Bus Management System Menu
            System.out.println("\n------------- Bus Management System -------------");
            System.out.println("1- Check Bus\n2- Booking Bus\n3- Cancel Booking\n4- Reset Bus\n5- Exit");
            System.out.print("Choose option (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllBusInformation(buses);
                    break;
                case 2:
                    bookSeats(buses, scanner);
                    break;
                case 3:
                    cancelBooking(buses, scanner);
                    break;
                case 4:
                    // Add logic to reset bus information if needed
                    break;
                case 5:
                    System.out.println("Exiting Bus Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }

        } while (choice != 5);

        scanner.close();
    }

    private static void displayAllBusInformation(Bus[] buses) {
        System.out.println("---------- Display All Bus information ----------");
        System.out.println("Id\tSeat\tAvailable\tUnavailable");
        for (Bus bus : buses) {
            System.out.println(bus.getId() + "\t" + bus.getTotalSeats() + "\t" + bus.getAvailableSeats() + "\t\t" + bus.getUnavailableSeats());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 0 to go back or Bus Id to see details: ");
        int busId = scanner.nextInt();
        if (busId != 0) {
            displayBusInformation(buses, busId);
        }
    }

    private static void displayBusInformation(Bus[] buses, int busId) {
        System.out.println("---------- Display Bus information ----------");
        for (int i = 1; i <= buses[busId - 1].getTotalSeats(); i++) {
            if (i % 5 == 1) {
                System.out.println();
            }
            if (i <= buses[busId - 1].getAvailableSeats()) {
                System.out.print("(+) " + i + "\t");
            } else {
                System.out.print("( - )\t");
            }
        }
        System.out.println();
    }

    private static void bookSeats(Bus[] buses, Scanner scanner) {
        System.out.print("Enter Bus Id for booking: ");
        int busId = scanner.nextInt();
        if (busId >= 1 && busId <= buses.length) {
            System.out.print("Enter number of seats to book: ");
            int seatsToBook = scanner.nextInt();
            buses[busId - 1].bookSeats(seatsToBook);
        } else {
            System.out.println("Invalid Bus Id.");
        }
    }

    private static void cancelBooking(Bus[] buses, Scanner scanner) {
        System.out.print("Enter Bus Id for canceling booking: ");
        int busId = scanner.nextInt();
        if (busId >= 1 && busId <= buses.length) {
            System.out.print("Enter number of seats to cancel: ");
            int seatsToCancel = scanner.nextInt();
            buses[busId - 1].cancelBooking(seatsToCancel);
        } else {
            System.out.println("Invalid Bus Id.");
        }
    }
}
