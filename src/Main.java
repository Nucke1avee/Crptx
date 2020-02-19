import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SimpleGUI crptx = new SimpleGUI();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        crptx.setLocation(size.width/2-crptx.getWidth()/2, size.height/2-crptx.getHeight()/2);
        crptx.setVisible(true);

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