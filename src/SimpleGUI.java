import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JButton buttonLock = new JButton("Lock");
    private JButton buttonUnlock = new JButton("Unlock");
    private JTextField inputFP = new JTextField("", 5);
    private JTextField inputKey = new JTextField("", 5);
    private JLabel labelFP = new JLabel("File path = ");
    private JLabel labelKey = new JLabel("key = ");

    public SimpleGUI() {
        super("CRPTX");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(labelFP);
        container.add(inputFP);
        container.add(labelKey);
        container.add(inputKey);

        buttonLock.addActionListener(new ButtonEventListener());
        buttonUnlock.addActionListener(new ButtonEventListener());
        container.add(buttonLock);
        container.add(buttonUnlock);
    }

    private class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            Locker locker;
            try {
                //double output = Double.parseDouble(inputFP.getText()) / Double.parseDouble(inputKey.getText());
                //message = "Z = " + output;
                //message = e.getActionCommand();
                locker = new Locker(inputKey.getText(), inputFP.getText(), e.getActionCommand());
                locker.doSmthng();
                message = "Fck Ggl!";
            } catch (Exception q) {
                message = q.getMessage();
            }

            //message += "Button was pressed\n";
            //message += "Text is " + input.getText() + "\n";
            //message += (radio1.isSelected() ? "Radio #1" : "Radio #2") + " is selected!\n";
            //message += "Checkbox is " + ((check.isSelected()) ? "checked" : "unchecked");
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}