package model;

import java.util.ArrayList;
import java.util.List;

public class Course extends Agenda {
    private List<Topic> topics;

    // EFFECTS: creates a course with given name that has 0 dates, reminders,
    //          and topics by default
    public Course(String name) {
        super(name);
        topics = new ArrayList<>();
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

}
