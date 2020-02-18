import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Locker {
    private String key;
    private String filePath;
    private String buttonPressed;

    public Locker(String key, String filePath, String buttonPressed) {
        this.key = key;
        this.filePath = filePath;
        this.buttonPressed = buttonPressed;
    }

    public void doSmthng() throws IOException {
        if (buttonPressed.equals("Lock")) {
            lock();
        } else {
            unlock();
        }
    }

    private void lock() throws IOException {
        System.out.println("We Will Lock You!");

        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(filePath + "l");

        while (fis.available() > 0) {
            fos.write(fis.read() + 1);
        }
        fos.close();
        fis.close();
    }

    private void unlock() throws IOException {
        System.out.println("Fck ths sht, let me out!");

        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(filePath + "u");

        while (fis.available() > 0) {
            fos.write(fis.read() - 1);
        }
        fos.close();
        fis.close();
    }
}
