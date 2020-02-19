import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import javax.swing.*;

class SimpleGUI extends JFrame {
    private JTextField inputFP = new JTextField("", 5);
    private JTextField inputKey = new JTextField("", 5);

    SimpleGUI() {
        super("CRPTX");
        this.setBounds(100, 100, 300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        JLabel labelFP = new JLabel("Путь до файла:");
        container.add(labelFP);
        container.add(inputFP);
        JLabel labelKey = new JLabel("Ключ (опционально):");
        container.add(labelKey);
        container.add(inputKey);

        JButton buttonLock = new JButton("Lock");
        buttonLock.addActionListener(new ButtonEventListener());
        JButton buttonUnlock = new JButton("Unlock");
        buttonUnlock.addActionListener(new ButtonEventListener());
        container.add(buttonLock);
        container.add(buttonUnlock);
    }

    private class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message;
            Locker locker;
            try {
                if (inputFP.getText().isEmpty()) {
                    throw new IOException("\nУкажите путь к файлу");
                }
                if (inputKey.getText().isEmpty()) {
                    locker = new Locker("", inputFP.getText(), e.getActionCommand());
                } else {
                    locker = new Locker(inputKey.getText(), inputFP.getText(), e.getActionCommand());
                }
                locker.doSmthng();
                message = "Готово!" +
                        "\nНовый файл находится в директории" +
                        "\nрядом с исходным файлом.";
            } catch (NoSuchFileException q) {
                message = q.toString() +
                        "\nФайл не найден." +
                        "\nПроверьте корректность введенных данных.";
            } catch (Throwable q) {
                message = q.toString();
            }
            JOptionPane.showMessageDialog(null, message, "Результат", JOptionPane.PLAIN_MESSAGE);
        }
    }
}