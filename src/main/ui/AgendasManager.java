package ui;

public interface AgendasManager {
    void displayMenu();

    void processMenuCommand(String command);

    void viewAgendaFromAgendas();

    void addAgendaToAgendas();

    void removeAgendaFromAgendas();

    void saveAgendas();
}
