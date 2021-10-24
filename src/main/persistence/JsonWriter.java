package persistence;

import model.Agenda;
import model.Date;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes JSON representations of agendas (clubs or courses) to file
// Modelled using UBC CPSC 210's JSONSerializationDemo
public abstract class JsonWriter {
    protected PrintWriter writer;
    protected String destination;
    protected static final int TAB = 4;

    public JsonWriter(String destination) {
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
