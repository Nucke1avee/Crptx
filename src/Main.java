import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Throwable{
        SimpleGUI crptx = new SimpleGUI();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        crptx.setLocation(size.width / 2 - crptx.getWidth() / 2, size.height / 2 - crptx.getHeight() / 2);
        //crptx.setVisible(true);

        //дано
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> tmp = new ArrayList<>();
        //byte[] byteKey = key.getBytes();
        int[] intKey = new int[]{10, 20, 30, 40};
        //
        System.out.println("начальный массив");
        for (int aa : a) {
            System.out.print(aa+" ");
        }
        System.out.println();
        System.out.println("ключ");
        for (int ik : intKey) {
            System.out.print(ik+" ");
        }
        System.out.println();
        //надо получить - заполненный массив тмп + a.length() % intKey.length()
        /*System.out.println(a.length % intKey.length);
        System.out.println(intKey.length % a.length);

        byte[] file = Files.readAllBytes(Paths.get("D:\\Desktop\\111\\111.txt")); //учесть возможность слишком маленького файла
        System.out.println("file length: " + file.length);
        for (int aa : file) {
            System.out.print(aa+" ");
        }*/
        int aLength = a.length;
        int kLength = intKey.length;
        for (int i = 0; i < a.length; i++) {
            tmp.add(a[i] + intKey[i % kLength]);
        }
        tmp.add(aLength % kLength);

        System.out.println("щито в итоге");
        for (int i : tmp) {
            System.out.print(i+" ");
        }

        /*//TODO доделать (мысли в слух)
        String s = "1234567890qweASDzxc!!!";
        System.out.println(s);

        byte[] b = s.getBytes();
        for (byte bb : b) {
            System.out.print(bb + " ");
        }
        System.out.println("\n//////////////////////////");
        for (int i = 0; i < b.length; i++) {
            b[i] *= b[i];
        }

        for (byte bb : b) {
            System.out.print(bb + " ");
        }
        *//*

        123456789
        123456789123456
        2468101214161824681012 3

         */
        /**
         * Имеем: ключ (пароль) в виде строки, и набор (массив) байтов (из файла), которые нужно зашифровать.
         * 1. переводим ключ в массив байт
         * 2. идем циклом одновременно по двум массивам (по ключу и по файлу),
         *    по ключу идем циклически, пока не закончится массив байтов файла
         * 3. считаем кол-во оставшихся до конца байтов в ключе и пишем их одним байтом в конец нового массива
         * 4. пишем новый массив в файл
         */
    }
}