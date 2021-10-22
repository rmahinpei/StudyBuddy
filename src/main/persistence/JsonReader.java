package persistence;

import model.Date;
import model.DateType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// Represents a reader that reads agendas (clubs or courses) from JSON data stored in file
// Modelled using UBC CPSC 210's JSONSerializationDemo
public abstract class JsonReader {
    // EFFECTS: reads source file as string and returns it
    protected String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: adds parsed dates to a list and returns list
    protected List<Date> parseDates(JSONArray jsonArray) {
        List<Date> dates = new ArrayList<>();
        for (int count = 0; count < jsonArray.length(); count++) {
            Date d = parseDate(jsonArray.getJSONObject(count));
            dates.add(d);
        }
        return dates;
    }

    // EFFECTS: parses dates and return it
    protected Date parseDate(JSONObject json) {
        int year = json.getInt("year");
        int month = json.getInt("month");
        int day = json.getInt("day");
        DateType type = DateType.valueOf(json.getString("type"));
        return new Date(year, month, day, type);
    }
}
