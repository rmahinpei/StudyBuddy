package ui;

import model.Event;
import model.EventLog;

import java.util.Scanner;

// Main menu of StudyBuddy application
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
        System.out.println("Do you want to load your saved edits?\nEnter Yes or No: ");
        command = input.next();
        if (command.equals("Yes")) {
            loadEdits();
        }
        while (keepRunning) {
            printMainMenuOptions();
            command = input.next();
            if (command.equals("C")) {
                System.out.println("Want to save your edits before you quit?\nEnter Yes or No: ");
                command = input.next();
                if (command.equals("Yes")) {
                    saveEdits();
                }
                keepRunning = false;
            } else {
                processMainMenuCommand(command);
            }
        }
        printLogs();

    }

    private void loadEdits() {
        coursesManager.loadSavedCourses();
        clubsManager.loadSavedClubs();
    }

    // EFFECTS: saves changes made to state of app to file upon user's request
    private void saveEdits() {
        clubsManager.saveAgendas();
        coursesManager.saveAgendas();
        System.out.println("Saved all your edits!\n");
    }

    // EFFECTS: prints main menu options for user
    private void printMainMenuOptions() {
        System.out.println("\nSelect from the following options:");
        System.out.println("A -> to see your courses\nB -> to see your clubs\nC -> to quit application");
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

    // EFFECTS: prints event logs to the console once the user chooses to quit app
    private void printLogs() {
        for (Event next : EventLog.getInstance()) {
            System.out.println(next.toString() + "\n");
        }
    }
}
