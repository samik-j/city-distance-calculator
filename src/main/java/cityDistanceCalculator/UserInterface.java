package cityDistanceCalculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private final CityStorage cityStorage;
    private static Scanner input = new Scanner(System.in);

    private UserInterface(CityStorage cityStorage) throws IOException {
        this.cityStorage = cityStorage;
    }

    public static void main(String[] args) {
        UserInterface userInterface = getUserInterface();

        String quit;

        do {
            userInterface.getDistance();

            System.out.println("continue or q to quit");
            quit = input.nextLine();

        } while (!quit.equals("q"));
    }

    private static UserInterface getUserInterface() {
        UserInterface userInterface = null;
        boolean success = false;

        do {
            try {
                userInterface = new UserInterface(new CityStorage(new FileReader(getFilePath()).readFile()));
                success = true;
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Failed to load file");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!success);

        return userInterface;
    }

    private void getDistance() {
        String city1 = getCityName();
        String city2 = getCityName();

        try {
            System.out.println("Distance: " + cityStorage.getDistanceBetween(city1, city2) + "km");
        } catch (CityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getFilePath() {
        System.out.println("Enter file path:");

        return input.nextLine();
    }

    private String getCityName() {
        System.out.println("Enter city name:");

        return input.nextLine();
    }
}
