import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SimpleGUI crptx = new SimpleGUI();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        crptx.setLocation(size.width/2-crptx.getWidth()/2, size.height/2-crptx.getHeight()/2);
        crptx.setVisible(true);
    }
}