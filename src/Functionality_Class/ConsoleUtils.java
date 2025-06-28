package Functionality_Class;

import java.util.Scanner;

public class ConsoleUtils {
    public static void pauseScreen(Scanner scanner) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine(); // Waits for the user to press Enter
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
