import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BusManagementSystem {


    public static  int BUS ;
    public static int SEAT ;

    public static String[][] arrBus = new String[BUS][SEAT];


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
            System.out.println("============Setting up bus================");
            System.out.print("Enter number of bus:");
//            int userInput = scanner.nextInt();


//            // Regular expression for integer or decimal numbers
//            String numberRegex = "^\\d+(\\.\\d+)?$";
//
//            // Create a Pattern object
//            Pattern pattern = Pattern.compile(numberRegex);
//
//            // Create a Matcher object
//            Matcher matcher = pattern.matcher(userInput);
//
//            // Check if the input matches the number pattern
//            if (matcher.matches()) {
//                System.out.println("Valid number input: " + userInput);
//                // Further processing with the number
//            } else {
//                System.out.println("Invalid input. Please enter a valid number.");
//            }

            BUS = scanner.nextInt();
            System.out.print("Enter number seat of bus :");
            SEAT = scanner.nextInt();
            arrBus = new String[BUS][SEAT];

        while (true){
            displayList();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    BusInformation(BUS,SEAT);
                    break;
                case 2:
                    bookingBus(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    resetBus(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 5.");
            }
        }
    }
    private static void displayList() {
        //println option
        System.out.println("================ Bus Management System ================");
        System.out.println("1- Check Bus:");
        System.out.println("2- Booking Bus:");
        System.out.println("3- Cancel Booking:");
        System.out.println("4- Reset Bus:");
        System.out.println("5- Exit:");
        System.out.print("Choose option (1-5): ");
    }

    private static void BusInformation(int BUS,int SEAT) {
        //for loop for display information bus
        System.out.println("Id Seat Available Unavailable");
        int available = SEAT;
        int unavailable;
        for (int i = 0; i <BUS;i++) {
            unavailable=0;
            for(int j=0;j<SEAT;j++){
                if(arrBus[i][j]!=null){
                      unavailable++;
                }
            }
            System.out.println(i+1 + "\t" + SEAT + "\t\t" + (available-unavailable)+"\t\t\t"+unavailable);
        }
        //back return show information
//        System.out.print("Enter 0 to back or BusID to show detail bus:");
//        int ch = new Scanner(System.in).nextInt();
//        if (ch==0){ return;
//        }else {displayBusInformation(ch); return;}

    }

    private static void displayBusInformation(int busId) {
        System.out.println("=============== Display Bus information ================");
        for (int i = 0; i < SEAT; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            if (arrBus[busId - 1][i] == null) {
                System.out.print("(+) " + (i + 1) + "   ");
            } else {
                System.out.print("(-) " + (i + 1) + "   ");
            }
        }
        System.out.println("\n( - ) : Unavailable(" + (SEAT - countAvailableSeats(arrBus[busId - 1]))
                + ") ( + ) : Available(" + countAvailableSeats(arrBus[busId - 1]) + ")");
    }

    private static void bookingBus(Scanner scanner) {
        while (true) {
            System.out.print("Enter bus's Id: ");
            int busId = scanner.nextInt();
            if (busId >= 1 && busId <= arrBus.length) {
                displayBusInformation(busId);

                System.out.print("Enter chair number for seat booking: ");
                int seatToBook = scanner.nextInt();

                if (seatToBook > 1 && seatToBook <= arrBus[0].length) {
                    System.out.print("Do you want to book this chair? (y/n): ");
                    char choice = scanner.next().charAt(0);

                    if (choice == 'y' || choice == 'Y') {
                        if (arrBus[busId - 1][seatToBook - 1] == null) {
                            arrBus[busId - 1][seatToBook - 1] = "1";
                            System.out.println("Chair number " + seatToBook + " was booked successfully!");
                        } else {
                            System.out.println("The seat is already booked.");
                        }
                    } else {
                        System.out.println("Booking is canceled.");
                    }

                    // Break out of the loop if the input is valid
                    break;
                } else {
                    System.out.println("Invalid seat number. Booking failed.");
                }
            } else {
                System.out.println("Invalid bus ID. Please enter a valid bus ID.");
            }
        }

    }
    private static void cancelBooking(Scanner scanner) {
        while (true) {
            System.out.print("Enter bus's Id: ");
            int busId = scanner.nextInt();

            // Check if the input is within valid range
            if (busId >= 1 && busId <= arrBus.length) {
                displayBusInformation(busId);

                System.out.print("Enter Seat number to cancel booking: ");
                int seatToCancel = scanner.nextInt();
                // Check if the seat number is within valid range
                if (seatToCancel > 1 && seatToCancel <= arrBus[0].length) {
                    if (arrBus[busId - 1][seatToCancel - 1] != null) {
                        System.out.print("Do you want to cancel book chair number " + seatToCancel + "? (y/n): ");
                        char choose = scanner.next().charAt(0);

                        if (choose == 'y' || choose == 'Y') {
                            arrBus[busId - 1][seatToCancel - 1] = null;
                            System.out.println("Seat number " + seatToCancel + " was canceled booking successfully!");
                            break;
                        } else {
                            System.out.println("Booking cancellation canceled.");
                        }
                    } else {
                        System.out.println("The seat is not booked.");
                    }

//                    // Check if busId is not equal to seatToCancel
//                    if (busId != seatToCancel) {
//                        // Break out of the loop if the input is valid
//                        break;
//                    } else {
//                        System.out.println("Bus ID and Seat number cannot be the same. Please enter valid inputs.");
//                    }
                } else {
                    System.out.println("Invalid seat number. Please enter a valid seat number.");
                }
            } else {
                System.out.println("Invalid bus ID. Please enter a valid bus ID.");
            }
        }

    }

    private static void resetBus(Scanner scanner) {

        //Input bus ID
        System.out.print("Enter bus's Id: ");
        int busId = scanner.nextInt();
        for (int i = 0; i < SEAT; i++) {
            arrBus[busId - 1][i] = null;
        }
        System.out.println("Bus id " + busId + " was reset with all seats available.");
    }
    private static int countAvailableSeats(String[] seats) {
        int count = 0;
        for (String seat : seats) {
            if (seat==null) {
                count++;
            }
        }
        return count;
    }
}
