package model;

import java.util.ArrayList;
import java.util.List;

// Represents a club agenda that stores reminders and dates
public class Club extends Agenda {
    private List<String> reminders;

    // EFFECTS: creates a club with given name that has 0 dates and 0 reminders
    public Club(String name) {
        super(name);
        reminders = new ArrayList<>();
    }

    // GETTER
    public List<String> getReminders() {
        return reminders;
    }

    // MODIFIES: this
    // EFFECTS: adds reminder to reminders
    public void addReminder(String reminder) {
        reminders.add(reminder);
    }

    // REQUIRES: 1 <= position <= reminders.size()
    // MODIFIES: this
    // EFFECTS: remove reminder at the specified position in reminders
    public void removeReminder(int position) {
        reminders.remove(position - 1);
    }

}
