package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    //1. В статическом блоке инициализировать словарь map парами
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException
    {
        //2. Считать с консоли имя файла
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));

        //3. Заменить все числа на слова используя словарь map
        while (fileReader.ready()){
            //получаем строку из файла
            String stringFromFile = fileReader.readLine();
            //получаем массив строк
            String[] words = stringFromFile.split(" ");
            //ищем числа и заменяем их в массиве на слова
            for (int i = 0; i < words.length; i++){
                try
                {
                    int number = Integer.parseInt(words[i]);
                    if (number >= 0 && number <= 12){
                        words[i] = map.get(number);
                    }
                } catch (Exception e){}
            }

            //собираем строку обратно
//            stringFromFile = String.join(" ", words);//этот метод из 8 Java. На сервее проверки Javarush не работает
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < words.length; i++){
                builder.append(words[i]);
                if (i < words.length-1) builder.append(" ");
            }
            stringFromFile = builder.toString();

            //4. Результат вывести на экран
            System.out.println(stringFromFile);
        }

        //5. Закрыть потоки.
        if (consoleReader!=null) consoleReader.close();
        if (fileReader!=null) fileReader.close();
    }
}
