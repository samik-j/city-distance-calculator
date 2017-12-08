package com.joanna.citydistancecalculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private final static Scanner input = new Scanner(System.in);
    private final CityStorage cityStorage;

    private UserInterface(CityStorage cityStorage) throws IOException {
        this.cityStorage = cityStorage;
    }

    public static void main(String[] args) {
        UserInterface userInterface = createUserInterface();

        String quit;

        do {
            userInterface.calculateDistance(getCityName(), getCityName());

            System.out.println("continue or q to quit");
            quit = input.nextLine();

        } while (!quit.equals("q"));
    }

    private static UserInterface createUserInterface() {
        UserInterface userInterface = null;
        boolean success = false;

        do {
            try {
                userInterface = new UserInterface(new CityStorage(new FileReader(getFilePath())));
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

    private static String getFilePath() {
        System.out.println("Enter file path:");

        return input.nextLine();
    }

    private static String getCityName() {
        System.out.println("Enter city name:");

        return input.nextLine();
    }

    private void calculateDistance(String city1, String city2) {

        try {
            System.out.println("Distance: " + cityStorage.calculateDistanceBetween(city1, city2) + "km");
        } catch (CityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
