package model;

// Represents a course topic that tracks number of practice questions completed and
// number of practice questions remaining
public class Topic {
    private static final int MIN_QUESTIONS_TO_COMPLETE = 3;
    private String name;
    private int numCompleted;
    private int numRemaining;

    // EFFECTS: creates a topic with given name and sets number of completed practice questions to 0
    //          and number of remaining practice questions to MIN_QUESTIONS_TO_COMPLETE
    public Topic(String name) {
        this.name = name;
        numCompleted = 0;
        numRemaining = MIN_QUESTIONS_TO_COMPLETE;
    }

    // EFFECTS: creates a topic with given name and the given number of completed practice questions
    //          if numCompleted >= MIN_QUESTIONS_TO_COMPLETE, numRemaining is set to 0
    //          else, numRemaining is set to MIN_QUESTIONS_TO_COMPLETE - numCompleted
    public Topic(String name, int numCompleted) {
        this.name = name;
        this.numCompleted = numCompleted;
        if (numCompleted >= MIN_QUESTIONS_TO_COMPLETE) {
            numRemaining = 0;
        } else {
            numRemaining = MIN_QUESTIONS_TO_COMPLETE - numCompleted;
        }
    }

    // GETTER
    public String getTopicName() {
        return name;
    }

    // GETTER
    public int getNumCompleted() {
        return numCompleted;
    }

    // GETTER
    public int getNumRemaining() {
        return numRemaining;
    }

    // MODIFIES: this
    // EFFECTS: increases number of completed questions by 1
    //          if number of remaining questions is greater than 0, it decreases it by 1
    //          if it is 0, it keeps it at 0
    public void completeQuestion() {
        numCompleted++;
        if (numRemaining > 0) {
            numRemaining--;
        }
    }
}