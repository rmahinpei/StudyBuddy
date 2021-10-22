package persistence;

import model.Course;
import model.Topic;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

// Represents a writer that writes JSON representations of courses to file
// Modelled using UBC CPSC 210's JSONSerializationDemo
public class CoursesJsonWriter extends JsonWriter {
    private PrintWriter writer;
    private String destination;
    private static final int TAB = 4;

    // EFFECTS: constructs a writer to write to destination file
    public CoursesJsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    protected void saveToFile(String json) {
        writer.print(json);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of a list of courses to file
    public void writeCourses(List<Course> courses) {
        JSONObject json = new JSONObject();
        json.put("courses", coursesToJson(courses));
        saveToFile(json.toString(TAB));
    }

    // EFFECTS: creates a JSONArray of JSONObjects that represent courses
    private JSONArray coursesToJson(List<Course> courses) {
        JSONArray jsonArray = new JSONArray();
        for (Course c : courses) {
            jsonArray.put(courseToJson(c));
        }
        return jsonArray;
    }

    // EFFECTS: creates a JSONObject representing a course
    private JSONObject courseToJson(Course c) {
        JSONObject json = new JSONObject();
        json.put("name", c.getName());
        json.put("dates", datesToJson(c));
        json.put("topics", topicsToJson(c));
        return json;
    }

    // EFFECTS: creates a JSONArray of topics of a course
    private JSONArray topicsToJson(Course c) {
        JSONArray jsonArray = new JSONArray();
        for (Topic t : c.getTopics()) {
            JSONObject json = topicToJson(t);
            jsonArray.put(json);
        }
        return jsonArray;
    }

    // EFFECTS: creates a JSONObject that represents a topic
    private JSONObject topicToJson(Topic t) {
        JSONObject json = new JSONObject();
        json.put("name", t.getTopicName());
        json.put("numCompleted", t.getNumCompleted());
        return json;
    }

}
