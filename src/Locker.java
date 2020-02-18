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
    }

    private void unlock() throws IOException {
        System.out.println("Fck ths sht, let me out!");
    }
}
