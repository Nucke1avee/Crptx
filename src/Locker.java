import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class Locker {
    private String key;
    private String filePath;
    private String buttonPressed;

    Locker(String key, String filePath, String buttonPressed) {
        this.key = key;
        this.filePath = filePath;
        this.buttonPressed = buttonPressed;
    }

    void doSmthng() throws IOException {
        if (buttonPressed.equals("Lock")) {
            lock();
        } else {
            unlock();
        }
    }

    //TODO: реализовать что-нить более адекватное (ибо долго и достаточно тупо, хоть и работает)...
    private void lock() throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(filePath + "l");

        if (key.equals("0")) {
            int i = 0;
            while (fis.available() > 0) {
                if (i < 10) {
                    fos.write(fis.read() + 1);
                    i++;
                } else {
                    fos.write(fis.read());
                }

            }
        } else {
            throw new IOException("fck");
        }
        fos.close();
        fis.close();
    }

    private void unlock() throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(filePath + "u");

        if (key.equals("0")) {
            int i = 0;
            while (fis.available() > 0) {
                if (i < 10) {
                    fos.write(fis.read() - 1);
                    i++;
                } else {
                    fos.write(fis.read());
                }
            }
        } else {
            throw new IOException("fck");
        }
        fos.close();
        fis.close();
    }
}
