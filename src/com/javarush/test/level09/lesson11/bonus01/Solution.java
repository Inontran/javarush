package com.javarush.test.level09.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два имени файла. И копирует первый файл на место заданное вторым именем.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();
        String destinationFileName = reader.readLine();

        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(sourceFileName);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(destinationFileName);

        byte[] buf = new byte[1024];

        int count;
        int sum = 0;
        while ( true )
        {
            count = fileInputStream.read(buf);
            if(count == -1 ) break;
            fileOutputStream.write(buf, sum, count);
            sum+=count;
        }

        System.out.println("Скопировано байт " + sum);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
