package cityDistanceCalculator;

import java.util.Scanner;

public class UserInterface {

    private final CityResource resources;
    private static Scanner input = new Scanner(System.in);

    public UserInterface(CityResource resources) {
        this.resources = resources;
    }

    public static void main(String[] args) {
        UserInterface userInterface = null;
        String filePath = getFilePath();

        try {
            userInterface = new UserInterface(new CityResource(new FileReader(filePath)));
        } catch (Exception e) {
            System.out.println("Failed to load file");
            return;
        }

        userInterface.run();
    }

    private void run() {
        String city1 = getCityName();
        String city2 = getCityName();

        try {
            System.out.print("Distance: " + resources.getDistanceBetween(city1, city2) + "km");
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
