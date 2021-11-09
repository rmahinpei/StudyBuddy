package ui;

import model.Course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Represents StudyBuddy's main window
public class StudyBuddyGUI extends JFrame implements ActionListener {
    public static final int WINDOW_WIDTH = 420;
    public static final int WINDOW_HEIGHT = 600;
    public static final int ELEMENT_HEIGHT = 30;
    public static final int VERTICAL_GAP = 30;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel centrePanel;
    private JTextField userText;
    private JButton addButton;
    private JButton removeButton;
    private JButton viewButton;
    private JButton loadCourses;
    private JButton saveChanges;
    private ArrayList<Course> courses;
    private ArrayList<JLabel> courseLabels;

    // EFFECTS: sets up main frame and its top, bottom, and centre panels along with
    //          an ArrayList for courses and course labels
    public StudyBuddyGUI() {
        courses = new ArrayList<>();
        courseLabels = new ArrayList<>();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        centrePanel = new JPanel();

        setTitle("StudyBuddy");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setTopPanel();
        setBottomPanel();
        setCentrePanel();

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets up TopPanel of main frame
    private void setTopPanel() {
        topPanel.setLayout(null);
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, 110));

        setTopPanelTexts();
        setTopPanelButtons();

        add(topPanel, BorderLayout.NORTH);
    }

    // MODIFIES: this
    // EFFECTS: adds text and interactive elements to TopPanel
    private void setTopPanelTexts() {
        JLabel welcomeText = new JLabel("Let's take your time management to the next level!");
        welcomeText.setBounds(10, 10, WINDOW_WIDTH - 10, ELEMENT_HEIGHT);
        welcomeText.setFont(new Font("Default", Font.BOLD, 14));
        welcomeText.setHorizontalAlignment(JLabel.CENTER);

        JLabel courseNameText = new JLabel("Name of course: ");
        courseNameText.setBounds(10, 10 + VERTICAL_GAP, 120, ELEMENT_HEIGHT);

        userText = new JTextField();
        userText.setBounds(120, 10 + VERTICAL_GAP, 290, ELEMENT_HEIGHT);

        topPanel.add(welcomeText);
        topPanel.add(courseNameText);
        topPanel.add(userText);
    }

    // MODIFIES: this
    // EFFECTS: adds buttons to TopPanel
    private void setTopPanelButtons() {
        addButton = new JButton("Add");
        addButton.setBounds(10, 10 + 2 * VERTICAL_GAP, 120, ELEMENT_HEIGHT);
        addButton.addActionListener(this);

        removeButton = new JButton("Remove");
        removeButton.setBounds(150, 10 + 2 * VERTICAL_GAP, 120, ELEMENT_HEIGHT);
        removeButton.addActionListener(this);

        viewButton = new JButton("View");
        viewButton.setBounds(290, 10 + 2 * VERTICAL_GAP, 120, ELEMENT_HEIGHT);
        viewButton.addActionListener(this);

        topPanel.add(addButton);
        topPanel.add(removeButton);
        topPanel.add(viewButton);
    }

    // MODIFIES: this
    // EFFECTS: sets up BottomPanel of main frame
    private void setBottomPanel() {
        bottomPanel.setLayout(null);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, 50));

        setBottomPanelButtons();

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // MODIFIES: this
    // EFFECTS: adds button to BottomPanel
    private void setBottomPanelButtons() {
        loadCourses = new JButton("Load Courses");
        saveChanges = new JButton("Save Changes");
        loadCourses.setBounds(50, 10, 150, ELEMENT_HEIGHT);
        saveChanges.setBounds(220, 10, 150, ELEMENT_HEIGHT);

        bottomPanel.add(loadCourses);
        bottomPanel.add(saveChanges);
    }

    // MODIFIES: this
    // EFFECTS: sets up CentrePanel of main frame
    private void setCentrePanel() {
        centrePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        centrePanel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT - 160));

        add(centrePanel, BorderLayout.CENTER);
    }

    @Override
    // MODIFIES: this
    // EFFECTS: handles the event raised by the user
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            handleAddButtonAction();
        } else if (e.getSource() == removeButton) {
            handleRemoveButtonAction();
        } else if (e.getSource() == viewButton) {
            handleViewButtonAction();
        }
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates a new Course and JLabel corresponding to user's input
    //          and adds them to courses and courseLabels while also displaying the label on centrePanel
    private void handleAddButtonAction() {
        courses.add(new Course(userText.getText()));
        JLabel newCourseLabel = new JLabel(userText.getText());
        courseLabels.add(newCourseLabel);
        centrePanel.add(newCourseLabel);
    }

    // MODIFIES: this
    // EFFECTS: removes the Course and JLabel corresponding to user's input from courses and courseLabels
    //          while also removing the label from centrePanel
    private void handleRemoveButtonAction() {
        courses.removeIf(course -> course.getName().equals(userText.getText()));
        for (JLabel label : courseLabels) {
            if (label.getText().equals(userText.getText())) {
                courseLabels.remove(label);
                centrePanel.remove(label);
                centrePanel.revalidate();
                centrePanel.repaint();
                break;
            }
        }
    }

    // EFFECTS: opens a new window corresponding to the Course inputted by user
    private void handleViewButtonAction() {
        JFrame courseWindow = new JFrame();
        courseWindow.setTitle(userText.getText());
        courseWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        courseWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        courseWindow.setResizable(false);
        courseWindow.setVisible(true);
    }

    // EFFECTS: starts the application
    public static void main(String[] args) {
        new StudyBuddyGUI();

    }
}
