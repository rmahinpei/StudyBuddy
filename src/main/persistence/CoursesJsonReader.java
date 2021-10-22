package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Represents a reader that reads courses from JSON data stored in file
// Modelled using UBC CPSC 210's JSONSerializationDemo
public class CoursesJsonReader extends JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public CoursesJsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads courses from file and returns the list of courses;
    // throws IOException if an error occurs reading data from file
    public List<Course> readCourses() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCourses(jsonObject);
    }

    // EFFECTS: adds parsed courses to a list and returns list
    private List<Course> parseCourses(JSONObject jsonObject) {
        List<Course> courses = new ArrayList<>();
        JSONArray jsonCourses = jsonObject.getJSONArray("courses");
        for (Object jsonCourse : jsonCourses) {
            courses.add(parseCourse((JSONObject) jsonCourse));
        }
        return courses;
    }

    // EFFECTS: parses courses from JSONObject and returns them
    private Course parseCourse(JSONObject json) {
        String name = json.getString("name");
        List<Topic> topics = parseTopics(json.getJSONArray("topics"));
        List<Date> dates = parseDates(json.getJSONArray("dates"));
        Course course = new Course(name);
        for (Topic t : topics) {
            course.addTopic(t);
        }
        for (Date d : dates) {
            course.addDate(d);
        }
        return course;
    }

    // EFFECTS: parses club topics from JSONObject and returns them
    private List<Topic> parseTopics(JSONArray jsonArray) {
        List<Topic> topics = new ArrayList<>();
        for (int count = 0; count < jsonArray.length(); count++) {
            Topic t = parseTopic(jsonArray.getJSONObject(count));
            topics.add(t);
        }
        return topics;
    }

    // EFFECTS: parses topic and return it
    private Topic parseTopic(JSONObject json) {
        String name = json.getString("name");
        int numCompleted = json.getInt("numCompleted");
        return new Topic(name, numCompleted);
    }
}
