package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Agenda {
    protected String name;
    protected List<Date> dates;
    //protected List<String> reminders;

    public Agenda(String name) {
        this.name = name;
        dates = new ArrayList<>();
        //reminders = new ArrayList<>();
    }

    // getter
    public String getName() {
        return name;
    }

    public void addDate(Date date) {
        dates.add(date);
    }

    public void removeDate(Date date) {
        dates.remove(date);
    }

    // getter
    public List<Date> getDates() {
        return dates;
    }

    //public void addReminder(String reminder) {
    //    reminders.add(reminder);
    //}

    // EFFECTS: remove reminder at position of index (zero-indexed)
    //public void removeReminder(int index) {
    //    reminders.remove(index);
    //}

    // getter
    //public List<String> getReminders() {
    //    return reminders;
    //}
}
