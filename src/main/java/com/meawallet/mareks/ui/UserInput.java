package com.meawallet.mareks.ui;


import com.meawallet.mareks.dto.CreateCarInRequest;
import com.meawallet.mareks.dto.CreateDealershipInRequest;
import com.meawallet.mareks.dto.CreateUserInRequest;
import com.meawallet.mareks.ui.exception.UserValidationException;

import java.util.Scanner;

public class UserInput {

    public int getMenuAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter menu action: ");
        return scanner.nextInt();
    }

    public CreateUserInRequest getCreateUserInRequest() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter user name:");
            String name = scanner.nextLine();
            System.out.println("Please enter user surname:");
            String surname = scanner.nextLine();
            System.out.println("Please enter user email:");
            String email = scanner.nextLine();
            System.out.println("Please enter user phone number:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Please enter user town:");
            String town = scanner.nextLine();
            return new CreateUserInRequest(name, surname, email, phoneNumber, town);
        } catch (NumberFormatException e) {
            throw new UserValidationException("Something is incorrect: " + e.getMessage());
        }
    }
    public CreateCarInRequest getCreateCarInRequest() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter car brand:");
            String brand = scanner.nextLine();
            System.out.println("Please enter car model:");
            String model = scanner.nextLine();
            System.out.println("Please enter car year:");
            Integer year = Integer.valueOf(scanner.nextLine());
            System.out.println("Please enter car engine type:");
            String engineType = scanner.nextLine();
            System.out.println("Please enter car engine volume:");
            Double engineVolume = Double.valueOf(scanner.nextLine());
            System.out.println("Please enter car horse power:");
            Short horsePower = Short.valueOf(scanner.nextLine());
            System.out.println("Please enter car driver kilometers:");
            Integer driverKm = Integer.valueOf(scanner.nextLine());
            System.out.println("Please enter car number plate:");
            String numberPlate = scanner.nextLine();

            return new CreateCarInRequest(brand, model, year, engineType, engineVolume, horsePower, driverKm, numberPlate);
        } catch (NumberFormatException e) {
            throw new UserValidationException("Something is incorrect: " + e.getMessage());
        }
    }

    public CreateDealershipInRequest getCreateDealershipInRequest() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter dealership name:");
            String name = scanner.nextLine();
            System.out.println("Please enter dealership location:");
            String location = scanner.nextLine();

            return new CreateDealershipInRequest(name, location);
        } catch (NumberFormatException e) {
            throw new UserValidationException("Something is incorrect: " + e.getMessage());
        }
    }

    public Integer getUserId() {
        var scanner = new Scanner(System.in);
        System.out.println("Please enter user id: ");
        return scanner.nextInt();
    }
}

