import java.io.IOException;
import java.nio.file.*;

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
        switch (buttonPressed) {
            case "Lock":
                if (key.isEmpty()) {
                    simpleLock();
                } else {
                    lock();
                }
                break;
            case "Unlock":
                if (key.isEmpty()) {
                    simpleUnlock();
                } else {
                    unlock();
                }
                break;
        }
    }

    //TODO: сделать нормальные генерируемые имена
    private void simpleLock() throws Throwable {
        byte[] file = Files.readAllBytes(Paths.get(filePath));
        for (int i = 0; i < file.length; i++) {
            file[i] += 1;
        }
        Path path = Paths.get(filePath + "l");
        Files.write(path, file, StandardOpenOption.CREATE_NEW);
    }

    private void simpleUnlock() throws Throwable {
        byte[] file = Files.readAllBytes(Paths.get(filePath));
        for (int i = 0; i < file.length; i++) {
            file[i] -= 1;
        }
        Path path = Paths.get(filePath + "u");
        Files.write(path, file, StandardOpenOption.CREATE_NEW);
    }

    private void lock() throws Throwable {
        byte[] file = Files.readAllBytes(Paths.get(filePath));
        byte[] key = this.key.getBytes();
        int fileLength = file.length;
        int keyLength = key.length;
        if (fileLength < keyLength)
            throw new IOException("\nФайл слишком мал: проверьте файл или\nпопробуйте оставить поле \"Ключ\" пустым");
        byte[] tmp = new byte[fileLength];

        for (int i = 0; i < fileLength; i++) {
            tmp[i] = (byte) (file[i] + key[i % keyLength]);
        }

        Path path = Paths.get(filePath + "l");
        Files.write(path, tmp, StandardOpenOption.CREATE_NEW);
    }

    private void unlock() throws Throwable {
        byte[] file = Files.readAllBytes(Paths.get(filePath));
        byte[] key = this.key.getBytes();
        int fileLength = file.length;
        int keyLength = key.length;
        if (fileLength < keyLength)
            throw new IOException("\nФайл слишком мал: проверьте файл или\nпопробуйте оставить поле \"Ключ\" пустым");
        byte[] tmp = new byte[fileLength];

        for (int i = 0; i < fileLength; i++) {
            tmp[i] = (byte) (file[i] - key[i % keyLength]);
        }

        Path path = Paths.get(filePath + "u");
        Files.write(path, tmp, StandardOpenOption.CREATE_NEW);
    }
}
