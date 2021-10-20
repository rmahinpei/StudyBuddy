package persistence;

import model.Agenda;
import model.Date;
import org.json.JSONArray;
import org.json.JSONObject;

// Represents an object that can make JSON representations of objects containing dates (i.e. Agendas)
public abstract class Writable {

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
