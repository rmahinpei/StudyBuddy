package model;

import java.util.ArrayList;
import java.util.List;

// Represents an agenda that stores important dates
public abstract class Agenda {
    protected String name;
    protected List<Date> dates;

    public Agenda(String name) {
        this.name = name;
        dates = new ArrayList<>();
    }

    // GETTER
    public String getName() {
        return name;
    }

    // GETTER
    public List<Date> getDates() {
        return dates;
    }

    // MODIFIES: this
    // EFFECTS: adds given date to dates
    public void addDate(Date date) {
        dates.add(date);
    }

    // MODIFIES: this
    // EFFECTS: removes specified date from dates
    public void removeDate(Date date) {
        dates.remove(date);
    }

}
