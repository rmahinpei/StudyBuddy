package model;

public class Topic {
    private static final int NUM_QUESTIONS_TO_COMPLETE = 3;
    private String name;
    private int numCompleted;
    private int numRemaining;

    // EFFECTS: creates a topic with given name and sets number of completed practice questions to 0
    //          and number of remaining practice questions to the recommended constant by default
    public Topic(String name) {
        this.name = name;
        numCompleted = 0;
        numRemaining = NUM_QUESTIONS_TO_COMPLETE;
    }

    // getter
    public String getTopicName() {
        return name;
    }

    // getter
    public int getNumCompleted() {
        return numCompleted;
    }

    // getter
    public int getNumRemaining() {
        return numRemaining;
    }

    // MODIFIES: this
    // EFFECTS: increases number of completed questions by 1
    //          if number of remaining questions is greater than 0, it decreases it by 1
    //          if it is 0, it keeps it at 0
    public void completeQuestion() {
        // stub
    }
}