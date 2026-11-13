package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    Dealership dealership;

    public UserInterface() {
        init();
    }

    public void display() {
        init();

        Scanner input = new Scanner(System.in);

        boolean appRunning = true;
        while (appRunning) {
            System.out.println("1. Display All Vehicles");
            System.out.println("2. Get Vehicles By Color");
            System.out.println("Exit");

            System.out.println("Enter your choice");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    processGetAllVehicleRequest();
                    break;
                case 2:
                    processGetColorRequest();
                    break;
                case 3:
                    processByGetPrice();
                    break;
                case 4:
                    System.out.println("Exit");
                case 5:
                    System.out.println("Exit");
                case 6:
                    System.out.println("Exit");
                case 7:
                    System.out.println("Exit");
                case 8:
                    appRunning = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public void init() {

        //creat dealership file manager
        DealershipFileManager dealership = new DealershipFileManager();
        this.dealership = dealership.getDealership();
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    public void processGetAllVehicleRequest() {

        displayVehicles(dealership.getAllVehicles());
    }

    public void processGetColorRequest() {
        //ask user the colors

        String color = "blue";

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processByGetPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum price: ");
        BigDecimal min = scanner.nextBigDecimal();

        System.out.print("Enter maximum price: ");
        BigDecimal max = scanner.nextBigDecimal();

        displayVehicles(dealership.getAllVehiclesByPrice(min, max));
    }
}
