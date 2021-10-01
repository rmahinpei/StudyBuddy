package model;

import java.util.List;

public class Course implements Calendar {
    String name;
    List<Date> dates;
    List<String> reminders;
    List<Topic> topics;

    @Override
    public void addDate(Date date) {

    }

    @Override
    public void removeDate(Date date) {

    }

    @Override
    public List<int[]> getDates() {
        return null;
    }

    @Override
    public void addReminder(String reminder) {

    }

    @Override
    public void removeReminder(int index) {

    }

    @Override
    public List<String> getReminders() {
        return null;
    }
}
