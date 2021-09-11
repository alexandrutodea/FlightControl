package me.alextodea.FlightControl;

import me.alextodea.FlightControl.logic.FlightControl;
import me.alextodea.FlightControl.ui.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightControl flightControl = new FlightControl();
        UserInterface userInterface = new UserInterface(scanner, flightControl);
        userInterface.start();
    }
}
