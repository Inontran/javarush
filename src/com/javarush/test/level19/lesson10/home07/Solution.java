package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        while (reader.ready()){
            String[] strings = reader.readLine().split(" ");
            //Записать через запятую в Файл2 слова, длина которых строго больше 6
            for (int i = 0; i < strings.length; i++){
                if (strings[i].length() > 6) writer.write(strings[i] + ",");
            }
        }

        //Закрыть потоки.
        if (reader!=null) reader.close();
        if (writer!=null) writer.close();
    }
}
