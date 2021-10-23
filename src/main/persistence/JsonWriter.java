package persistence;

import model.Agenda;
import model.Date;
import org.json.JSONArray;
import org.json.JSONObject;

// Represents a writer that writes JSON representations of agendas (clubs or courses) to file
// Modelled using UBC CPSC 210's JSONSerializationDemo
public abstract class JsonWriter {
    // EFFECTS: creates a JSONArray of JSONObjects that represent dates
    protected JSONArray datesToJson(Agenda c) {
        JSONArray jsonArray = new JSONArray();
        for (Date d : c.getDates()) {
            JSONObject dateObject = dateToJson(d);
            jsonArray.put(dateObject);
        }
        return jsonArray;
    }

    // EFFECTS: creates a JSONObject that represents a date
    protected JSONObject dateToJson(Date d) {
        JSONObject json = new JSONObject();
        json.put("year", d.getDate()[0]);
        json.put("month", d.getDate()[1]);
        json.put("day", d.getDate()[2]);
        json.put("type", d.getDateType());
        return json;
    }
}
