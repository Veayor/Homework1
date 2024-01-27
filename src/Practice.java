import java.util.Scanner;
    public class Practice {
        private static final int ROWS = 15;
        private static final int SEATS = 12;
        private static char[][] seats = new char[ROWS][SEATS];

        public static void main(String[] args) {
            initializeSeats();
            printSeats();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nEnter B(ooking), C(ancel) or eXit: ");
                String option = scanner.nextLine().toUpperCase();
                if (option.equals("B")) {
                    bookSeat(scanner);
                } else if (option.equals("C")) {
                    cancelSeat(scanner);
                } else if (option.equals("X")) {
                    break;
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
                printSeats();
            }
        }

        private static void initializeSeats() {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < SEATS; j++) {
                    seats[i][j] = '0';
                }
            }
        }

        private static void printSeats() {
            System.out.println("Current seating arrangement:");
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < SEATS; j++) {
                    System.out.print(seats[i][j] + " ");
                }
                System.out.println();
            }
        }

        private static void bookSeat(Scanner scanner) {
            System.out.println("Enter Row (1-" + ROWS + "): ");
            int row = scanner.nextInt();
            System.out.println("Enter Seat No (1-" + SEATS + "): ");
            int seat = scanner.nextInt();
            if (seats[row - 1][seat - 1] == '0') {
                seats[row - 1][seat - 1] = 'X';
                System.out.println("Booking confirmed for row " + row + ", seat " + seat);
            } else {
                System.out.println("Seat " + row + "," + seat + " is already booked.");
            }
        }

        private static void cancelSeat(Scanner scanner) {
            System.out.println("Enter Row (1-" + ROWS + "): ");
            int row = scanner.nextInt();
            System.out.println("Enter Seat No (1-" + SEATS + "): ");
            int seat = scanner.nextInt();
            if (seats[row - 1][seat - 1] == 'X') {
                seats[row - 1][seat - 1] = '0';
                System.out.println("Cancellation confirmed for row " + row + ", seat " + seat);
            } else {
                System.out.println("No booking found for row " + row + ", seat " + seat);
            }
        }
    }
