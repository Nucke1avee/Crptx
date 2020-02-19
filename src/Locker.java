import java.io.*;

class Locker {
    private String key;
    private String filePath;
    private String buttonPressed;

    Locker(String key, String filePath, String buttonPressed) {
        this.key = key;
        this.filePath = filePath;
        this.buttonPressed = buttonPressed;
    }

    void doSmthng() throws Throwable {
        if (buttonPressed.equals("Lock")) {
            lock();
        } else {
            unlock();
        }
    }

 /*   private void lock() throws Throwable {
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(filePath + "l");

        encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, fis, fos);

        fos.close();
        fis.close();
    }

    private void unlock() throws Throwable {
        FileInputStream fis = new FileInputStream(filePath);
        FileOutputStream fos = new FileOutputStream(filePath + "u");

        encryptOrDecrypt(key, Cipher.DECRYPT_MODE, fis, fos);

        fos.close();
        fis.close();
    }

    private void encryptOrDecrypt(String key, int mode, FileInputStream fis, FileOutputStream fos) throws Throwable{
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        ///////////////////////
        Key secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("Blowfish/CFB/NoPadding");

        if (mode == Cipher.ENCRYPT_MODE) {

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            CipherInputStream cis = new CipherInputStream(fis, cipher);
            doCopy(cis, fos);
        } else if (mode == Cipher.DECRYPT_MODE) {

            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            CipherOutputStream cos = new CipherOutputStream(fos, cipher);
            doCopy(fis, cos);
        }
    }

    private static void doCopy(InputStream is, OutputStream os)
            throws IOException {
        byte[] bytes = new byte[64];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            os.write(bytes, 0, numBytes);
        }
        os.flush();
        os.close();
        is.close();
    }
*/

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
            throw new IOException("Давай по-новой, Миша, всё хуйня!...");
        }
        fos.close();
        fis.close();
    }
}
