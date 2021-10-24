package persistence;

import model.Club;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

// Represents a writer that writes JSON representations of clubs to file
// Modelled using UBC CPSC 210's JSONSerializationDemo
public class ClubsJsonWriter extends JsonWriter {
    // EFFECTS: constructs a writer to write to destination file
    public ClubsJsonWriter(String destination) {
        super(destination);
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of a list of clubs to file
    public void writeClubs(List<Club> clubs) {
        JSONObject json = new JSONObject();
        json.put("clubs", clubsToJson(clubs));
        saveToFile(json.toString(TAB));
    }

    // EFFECTS: creates a JSONArray of JSONObjects that represent clubs
    private JSONArray clubsToJson(List<Club> clubs) {
        JSONArray jsonArray = new JSONArray();
        for (Club c : clubs) {
            jsonArray.put(clubToJson(c));
        }
        return jsonArray;
    }

    // EFFECTS: creates a JSONObject representing a club
    private JSONObject clubToJson(Club c) {
        JSONObject json = new JSONObject();
        json.put("name", c.getName());
        json.put("dates", datesToJson(c));
        json.put("reminders", remindersToJson(c));
        return json;
    }

    // EFFECTS: creates a JSONArray of strings that represent reminders of a club
    private JSONArray remindersToJson(Club c) {
        JSONArray jsonArray = new JSONArray();
        for (String r : c.getReminders()) {
            jsonArray.put(r);
        }
        return jsonArray;
    }

}
