Develop a Java applet for a simple quiz game. The applet should display
a question along with multiple-choice answers. The user should be able
to select an answer by clicking on a button corresponding to each option.
After selecting an answer, the user should click a "Submit" button to
check if their answer is correct. If the answer is correct, display a
message indicating success; otherwise, display a message indicating
failure.


import javax.swing.*;
import java.awt.event.*;

public class QuizGameSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz Game");
        JLabel questionLabel = new JLabel("What is the capital of France?");
        JRadioButton option1 = new JRadioButton("Berlin");
        JRadioButton option2 = new JRadioButton("Madrid");
        JRadioButton option3 = new JRadioButton("Paris");
        JRadioButton option4 = new JRadioButton("Rome");
        ButtonGroup optionsGroup = new ButtonGroup();
        JButton submitButton = new JButton("Submit");
        JLabel resultLabel = new JLabel("");

        // Set layout
        frame.setLayout(null);

        // Add components
        questionLabel.setBounds(50, 30, 300, 30);
        option1.setBounds(50, 70, 100, 30);
        option2.setBounds(50, 100, 100, 30);
        option3.setBounds(50, 130, 100, 30);
        option4.setBounds(50, 160, 100, 30);
        submitButton.setBounds(50, 200, 100, 30);
        resultLabel.setBounds(50, 240, 300, 30);

        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        frame.add(questionLabel);
        frame.add(option1);
        frame.add(option2);
        frame.add(option3);
        frame.add(option4);
        frame.add(submitButton);
        frame.add(resultLabel);

        // Handle button click
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (option3.isSelected()) {
                    resultLabel.setText("Correct! Paris is the capital of France.");
                } else {
                    resultLabel.setText("Wrong answer. The correct answer is Paris.");
                }
            }
        });

        // Frame settings
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
