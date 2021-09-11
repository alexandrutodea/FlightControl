package me.alextodea.FlightControl.ui;

import me.alextodea.FlightControl.domain.Airplane;
import me.alextodea.FlightControl.domain.Flight;
import me.alextodea.FlightControl.logic.FlightControl;

import java.util.Scanner;

public class    UserInterface {
    final private Scanner scanner;
    final private FlightControl flightControl;

    public UserInterface(Scanner scanner, FlightControl flightControl) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("Choose an action:\n" +
                               "[1] Add an airplane\n" +
                               "[2] Add a flight\n" +
                               "[x] Exit Airport Asset Control");
            String input = scanner.nextLine();

            if (input.equals("1")) {

                System.out.print("Give the airplane id: ");
                String airplaneID = scanner.nextLine();
                System.out.print("Give the airplane capacity: ");
                String capacity = scanner.nextLine();
                if (capacity.matches("[0-9]*")) {
                    Airplane airplane = new Airplane(airplaneID, Integer.parseInt(capacity));
                    this.flightControl.addAirplane(airplane);
                } else {
                    System.out.println("Invalid capacity. Try again.");
                }

            } else if (input.equals("2")) {

                System.out.print("Give the airplane id: ");
                String airplaneID = scanner.nextLine();
                System.out.print("Give the departure airport id: ");
                String departureAirportID = scanner.nextLine();
                System.out.print("Give the target airport id: ");
                String targetAirportID = scanner.nextLine();

                Airplane airplane = this.flightControl.getAirplaneByID(airplaneID);

                if (airplane != null) {
                    Flight flight = new Flight(airplane, departureAirportID, targetAirportID);
                    try {
                        this.flightControl.addFlight(flight);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Invalid airplane ID. Try again.");
                }

            } else if (input.equals("x")) {

                while (true) {
                    System.out.println("Choose an action:\n" +
                                       "[1] Print airplanes\n" +
                                       "[2] Print flights\n" +
                                       "[3] Print airplane details\n" +
                                       "[x] Quit");
                    String secondPartInput = scanner.nextLine();

                    if (secondPartInput.equals("1")) {
                        this.flightControl.printAirplanes();
                    } else if (secondPartInput.equals("2")) {
                        this.flightControl.printFlights();
                    } else if (secondPartInput.equals("3")) {
                        System.out.print("Give the airplane id:");
                        String ID = scanner.nextLine();
                        Airplane airplane = this.flightControl.getAirplaneByID(ID);
                        if (airplane != null) {
                            System.out.println(airplane);
                        } else {
                            System.out.println("Invalid airplane ID. Try again.");
                        }
                    } else if (secondPartInput.equals("x")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                }

                break;

            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }
}
