package ui;

import java.util.Scanner;

public class StudyBuddyApp {
    private CoursesManager coursesManager;
    private ClubsManager clubsManager;
    private Scanner input;


    // EFFECTS: initializes fields and runs the StudyBuddy application
    public StudyBuddyApp() {
        initialize();
        displayMainMenu();
    }

    // MODIFIES: this
    // EFFECTS: initializes lists for user's clubs and courses
    private void initialize() {
        input = new Scanner(System.in);
        coursesManager = new CoursesManager();
        clubsManager = new ClubsManager();
    }

    // EFFECTS: prints main menu and prompts user to select an option
    private void displayMainMenu() {
        boolean keepRunning = true;
        String command;
        System.out.println("Hi there! Let's take your time management to the next level.");
        while (keepRunning) {
            System.out.println("\nSelect from the following options:");
            System.out.println("A -> to see your courses");
            System.out.println("B -> to see your clubs");
            System.out.println("C -> to quit application");
            command = input.next();
            command = command.toUpperCase();
            if (command.equals("C")) {
                System.out.println("See you next time!");
                keepRunning = false;
            } else {
                processMainMenuCommand(command);
            }
        }
    }

    // EFFECTS: processes option chosen by user in main menu
    private void processMainMenuCommand(String command) {
        if (command.equals("A")) {
            coursesManager.displayMenu();
        } else if (command.equals("B")) {
            clubsManager.displayMenu();
        } else {
            System.out.println("This option is invalid. Try again.");
        }
    }
}
