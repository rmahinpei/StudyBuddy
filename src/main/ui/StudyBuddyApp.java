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
        displayMainMenu();
    }

    // EFFECTS: prints main menu and prompts user to select an option
    private void displayMainMenu() {
        boolean keepRunning = true;
        String command;
        initialize();
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

    // MODIFIES: this
    // EFFECTS: initializes lists for user's clubs and courses
    private void initialize() {
        courses = new ArrayList<>();
        clubs = new ArrayList<>();
        input = new Scanner(System.in);
    }

    // EFFECTS: processes option chosen by user in main menu
    private void processMainMenuCommand(String command) {
        if (command.equals("A")) {
            displayCoursesMenu();
        } else if (command.equals("B")) {
            displayClubsMenu();
        } else {
            System.out.println("This option is invalid. Try again.");
        }
    }

    // EFFECTS: prints courses menu and prompts user to select an option
    private void displayCoursesMenu() {
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
                processCoursesMenuCommand(command);
            }
        }
    }

    // EFFECTS: processes option chosen by user in courses menu
    private void processCoursesMenuCommand(String command) {
        switch (command) {
            case "A":
                viewCourse();
                break;
            case "B":
                addCourse();
                break;
            case "C":
                removeCourse();
                break;
            default:
                System.out.println("This option is invalid. Try again.");
                break;
        }
    }

    // EFFECTS: displays a course if it exists in user's courses
    private void viewCourse() {
        if (courses.isEmpty()) {
            System.out.println("You currently don't have any courses to view.");
        } else {
            System.out.println("Enter the name of the course you want to view: ");
            String courseName = input.next();
            for (Course c : courses) {
                if (c.getName().equals(courseName)) {
                    displayCourseMenu(c);
                    break;
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new course to user's courses
    private void addCourse() {
        System.out.println("Enter the name of the course you want to add: ");
        String courseName = input.next();
        courses.add(new Course(courseName));
        System.out.println("Course was added!");
    }

    // MODIFIES: this
    // EFFECTS: removes a course from user's courses
    private void removeCourse() {
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

    // EFFECTS: prints course menu and prompts user to select an option
    private void displayCourseMenu(Course course) {
        String command;
        boolean keepRunning = true;

        while (keepRunning) {
            displayCourseDetails(course);
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
                processCourseMenuCommand(command, course);
            }
        }
    }

    // EFFECTS: prints dates and topics in course if dates and topics are not empty
    private void displayCourseDetails(Course course) {
        if (!(course.getDates().isEmpty())) {
            System.out.println("\nHere are the dates in " + course.getName() + ":");
            for (Date d : course.getDates()) {
                System.out.println(d.dateToString());
            }
        }
        if (!(course.getTopics().isEmpty())) {
            System.out.println("\nHere are the topics in " + course.getName() + ":");
            for (Topic t : course.getTopics()) {
                System.out.println(t.getTopicName() + ": completed Qs = " + t.getNumCompleted()
                        + ", remaining Qs = " + t.getNumRemaining());
            }
        }
    }

    // EFFECTS: processes option chosen by user in course menu
    private void processCourseMenuCommand(String command, Course course) {
        switch (command) {
            case "A":
                addDate(course);
                break;
            case "B":
                removeDate(course);
                break;
            case "C":
                addTopic(course);
                break;
            case "D":
                removeTopic(course);
                break;
            case "E":
                completeTopicQuestion(course);
                break;
            default:
                System.out.println("This option is invalid. Try again.");
                break;
        }
    }

    // MODIFIES: course
    // EFFECTS: adds a date to course
    private void addDate(Course course) {
        Date returnedDate = generateDate();
        course.addDate(returnedDate);
        System.out.println("Date was added!");
    }

    // MODIFIES: course
    // EFFECTS: removes a date from course
    private void removeDate(Course course) {
        Date returnedDate = generateDate();
        for (Date d : course.getDates()) {
            if (d.getDate()[0] == returnedDate.getDate()[0]
                    && d.getDate()[1] == returnedDate.getDate()[1]
                    && d.getDate()[2] == returnedDate.getDate()[2]
                    && d.getDateType() == returnedDate.getDateType()) {
                course.getDates().remove(d);
                System.out.println("Date was removed!");
                break;
            }
        }
    }

    // EFFECTS: creates a date corresponding to user's inputs
    private Date generateDate() {
        System.out.println("Enter the year: ");
        int year = input.nextInt();
        System.out.println("Enter the month: ");
        int month = input.nextInt();
        System.out.println("Enter the day: ");
        int day = input.nextInt();
        System.out.println("Select the date type\n 1 -> EXAM\n 2 -> ASSIGNMENT\n 3 -> MEETING\n 4 -> OTHER");
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
        return new Date(year, month, day, type);
    }

    // MODIFIES: course
    // EFFECTS: adds a topic to course
    private void addTopic(Course course) {
        System.out.println("Enter the name of the topic you want to add: ");
        String topicName = input.next();
        course.addTopic(topicName);
        System.out.println("Topic was added!");
    }

    // MODIFIES: course
    // EFFECTS: removes a topic from course
    private void removeTopic(Course course) {
        System.out.println("Enter the name of the topic you want to remove: ");
        String topicName = input.next();
        for (Topic t : course.getTopics()) {
            if (t.getTopicName().equals(topicName)) {
                course.getTopics().remove(t);
                System.out.println("Topic was removed!");
                break;
            }
        }
    }

    // MODIFIES: topic
    // EFFECTS: completes a question from the topic selected by user
    private void completeTopicQuestion(Course course) {
        System.out.println("Enter the name of the topic for which you will complete a question: ");
        String topicName = input.next();
        for (Topic topic : course.getTopics()) {
            if (topic.getTopicName().equals(topicName)) {
                topic.completeQuestion();
                System.out.println("One question marked as complete!");
                break;
            }
        }
    }

    // EFFECTS: prints clubs menu and prompts user to select an option
    private void displayClubsMenu() {
        String command;
        boolean keepRunning = true;
        while (keepRunning) {
            if (!(clubs.isEmpty())) {
                System.out.println("\nHere are your clubs: ");
                for (Club c : clubs) {
                    System.out.println(c.getName());
                }
            }
            System.out.println("\nSelect from the following options:");
            System.out.println("A -> to view an existing club");
            System.out.println("B -> to add a club");
            System.out.println("C -> to remove a club");
            System.out.println("D -> to go back");
            command = input.next();
            command = command.toUpperCase();
            if (command.equals("D")) {
                keepRunning = false;
            } else {
                processClubsMenuCommand(command);
            }
        }
    }

    // EFFECTS: processes option chosen by user in clubs menu
    private void processClubsMenuCommand(String command) {
        switch (command) {
            case "A":
                viewClub();
                break;
            case "B":
                addClub();
                break;
            case "C":
                removeClub();
                break;
            default:
                System.out.println("This option is invalid. Try again.");
                break;
        }
    }

    // EFFECTS: displays a club if it exists in user's clubs
    private void viewClub() {
        if (clubs.isEmpty()) {
            System.out.println("You currently don't have any clubs to view.");
        } else {
            System.out.println("Enter the name of the course you want to view: ");
            String clubName = input.next();
            for (Club c : clubs) {
                if (c.getName().equals(clubName)) {
                    displayClubMenu(c);
                    break;
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a club to clubs
    private void addClub() {
        System.out.println("Enter the name of the club you want to add: ");
        String clubName = input.next();
        clubs.add(new Club(clubName));
        System.out.println("Club was added!");
    }

    // MODIFIES: this
    // EFFECTS: removes a club from clubs
    private void removeClub() {
        System.out.println("Enter the name of the club you want to remove: ");
        String clubName = input.next();
        for (Club c : clubs) {
            if (c.getName().equals(clubName)) {
                clubs.remove(c);
                System.out.println("Club was removed!");
                break;
            }
        }
    }

    // EFFECTS: prints club menu and prompts user to select an option
    private void displayClubMenu(Club c) {
        // stub
    }

}
