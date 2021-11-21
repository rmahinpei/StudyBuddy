package model;

import java.util.ArrayList;
import java.util.List;

// Represents a course agenda that stores topics and dates
public class Course extends Agenda {
    private List<Topic> topics;

    // EFFECTS: creates a course with given name that has 0 dates, 0 reminders, and 0 topics
    public Course(String name) {
        super(name);
        topics = new ArrayList<>();
    }

    // GETTER
    public List<Topic> getTopics() {
        return topics;
    }

    // MODIFIES: this
    // EFFECTS: adds topic to the end of topics
    public void addTopic(Topic t) {
        topics.add(t);
        EventLog.getInstance().logEvent(new Event("Added Topic: " + t.getTopicName()));
    }

    // MODIFIES: this
    // EFFECTS: adds all topics in given list to topics
    public void addTopics(List<Topic> topics) {
        this.topics.addAll(topics);
    }

    // MODIFIES: this
    // EFFECTS: removes the topic with given name from topics
    public void removeTopic(String topicName) {
        for (Topic t : topics) {
            if (t.getTopicName().equals(topicName)) {
                topics.remove(t);
                EventLog.getInstance().logEvent(new Event("Removed Topic: " + t.getTopicName()));
                break;
            }
        }
    }
}
