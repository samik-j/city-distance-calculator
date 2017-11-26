package cityDistanceCalculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private final CityResource cityResource;
    private static Scanner input = new Scanner(System.in);

    public UserInterface(CityResource cityResource) {
        this.cityResource = cityResource;
    }

    public static void main(String[] args) {
        UserInterface userInterface = null;
        boolean success = false;

        do {
            try {
                userInterface = new UserInterface(new CityResource(new FileReader(getFilePath())));
                success = true;
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Failed to load file");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!success);

        userInterface.run();
    }


    private void run() {
        String quit;

        do {
            getDistanceBetween();

            System.out.println("continue or q to quit");
            quit = input.nextLine();

        } while (!quit.equals("q"));
    }

    private void getDistanceBetween() {
        String city1 = getCityName();
        String city2 = getCityName();

        try {
            System.out.println("Distance: " + cityResource.getDistanceBetween(city1, city2) + "km");
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
