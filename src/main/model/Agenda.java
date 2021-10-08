package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Agenda {
    protected String name;
    protected List<Date> dates;

    public Agenda(String name) {
        this.name = name;
        dates = new ArrayList<>();
    }

    // getter
    public String getName() {
        return name;
    }

    // getter
    public List<Date> getDates() {
        return dates;
    }

    public void addDate(Date date) {
        dates.add(date);
    }

    public void removeDate(Date date) {
        dates.remove(date);
    }

    // NOT TESTED!!!
    public void printDates() {
        for (Date d : dates) {
            System.out.println(d.dateToString());
        }
    }


}
