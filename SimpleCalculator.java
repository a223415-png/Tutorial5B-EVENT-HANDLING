import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4;
    private JTextField textNum1, textNum2, textResult;
    private JButton addButton, subButton, mulButton, divButton;

    public SimpleCalculator() {
        // Create components
        label1 = new JLabel("Simple Calculator");
        label2 = new JLabel("Enter first number:");
        label3 = new JLabel("Enter second number:");
        label4 = new JLabel("Result:");

        textNum1 = new JTextField(10);
        textNum2 = new JTextField(10);
        textResult = new JTextField(10);
        textResult.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        // Bigger font for labels and text fields
        Font textFont = new Font("Arial", Font.BOLD, 14);
        label1.setFont(textFont);
        label2.setFont(textFont);
        label3.setFont(textFont);
        label4.setFont(textFont);
        textNum1.setFont(textFont);
        textNum2.setFont(textFont);
        textResult.setFont(textFont);

        // Bigger font for the operation buttons
        Font btnFont = new Font("Arial", Font.BOLD, 22);
        addButton.setFont(btnFont);
        subButton.setFont(btnFont);
        mulButton.setFont(btnFont);
        divButton.setFont(btnFont);

        // Remove inner padding so the symbol is not replaced by "..."
        Insets noMargin = new Insets(0, 0, 0, 0);
        addButton.setMargin(noMargin);
        subButton.setMargin(noMargin);
        mulButton.setMargin(noMargin);
        divButton.setMargin(noMargin);

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);

        // Put the 4 buttons in one panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);

        // Layout setup
        setLayout(new GridLayout(5, 2, 5, 5));
        add(label1);
        add(new JLabel(""));
        add(label2);
        add(textNum1);
        add(label3);
        add(textNum2);
        add(label4);
        add(textResult);
        add(new JLabel(""));
        add(buttonPanel);
    }

    // Handle button click
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(textNum1.getText());
            double num2 = Double.parseDouble(textNum2.getText());
            double result = 0;

            if (e.getSource() == addButton)
                result = num1 + num2;
            else if (e.getSource() == subButton)
                result = num1 - num2;
            else if (e.getSource() == mulButton)
                result = num1 * num2;
            else if (e.getSource() == divButton) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
                    return;
                }
                result = num1 / num2;
            }

            textResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        SimpleCalculator frame = new SimpleCalculator();
        frame.setTitle("Simple Calculator");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
