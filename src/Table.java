
public class Table {
    private static void displayAllBusInformation(int[][] busSeats) {
        System.out.println("---------- Display All Bus information ----------");
        System.out.println("Id\tSeat\tAvailable\tUnavailable");

        for (int i = 0; i < busSeats.length; i++) {
            int availableSeats = 0;
            int unavailableSeats = 0;

            for (int j = 0; j < busSeats[i].length; j++) {
                if (busSeats[i][j] == 0) {
                    availableSeats++;
                } else {
                    unavailableSeats++;
                }
            }

            System.out.println((i + 1) + "\t" + busSeats[i].length + "\t" + availableSeats + "\t\t" + unavailableSeats);
        }

        // TODO: Add option to display detailed information for a specific bus
        // ...

    }
}
