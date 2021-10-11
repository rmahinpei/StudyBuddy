package ui;

import model.Course;
import model.Date;
import model.Topic;

// Manages a course stored in StudyBuddy application
public class CourseManager extends AgendaManager {
    private Course course;

    public CourseManager() {
        super();
    }

    // EFFECTS: prints course menu and prompts user to select an option
    public void displayCourseMenu(Course course) {
        this.course = course;
        String command;
        boolean keepRunning = true;

        while (keepRunning) {
            displayDetails();
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
                processMenuCommand(command);
            }
        }
    }

    @Override
    // EFFECTS: prints dates and topics in course if dates and topics are not empty
    protected void displayDetails() {
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

    @Override
    // EFFECTS: processes option chosen by user in course menu
    protected void processMenuCommand(String command) {
        switch (command) {
            case "A":
                addDate(course);
                break;
            case "B":
                removeDate(course);
                break;
            case "C":
                addTopic();
                break;
            case "D":
                removeTopic();
                break;
            case "E":
                completeTopicQuestion();
                break;
            default:
                System.out.println("This option is invalid. Try again.");
                break;
        }
    }

    // MODIFIES: course
    // EFFECTS: adds a topic to course
    private void addTopic() {
        System.out.println("Enter the name of the topic you want to add: ");
        String topicName = input.next();
        course.addTopic(topicName);
        System.out.println("Topic was added!");
    }

    // MODIFIES: course
    // EFFECTS: removes a topic from course
    private void removeTopic() {
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
    private void completeTopicQuestion() {
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
}
