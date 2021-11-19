package ui;

import model.Course;
import persistence.CoursesJsonReader;
import persistence.CoursesJsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Manages courses stored in StudyBuddy application
public class CoursesManager implements AgendasManager {
    private static final String JSON_STORE = "./data/courses.json";
    private CoursesJsonWriter jsonWriter;
    private CoursesJsonReader jsonReader;
    private List<Course> courses;
    private Scanner input;
    private CourseManager courseManager;

    // EFFECTS: creates a CoursesManager and creates an empty list of courses
    public CoursesManager() {
        courses = new ArrayList<>();
        input = new Scanner(System.in);
        courseManager = new CourseManager();
        jsonWriter = new CoursesJsonWriter(JSON_STORE);
        jsonReader = new CoursesJsonReader(JSON_STORE);
    }

    // MODIFIES: this
    // EFFECTS: adds courses saved to file to courses
    public void loadSavedCourses() {
        try {
            List<Course> savedCourses = jsonReader.readCourses();
            if (!savedCourses.isEmpty()) {
                courses.addAll(savedCourses);
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    @Override
    // EFFECTS: prints courses menu and prompts user to select an option
    public void displayMenu() {
        String command;
        boolean keepRunning = true;
        while (keepRunning) {
            if (!(courses.isEmpty())) {
                System.out.println("\nHere are your courses: ");
                for (Course c : courses) {
                    System.out.println(c.getName());
                }
            }
            System.out.println("\nSelect from the following options:");
            System.out.println("A -> to view an existing course");
            System.out.println("B -> to add a course");
            System.out.println("C -> to remove a course");
            System.out.println("D -> to go back");
            command = input.next();
            command = command.toUpperCase();
            if (command.equals("D")) {
                keepRunning = false;
            } else {
                processMenuCommand(command);
            }
        }
    }

    @Override
    // EFFECTS: processes option chosen by user in courses menu
    public void processMenuCommand(String command) {
        switch (command) {
            case "A":
                viewAgendaFromAgendas();
                break;
            case "B":
                addAgendaToAgendas();
                break;
            case "C":
                removeAgendaFromAgendas();
                break;
            default:
                System.out.println("This option is invalid. Try again.");
                break;
        }
    }

    @Override
    // EFFECTS: proceeds to display a course only if it exists in user's courses
    public void viewAgendaFromAgendas() {
        if (courses.isEmpty()) {
            System.out.println("You currently don't have any courses to view.");
        } else {
            System.out.println("Enter the name of the course you want to view: ");
            String courseName = input.next();
            for (Course c : courses) {
                if (c.getName().equals(courseName)) {
                    courseManager.displayCourseMenu(c);
                    break;
                }
            }
        }
    }

    @Override
    // MODIFIES: this
    // EFFECTS: adds a new course to user's courses
    public void addAgendaToAgendas() {
        System.out.println("Enter the name of the course you want to add: ");
        String courseName = input.next();
        courses.add(new Course(courseName));
        System.out.println("Course was added!");
    }

    @Override
    // MODIFIES: this
    // EFFECTS: removes a course from user's courses
    public void removeAgendaFromAgendas() {
        System.out.println("Enter the name of the course you want to remove: ");
        String courseName = input.next();
        for (Course c : courses) {
            if (c.getName().equals(courseName)) {
                courses.remove(c);
                System.out.println("Course was removed!");
                break;
            }
        }
    }

    @Override
    // EFFECTS: saves all courses in CoursesManager to file
    public void saveAgendas() {
        try {
            jsonWriter.open();
            jsonWriter.writeCourses(courses);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
}
