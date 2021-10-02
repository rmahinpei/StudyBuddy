package model;

import java.util.ArrayList;
import java.util.List;

public class Course implements Agenda {
    private String name;
    private List<Date> dates;
    private List<String> reminders;
    private List<Topic> topics;

    // EFFECTS: creates a course with given name that has 0 dates, reminders,
    //          and topics by default
    public Course(String name) {
        this.name = name;
        dates = new ArrayList<>();
        reminders = new ArrayList<>();
        topics = new ArrayList<>();
    }

    // getter
    public String getCourseName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds given topic to the end of topics
    public void addTopic(Topic t) {
        topics.add(t);
    }

    // MODIFIES: this
    // EFFECTS: removes given topic from topics
    public void removeTopic(Topic t) {
        topics.remove(t);
    }

    // getter
    public List<Topic> getTopics() {
        return topics;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: adds given date to dates and maintains a sorted order
    //          (i.e.: earliest dates at start of list)
    public void addDate(Date date) {

    }

    @Override
    // MODIFIES: this
    // EFFECTS: removes date from dates
    public void removeDate(Date date) {

    }

    @Override
    // EFFECTS: returns a list of all dates
    public List<Date> getDates() {
        return null;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: adds given reminder to the end of reminders
    public void addReminder(String reminder) {

    }

    @Override
    // MODIFIES: this
    // EFFECTS: removes given reminder from reminders
    public void removeReminder(int index) {

    }

    @Override
    // EFFECTS: returns a list of all reminders in the order they were given
    public List<String> getReminders() {
        return null;
    }
}
