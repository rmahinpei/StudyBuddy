package ui;

import model.Club;
import model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudyBuddyApp {
    private List<Course> courses;
    private List<Club> clubs;
    private Scanner input;

    // EFFECTS: runs the StudyBuddy application
    public StudyBuddyApp() {
        runStudyBuddy();
    }

    private void runStudyBuddy() {
        boolean keepRunning = true;
        String command;
        initialize();
        System.out.println("Hi there! Let's take your time management to the next level.");
        while (keepRunning) {
            displayMainMenu();
            command = input.next();
            command = command.toUpperCase();
            if (command.equals("C")) {
                System.out.println("See you next time!");
                keepRunning = false;
            } else {
                processMainCommand(command);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes lists for user's clubs and courses
    private void initialize() {
        courses = new ArrayList<>();
        clubs = new ArrayList<>();
        input = new Scanner(System.in);
    }

    // EFFECTS: displays main menu's options to user
    private void displayMainMenu() {
        System.out.println("\nSelect from the following options:");
        System.out.println("A -> to see your courses");
        System.out.println("B -> to see your clubs");
        System.out.println("C -> to quit application");
    }

    private void processMainCommand(String command) {
        if (command.equals("A")) {
            displayCoursesMenu();
        } else if (command.equals("B")) {
            displayClubsMenu();
        } else {
            System.out.println("This option is invalid. Try again.");
        }
    }

    private void displayCoursesMenu() {
        String command;
        boolean keepRunning = true;
        while (keepRunning) {
            if (!(courses.isEmpty())) {
                System.out.println("Here are your courses: ");
                for (Course c : courses) {
                    System.out.println(c.getName());
                }
            }
            System.out.println("\nSelect from the following options:");
            System.out.println("A -> to view an existing course");
            System.out.println("B -> to add another course");
            System.out.println("C -> to remove a course");
            System.out.println("D -> to go back");
            command = input.next();
            command = command.toUpperCase();
            if (command.equals("D")) {
                keepRunning = false;
            } else {
                processCoursesCommand(command);
            }
        }
    }

    private void processCoursesCommand(String command) {
        String courseName;
        if (command.equals("A")) {
            if (courses.isEmpty()) {
                System.out.println("You currently don't have any courses.");
            } else {
                System.out.println("Enter the name of the course: ");
                courseName = input.next();
            }
        } else if (command.equals("B")) {
            System.out.println("Enter the name of the course: ");
            courseName = input.next();
            courses.add(new Course(courseName));
            System.out.println("Course was added!");
        } else if (command.equals("C")) {
            System.out.println("Enter the name of the course: ");
            courseName = input.next();
            for (Course c : courses) {
                if (c.getName().equals(courseName)) {
                    courses.remove(c);
                    System.out.println("Course was removed!");
                    break;
                }
            }
        } else {
            System.out.println("This option is invalid. Try again.");
        }
    }

    private void displayClubsMenu() {
        // stub
    }



}
