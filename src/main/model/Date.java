package model;

public class Date {
    private int[] date;
    private DateType dateType;
    private String dateDescription;

    // REQUIRES: year is a valid year >= 2021,
    //           month is between 0-12 inclusive,
    //           day is between 0-31
    // MODIFIES: this
    // EFFECTS: creates a date for the given year, month, day with the specified date type
    //          with an empty string as the default description
    public Date(int year, int month, int day, DateType dateType) {
        date = new int[3];
        date[0] = year;
        date[1] = month;
        date[2] = day;
        this.dateType = dateType;
        dateDescription = "";
    }

    // setter
    public void setDateDescription(String dateDescription) {
        this.dateDescription = dateDescription;
    }

    // getter
    public int[] getDate() {
        return date;
    }

    // getter
    public DateType getDateType() {
        return dateType;
    }

    // getter
    public String getDateDescription() {
        return dateDescription;
    }

    // EFFECTS: returns date as a string with the format "year/month/day"
    public String dateToString() {
        return "" + date[0] + "/" + date[1] + "/" + date[2];
    }
}
