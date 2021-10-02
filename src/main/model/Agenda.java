package model;

import java.util.List;

public interface Agenda {
    void addDate(Date date);

    void removeDate(Date date);

    List<Date> getDates();

    void addReminder(String reminder);

    void removeReminder(int index);

    List<String> getReminders();

}
