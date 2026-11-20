package com.pluralsight;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        //Create new user interface to run
        UserInterface userInterface = new UserInterface();

        //Call display method to run the user interface
        userInterface.display();
    }

    Dealership dealership;

    public UserInterface() {

    }

    public void display() {
        //Initialize the start of display
        init();

        Scanner input = new Scanner(System.in);

        //Add boolean (appRunning) = true
        //While loop to keep the interface menu running until close
        boolean appRunning = true;
        while (appRunning) {
            System.out.println("Welcome to the Dealership");
            System.out.println("""
                    Which Option Would You Like To Choose
                    1. Search By Price
                    2. Search by Make/Model
                    3. Search by Year
                    4. Search by Color
                    5. Search by Mileage
                    6. Search by Type
                    7. Search by All Vehicles
                    8. Add Vehicle
                    9.Remove Vehicle
                    10.Sell/Lease Vehicle
                    99.Exit""");

            System.out.println("Enter your choice");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    processByGetPriceRequest();
                    break;
                case 2:
                    processByGetMakeAndModelRequest();
                    break;
                case 3:
                    processByGetYearRequest();
                    break;
                case 4:
                    processGetColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehicleRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processSaleLeaseRequest();
                    break;
                case 99:
                    System.out.println("Exiting...");
                    appRunning = false;
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
        //Create for loop to list all the vehicles in the inventory
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    public void processGetAllVehicleRequest() {

        displayVehicles(dealership.getAllVehicles());
    }

    public void processGetColorRequest() {
        //ask user the colors
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your color");
        String color = input.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    public void processByGetPriceRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum price: ");
        BigDecimal min = scanner.nextBigDecimal();

        System.out.print("Enter maximum price: ");
        BigDecimal max = scanner.nextBigDecimal();

        displayVehicles(dealership.getAllVehiclesByPrice(min, max));
    }

    public void processByGetMakeAndModelRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Make : ");
        String make = scanner.next();
        System.out.print("Enter Model : ");
        String model = scanner.next();

        displayVehicles(dealership.getVehiclesByMakeAndModel(make, model));

    }

    public void processByGetYearRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Min Year : ");
        int min = scanner.nextInt();
        System.out.print("Enter Max Year : ");
        int max = scanner.nextInt();

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Minimum Mileage : ");
        BigDecimal min = scanner.nextBigDecimal();
        System.out.print("Enter Maximum Mileage : ");
        BigDecimal max = scanner.nextBigDecimal();

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Type : ");
        String type = scanner.next();

        displayVehicles(dealership.getVehiclesByType(type));
    }

    public void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);

        //User will input all information for the new car input
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer: ");
        int odometer = scanner.nextInt();

        System.out.print("Enter price: ");
        BigDecimal price = scanner.nextBigDecimal();

        //Initializing new vehicle
        Vehicle vehicle = new Vehicle(vin, year, make, model,
                vehicleType, color, odometer, price);

        //Add new vehicle to the inventory
        dealership.addVehicle(vehicle);

        //Save the updated dealership to the file
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);

        //Thank you message
        System.out.println("Vehicle successfully added!");

    }

    public void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);

        //Prompt user to enter Vin
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();

        //Variable for removed vehicle
        Vehicle vehicleRemoved = null;

        //Add for loop to check if the user input vin matches the vin on file
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleRemoved = vehicle;
                break;
            }
        }

        //If the vehicleRemoved input isnt blank
        if (vehicleRemoved != null) {
            dealership.removeVehicle(vehicleRemoved);

            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);

            System.out.println("Vehicle successfully removed!");
        } else {
            System.out.println("Vehicle not found!");
        }

    }

    public void processSaleLeaseRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Are you under contract? (Yes/No) ");
        String contract = scanner.nextLine();

        if (contract.equalsIgnoreCase("Yes")) {
            System.out.println("Entering Contracts Screen \n");
            processContractRequest();
        } else if (contract .equalsIgnoreCase("No")) {
            System.out.println("Must be under contract \n");
            display();
            scanner.close();
        }
    }

    public void processContractRequest() {
        //Input scanner
        Scanner scanner = new Scanner(System.in);

        //Prompt user to enter whether this is a salesContract or LeaseContract
        System.out.println("Which type of contract are you under? (Sales/Lease)");
        System.out.println("May not lease vehicle over 3 years old");
        String contract = scanner.nextLine();

        if (contract.equals("Sales")) {
            processSalesContractRequest();
            //Add else if statement for lease contract
        } else if (contract.equals("Lease")) {
            processLeaseContractRequest();
        }
    }

    public void processSalesContractRequest() {
        Scanner scanner = new Scanner(System.in);

        //Prompt user to enter the date of their contract
        System.out.println("Enter the date of your current contract");
        String contractDate = scanner.nextLine();

        //Prompt user to enter their name
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        //Prompt user to enter their email
        System.out.println("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        //Prompt user to enter the vehicle sold
        System.out.println("Enter vehicle sold: ");
        String vehicleSold = scanner.nextLine();

        //Retrieve total price
        System.out.println("Enter price of vehicle sold: ");
        Double price = scanner.nextDouble();

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (price.equals(vehicle.getPrice())) {
                System.out.println(price);
            } else {
                System.out.println("Re-enter price of vehicle sold");
            }

        }

        Contract contract = new Contract (contractDate,customerName,customerEmail,vehicleSold,price,0.0);

    }

    public void processLeaseContractRequest() {
        Scanner scanner = new Scanner(System.in);

        //Prompt user to enter the date of their contract
        System.out.println("Enter the date of your current contract");
        String contractDate = scanner.nextLine();

        //Prompt user to enter their name
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        //Prompt user to enter their email
        System.out.println("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        //Prompt user to enter the vehicle sold
        System.out.println("Enter vehicle sold: ");
        String vehicleSold = scanner.nextLine();

        //Retrieve total price
        System.out.println("Enter price of vehicle sold: ");
        BigDecimal price = scanner.nextBigDecimal();

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (price.equals(vehicle.getPrice())) {
                System.out.println(price);
            } else {
                System.out.println("Re-enter price of vehicle sold");
            }

        }
    }
}
