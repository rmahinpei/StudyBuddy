package ui;

import model.*;

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
                for (Course c : courses) {
                    if (c.getName().equals(courseName)) {
                        displayCourse(c);
                        break;
                    }
                }
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

    private void displayCourse(Course course) {
        String command;
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Here are the dates in " + course.getName() + ":");
            for (Date d : course.getDates()) {
                System.out.println(d.dateToString());
            }
            System.out.println("Here are the topics in " + course.getName() + ":");
            for (Topic t : course.getTopics()) {
                System.out.println(t.getTopicName() + ": completed Qs = " + t.getNumCompleted()
                        + ", remaining Qs = " + t.getNumRemaining());
            }
            System.out.println("\nSelect from the following options:");
            System.out.println("A -> to add a date");
            System.out.println("B -> to remove a date");
            System.out.println("C -> to add a topic");
            System.out.println("D -> to remove a topic");
            System.out.println("E -> to complete a question for a topic");
            System.out.println("F -> to go back");
            command = input.next();
            command = command.toUpperCase();
            if (command.equals("F")) {
                keepRunning = false;
            } else {
                processCourseCommand(command, course);
            }
        }
    }

    private void processCourseCommand(String command, Course course) {
        if (command.equals("A")) {
            System.out.println("Enter the year: ");
            int year = input.nextInt();
            System.out.println("Enter the month: ");
            int month = input.nextInt();
            System.out.println("Enter the day: ");
            int day = input.nextInt();
            System.out.println("Classify this date by selecting from the following:");
            System.out.println("1 -> EXAM");
            System.out.println("2 -> ASSIGNMENT");
            System.out.println("3 -> MEETING");
            System.out.println("4 -> OTHER");
            int dateType = input.nextInt();
            DateType type = null;
            switch (dateType) {
                case 1:
                    type = DateType.EXAM;
                    break;
                case 2:
                    type = DateType.ASSIGNMENT;
                    break;
                case 3:
                    type = DateType.MEETING;
                    break;
                case 4:
                    type = DateType.OTHER;
            }
            course.addDate(new Date(year, month, day, type));
            System.out.println("Date was added!");
        } else if (command.equals("B")) {
            System.out.println("Enter the year: ");
            int year = input.nextInt();
            System.out.println("Enter the month: ");
            int month = input.nextInt();
            System.out.println("Enter the day: ");
            int day = input.nextInt();
            System.out.println("Select the date type:");
            System.out.println("1 -> EXAM");
            System.out.println("2 -> ASSIGNMENT");
            System.out.println("3 -> MEETING");
            System.out.println("4 -> OTHER");
            int dateType = input.nextInt();
            DateType type = null;
            switch (dateType) {
                case 1:
                    type = DateType.EXAM;
                    break;
                case 2:
                    type = DateType.ASSIGNMENT;
                    break;
                case 3:
                    type = DateType.MEETING;
                    break;
                case 4:
                    type = DateType.OTHER;
            }
            for (Date d : course.getDates()) {
                if (d.getDate()[0] == year && d.getDate()[1] == month
                        && d.getDate()[2] == day && d.getDateType() == type) {
                    course.getDates().remove(d);
                    System.out.println("Date was removed!");
                    break;
                }
            }
        } else if (command.equals("C")) {
            System.out.println("Enter the name of the topic: ");
            String topicName = input.next();
            course.addTopic(topicName);
            System.out.println("Topic was added!");
        } else if (command.equals("D")) {
            System.out.println("Enter the name of the topic: ");
            String topicName = input.next();
            for (Topic t : course.getTopics()) {
                if (t.getTopicName().equals(topicName)) {
                    course.getTopics().remove(t);
                    System.out.println("Topic was removed!");
                    break;
                }
            }
        } else if (command.equals("E")) {
            System.out.println("Enter the name of the topic: ");
            String topicName = input.next();
            for (Topic t : course.getTopics()) {
                if (t.getTopicName().equals(topicName)) {
                    t.completeQuestion();
                    System.out.println("One question marked as complete!");
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
