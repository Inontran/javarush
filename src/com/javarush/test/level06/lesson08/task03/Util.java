package com.javarush.test.level06.lesson08.task03;

/* Класс Util
Реализовать статический метод double getDistance(x1, y1, x2, y2). Он должен вычислять расстояние между точками.
Используй метод double Math.sqrt(double a), который вычисляет квадратный корень переданного параметра
*/

public class Util
{
    public static double getDistance(int x1, int y1, int x2, int y2)
    {
        //напишите тут ваш код
        int a, b;

        if ( x1 - x2 > 0 ) a = x1 - x2;
        else a = -(x1 - x2);

        if ( y1 - y2 > 0 ) b = y1 - y2;
        else b = -(y1 - y2);

        return Math.sqrt( b*b + a*a );
    }

    public static void main (String[] args) throws Exception{
        System.out.println(Util.getDistance(0, 0, 2, 2));
    }
}
