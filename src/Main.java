
import java.util.Scanner;
public class Main {

    private static final int BUS_ROWS = 1;
    private static final int SEAT_ROWS = 2;
    private static boolean[][] Seats = new boolean[BUS_ROWS][SEAT_ROWS];



    public static void main(String[] args) {

        //create scanner input
        Scanner input = new Scanner(System.in);
        System.out.println("============Setting up bus================");
        System.out.print("Enter number of bus:");
        String BUS_ROWS  = input.nextLine();

        //Integer Bus = Integer.valueOf(Bus);
        System.out.print("Enter number seat of bus :");
        String Seat = input.nextLine();
        Integer SEAT_ROWS = Integer.valueOf(Seat);

        //Create scanner input
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Check Bus");
        System.out.println("2. Booking");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Reset Bus");
        System.out.println("5. Exit");


        //while check condition
        while (true){
            System.out.print("Enter your choose: ");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.println("Id\tSeat\tAvailable\tUnavailable");
                    displayAvailableSeats();
 //                   System.out.println("=======Display all bus information=======");

//                    System.out.println("Enter 0 to back  or Bus  ID to see Detail:");

                    break;
                case 2:
                    bookingBus(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    System.out.println("4. Reset Bus");
                    break;
                case 5:
                    System.out.println("5. Good Bye!");
                    break;
                default:

            }
        }

    }
    private static void displayAvailableSeats() {
        //System.out.println("Available seats:");
        for (int i = 0; i < BUS_ROWS; i++) {
            for (int j = 0; j < SEAT_ROWS; j++) {
                if (!Seats[i][j]) {
                    System.out.println((i + 1)+(j + 1));
                }
            }
        }

    }
    private static void bookingBus(Scanner scanner) {
        System.out.print("Enter row number: ");
        int row = scanner.nextInt();
        System.out.print("Enter seat number: ");
        int seat = scanner.nextInt();

        if (row < 1 || row > BUS_ROWS || seat < 1 || seat > SEAT_ROWS) {
            System.out.println("Invalid seat selection. Please try again.");
            return;
        }

        if (Seats[row - 1][seat - 1]) {
            System.out.println("Seat already booked. Please select another seat.");
        } else {
            Seats[row - 1][seat - 1] = true;
            System.out.println("Seat booked successfully.");
        }

    }
    private static void cancelBooking(Scanner scanner) {
        System.out.print("Enter row number: ");
        int row = scanner.nextInt();
        System.out.print("Enter seat number: ");
        int seat = scanner.nextInt();

        if (row < 1 || row > BUS_ROWS || seat < 1 || seat > SEAT_ROWS) {
            System.out.println("Invalid seat selection. Please try again.");
            return;
        }

        if (!Seats[row - 1][seat - 1]) {
            System.out.println("Seat is not booked. Nothing to cancel.");
        } else {
            Seats[row - 1][seat - 1] = false;
            System.out.println("Booking canceled successfully.");
        }
    }
}


