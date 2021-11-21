package ui;

import model.Course;
import model.Topic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Represents a window displaying info associated with a particular course
// Note that the image used in this GUI was obtained from flaticon.com
public class CourseGUI extends JFrame implements ActionListener {
    private Course course;
    private static final int WINDOW_WIDTH = 420;
    private static final int WINDOW_HEIGHT = 600;
    private static final int ELEMENT_HEIGHT = 30;
    private static final int VERTICAL_GAP = 30;
    private JPanel topPanel;
    private JPanel centrePanel;
    private JPanel bottomPanel;
    private JTextField userText;
    private JButton addButton;
    private JButton removeButton;
    private JButton completeButton;
    private List<JLabel> topicLabels;
    private JLabel yayLabel;
    private ImageIcon yayImage;

    // EFFECTS: sets up main frame and its top, bottom, and centre panels along with
    //          an ArrayList for topic labels
    public CourseGUI(Course course) {
        this.course = course;
        topPanel = new JPanel();
        centrePanel = new JPanel();
        bottomPanel = new JPanel();
        topicLabels = new ArrayList<>();

        setTitle(course.getName());
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        setTopPanel();
        setCentrePanel();
        setBottomPanel();

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: sets up TopPanel of frame
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
        JLabel topicNameText = new JLabel("Name of topic: ");
        topicNameText.setBounds(10, 10, 120, ELEMENT_HEIGHT);

        userText = new JTextField();
        userText.setBounds(110, 10, 300, ELEMENT_HEIGHT);

        topPanel.add(topicNameText);
        topPanel.add(userText);
    }

    // MODIFIES: this
    // EFFECTS: adds add, remove and complete buttons to TopPanel
    private void setTopPanelButtons() {
        addButton = new JButton("Add");
        addButton.setBounds(85, 10 + VERTICAL_GAP, 120, ELEMENT_HEIGHT);
        addButton.addActionListener(this);

        removeButton = new JButton("Remove");
        removeButton.setBounds(225, 10 + VERTICAL_GAP, 120, ELEMENT_HEIGHT);
        removeButton.addActionListener(this);

        completeButton = new JButton("Complete a question for this topic!");
        completeButton.setBounds(90, 10 + 2 * VERTICAL_GAP, 250, ELEMENT_HEIGHT);
        completeButton.addActionListener(this);

        topPanel.add(addButton);
        topPanel.add(removeButton);
        topPanel.add(completeButton);
    }

    // MODIFIES: this
    // EFFECTS: sets up CentrePanel of frame
    private void setCentrePanel() {
        centrePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        centrePanel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT - 160 - 110));
        for (Topic t : course.getTopics()) {
            JLabel newTopicLabel = new JLabel(getTopicInfo(t));
            newTopicLabel.setName(t.getTopicName());
            topicLabels.add(newTopicLabel);
            centrePanel.add(newTopicLabel);
        }
        add(centrePanel, BorderLayout.CENTER);
    }

    // EFFECTS: returns a string containing topic name, number of completed questions, and remaining questions
    //          in the format "TOPIC NAME: completed Qs = #, remaining Qs = #"
    private String getTopicInfo(Topic t) {
        return t.getTopicName() + ": completed Qs = " + t.getNumCompleted() + ", remaining Qs = "
                + t.getNumRemaining();
    }

    // MODIFIES: this
    // EFFECTS: sets up BottomPanel of frame
    private void setBottomPanel() {
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, 160));

        yayLabel = new JLabel("GOOD JOB!");
        yayLabel.setFont(new Font("Default", Font.BOLD, 14));
        yayImage = new ImageIcon("./data/yay.png");

        yayLabel.setIcon(yayImage);
        yayLabel.setHorizontalAlignment(JLabel.CENTER);
        yayLabel.setHorizontalTextPosition(JLabel.CENTER);
        yayLabel.setVerticalTextPosition(JLabel.TOP);
        yayLabel.setVisible(false);

        bottomPanel.add(yayLabel);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    // MODIFIES: this
    // EFFECTS: handles the event raised by the user
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            handleAddButtonAction();
        } else if (e.getSource() == removeButton) {
            handleRemoveButtonAction();
        } else if (e.getSource() == completeButton) {
            handleCompleteButtonAction();
        }
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates a new Topic and JLabel corresponding to user's input
    //          and adds them to topics and topicLabels while also displaying the label on centrePanel
    private void handleAddButtonAction() {
        yayLabel.setVisible(false);
        Topic newTopic = new Topic(userText.getText());
        course.addTopic(newTopic);

        JLabel newTopicLabel = new JLabel(getTopicInfo(newTopic));
        newTopicLabel.setName(newTopic.getTopicName());
        topicLabels.add(newTopicLabel);

        centrePanel.add(newTopicLabel);
    }

    // MODIFIES: this
    // EFFECTS: removes the topic and JLabel corresponding to user's input from topics and topicLabels
    //          while also removing the label from centrePanel
    private void handleRemoveButtonAction() {
        yayLabel.setVisible(false);
        boolean removable = false;
        for (Topic t : course.getTopics()) {
            if (t.getTopicName().equals(userText.getText())) {
                removable = true;
                break;
            }
        }
        if (removable) {
            course.removeTopic(userText.getText());
        }
        for (JLabel label : topicLabels) {
            if (label.getName().equals(userText.getText())) {
                topicLabels.remove(label);
                centrePanel.remove(label);
                centrePanel.revalidate();
                centrePanel.repaint();
                break;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: completes a question for the topic corresponding to user's input and updates
    //          the JLabel corresponding to the topic to show that a question was completed
    //          while also displaying a "celebration" image to congratulate the user
    private void handleCompleteButtonAction() {
        Topic userTopic = null;
        for (Topic t : course.getTopics()) {
            if (t.getTopicName().equals(userText.getText())) {
                t.completeQuestion();
                userTopic = t;
                break;
            }
        }
        for (JLabel label : topicLabels) {
            if (label.getName().equals(userText.getText())) {
                label.setText(getTopicInfo(userTopic));
                break;
            }
        }
        yayLabel.setVisible(true);
    }

}
