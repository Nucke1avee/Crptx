import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    /*public static void main(String[] args) {
        if (args[0].equals("-e")) {
            encrypt(args[1], args[2]);
        } else if (args[0].equals("-d")) {
            decrypt(args[1], args[2]);
        } else {
            System.err.print("Incorrect arguments");
        }
    }*/

    public static void encrypt(String inputFileName, String outputFileName) {
        try {
            FileInputStream fis = new FileInputStream(inputFileName);
            FileOutputStream fos = new FileOutputStream(outputFileName);

            while (fis.available() > 0) {
                fos.write(fis.read() + 1);
            }
            fos.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decrypt(String inputFileName, String outputFileName) {
        try {
            FileInputStream fis = new FileInputStream(inputFileName);
            FileOutputStream fos = new FileOutputStream(outputFileName);

            while (fis.available() > 0) {
                fos.write(fis.read() - 1);
            }
            fos.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}