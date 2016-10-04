package com.javarush.test.level22.lesson18.big01;

/**
 * Created by Inontran on 04.10.2016.
 */
public class Field
{
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public void print(){}

    public void removeFullLines(){}

    public Integer getValue(int x, int y){
        return matrix[y][x];
    }

    public void setValue(int x, int y, int value){
        matrix[y][x] = value;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }
}
