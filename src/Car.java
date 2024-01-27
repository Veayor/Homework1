
import java.util.Scanner;

public class Car {

    public static void main(String[] args) {
//        Inhertand in = new Inhertand();
//        in.Input();
//        in.Show();
        // Assuming a maximum of 5 buses for simplicity

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of buses: ");
        int numberOfBuses = scanner.nextInt();

        for (int i = 1; i <= numberOfBuses; i++) {
            System.out.print("Enter the number of seats for Bus " + i + ": ");
            int numberOfSeats = scanner.nextInt();

            // You can perform further setup or processing for each bus here

            System.out.println("Bus " + i + " set up with " + numberOfSeats + " seats.");
        }

//        scanner.close();

        int choice;

        do {
            System.out.println("------------- Bus Management System --------------");
            System.out.println("1- Check Bus");
            System.out.println("2- Booking Bus");
            System.out.println("3- Cancel Booking");
            System.out.println("4- Reset Bus");
            System.out.println("5- Exit");

            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBus();
                    break;
                case 2:
                    bookBus();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    resetBus();
                    break;
                case 5:
                    System.out.println("Exiting the Bus Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void checkBus() {
        int[][] busSeats = new int[5][45]; // Assuming each bus has 45 seats
        System.out.println("---------- Display All Bus Information ----------");
        System.out.println("Id Seat Available Unavailable");
        for (int i = 0; i < busSeats.length; i++) {
            int availableSeats = 0;
            for (int seat : busSeats[i]) {
                if (seat == 0) {
                    availableSeats++;
                }
            }
            int unavailableSeats = busSeats[i].length - availableSeats;
            System.out.println((i + 1) + " 45 " + availableSeats + " " + unavailableSeats);
        }

        System.out.print("Enter 0 to go back or Bus Id to see details: ");
        Scanner scanner = new Scanner(System.in);
        int busId = scanner.nextInt();

        if (busId != 0 && busId >= 1 && busId <= busSeats.length) {
            displayBusDetails(busId);
        }

    }
    private static void displayBusDetails(int busId) {
        int[][] busSeats = new int[5][45];
        System.out.println("---------- Display Bus Information ----------");
        System.out.println("(+) : Available, ( - ) : Unavailable(0)");

        for (int row = 0; row < 9; row++) {
            for (int seat = 1; seat <= 5; seat++) {
                int seatNumber = row * 5 + seat;
                char status = (busSeats[busId - 1][seatNumber - 1] == 0) ? '+' : '-';
                System.out.print("(" + status + ") " + seatNumber + "\t");
            }
            System.out.println();
        }
    }

    private static void bookBus() {
        int[][] busSeats = new int[5][45];
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter bus's Id: ");
        int busId = scanner.nextInt();

        if (busId >= 1 && busId <= busSeats.length) {
            displayBusDetails(busId);

            System.out.print("Enter Chair number to booking: ");
            int chairNumber = scanner.nextInt();

            if (chairNumber >= 1 && chairNumber <= 45) {
                if (busSeats[busId - 1][chairNumber - 1] == 0) {
                    System.out.print("Do you want to book chair number " + chairNumber + "? (y/n): ");
                    char choice = scanner.next().charAt(0);

                    if (choice == 'y' || choice == 'Y') {
                        busSeats[busId - 1][chairNumber - 1] = 1;
                        System.out.println("Chair number " + chairNumber + " was booked successfully!");
                    } else {
                        System.out.println("Booking canceled.");
                    }
                } else {
                    System.out.println("Chair number " + chairNumber + " is already booked.");
                }
            } else {
                System.out.println("Invalid chair number. Please enter a number between 1 and 45.");
            }
        } else {
            System.out.println("Invalid bus Id. Please enter a number between 1 and " + busSeats.length + ".");
        }
    }

    private static void cancelBooking() {
        Scanner scanner = new Scanner(System.in);
        int[][] busSeats = new int[5][45];

        System.out.print("Enter bus's Id: ");
        int busId = scanner.nextInt();

        if (busId >= 1 && busId <= busSeats.length) {
            displayBusDetails(busId);

            System.out.print("Enter Seat number to cancel booking: ");
            int seatNumber = scanner.nextInt();

            if (seatNumber >= 1 && seatNumber <= 45) {
                if (busSeats[busId - 1][seatNumber - 1] == 1) {
                    System.out.print("Do you want to cancel book chair number " + seatNumber + "? (y/n): ");
                    char choice = scanner.next().charAt(0);

                    if (choice == 'y' || choice == 'Y') {
                        busSeats[busId - 1][seatNumber - 1] = 0;
                        System.out.println("Seat number " + seatNumber + " was canceled booking successfully!");

                        // Display updated bus information after cancellation
                        displayBusDetails(busId);
                    } else {
                        System.out.println("Cancellation canceled.");
                    }
                } else {
                    System.out.println("Seat number " + seatNumber + " is not booked.");
                }
            } else {
                System.out.println("Invalid seat number. Please enter a number between 1 and 45.");
            }
        } else {
            System.out.println("Invalid bus Id. Please enter a number between 1 and " + busSeats.length + ".");
        }
    }

    private static void resetBus() {
        Scanner scanner = new Scanner(System.in);
        int[][] busSeats = new int[5][45];

        System.out.print("Enter bus's Id: ");
        int busId = scanner.nextInt();

        if (busId >= 1 && busId <= busSeats.length) {
            System.out.print("Bus id " + busId + " was reset with all seats available? (y/n): ");
            char choice = scanner.next().charAt(0);

            if (choice == 'y' || choice == 'Y') {
                for (int i = 0; i < busSeats[busId - 1].length; i++) {
                    busSeats[busId - 1][i] = 0;
                }
                System.out.println("Bus id " + busId + " was reset successfully!");
            } else {
                System.out.println("Reset canceled.");
            }
        } else {
            System.out.println("Invalid bus Id. Please enter a number between 1 and " + busSeats.length + ".");
        }

    }

}