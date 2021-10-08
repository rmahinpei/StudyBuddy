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

    // getter
    public List<Topic> getTopics() {
        return topics;
    }

    // MODIFIES: this
    // EFFECTS: creates a topic with given name and adds it to the end of topics
    public void addTopic(String topicName) {
        Topic t = new Topic(topicName);
        topics.add(t);
    }

    // MODIFIES: this
    // EFFECTS: removes the topic with given name from topics
    public void removeTopic(String topicName) {
        for (Topic t : topics) {
            if (t.getTopicName().equals(topicName)) {
                topics.remove(t);
                break;
            }
        }
    }

    // EFFECTS: prints out the topic name, number of completed Q's, number of remaining Q's for all topics
    public void printTopics() {
        for (Topic t : topics) {
            System.out.println(t.getTopicName() + ": completed Qs = " + t.getNumCompleted()
                    + ", remaining Qs = " + t.getNumRemaining());
        }
    }
}
