package ui;

import facade.ApplicationFacade;
import facade.ApplicationFacadeMock;

import javax.swing.*;

public class ApplicationView extends JFrame {
    private JPanel contentPane;
    private JButton checkSyntaxButton;
    private JButton evaluateButton;
    private JTextField textFieldInput;
    private JTextField textFieldResult;

    private ApplicationFacade app = new ApplicationFacadeMock();

    public ApplicationView() {
        setBounds(0,0,400,300);
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        checkSyntaxButton.addActionListener(e -> onCheckSyntax());
        evaluateButton.addActionListener(e -> onEvaluate());
    }

    public static void main(String[] args) {
        ApplicationView view = new ApplicationView();
    }

    private void onCheckSyntax() {
        try {
            this.app.checkSyntax(this.textFieldInput.getText());
            this.textFieldResult.setText("Syntax OK");
        } catch (Exception e) {
            this.textFieldResult.setText(e.getMessage());
        }
    }

    private void onEvaluate() {
        try {
            String resultString = this.app.evaluate(this.textFieldInput.getText()).toString();
            this.textFieldResult.setText("Result is: " + resultString);
        } catch (Exception e) {
            this.textFieldResult.setText(e.getMessage());
        }
    }
}
