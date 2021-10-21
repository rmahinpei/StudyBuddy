package persistence;

import model.Club;
import model.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Represents a reader that reads clubs from JSON data stored in file
// Modelled using UBC CPSC 210's JSONSerializationDemo
public class ClubsJsonReader extends JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public ClubsJsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads clubs from file and returns the list of clubs;
    // throws IOException if an error occurs reading data from file
    public List<Club> readClubs() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseClubs(jsonObject);
    }

    // EFFECTS: adds parsed clubs to a list and returns list
    private List<Club> parseClubs(JSONObject jsonObject) {
        List<Club> clubs = new ArrayList<>();
        JSONArray jsonClubs = jsonObject.getJSONArray("clubs");
        for (Object jsonClub : jsonClubs) {
            clubs.add(parseClub((JSONObject) jsonClub));
        }

        return clubs;
    }

    // EFFECTS: parses clubs from JSONObject and returns them
    private Club parseClub(JSONObject json) {
        String name = json.getString("name");
        List<String> reminders = parseReminders(json.getJSONArray("reminders"));
        List<Date> dates = parseDates(json.getJSONArray("dates"));
        Club club = new Club(name);
        for (String r : reminders) {
            club.addReminder(r);
        }
        for (Date d : dates) {
            club.addDate(d);
        }
        return club;
    }

    // EFFECTS: parses club reminders from JSONObject and returns them
    private List<String> parseReminders(JSONArray jsonArray) {
        List<String> reminders = new ArrayList<>();
        for (int count = 0; count < jsonArray.length(); count++) {
            reminders.add(jsonArray.getString(count));
        }
        return reminders;
    }

}
