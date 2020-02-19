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
                lock();
                break;
            case "Unlock":
                unlock();
                break;
        }
    }

    //TODO: сделать нормальный алгоритм шифрования (мысли на этот счет см.Main)
    private void lock() throws Throwable {
        byte[] file = Files.readAllBytes(Paths.get(filePath));

        for (int i = 0; i < file.length; i++) {
            file[i] += 1;
        }

        Path path = Paths.get(filePath + "l"); //можно заморочиться с нормальными именами, но лень...
        Files.write(path, file, StandardOpenOption.CREATE_NEW);
    }

    private void unlock() throws Throwable {
        byte[] file = Files.readAllBytes(Paths.get(filePath));

        for (int i = 0; i < file.length; i++) {
            file[i] -= 1;
        }

        Path path = Paths.get(filePath + "u");
        Files.write(path, file, StandardOpenOption.CREATE_NEW);
    }
}
