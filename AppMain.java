package ru.GB.Lesson5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class AppMain {
    public static void main(String[]args) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File("test.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Value 1");
        sb.append(';');
        sb.append("Value 2");
        sb.append(';');
        sb.append("Value 3");
        sb.append('\n');

        sb.append("100");
        sb.append(';');
        sb.append("200");
        sb.append(';');
        sb.append("300");
        sb.append('\n');

        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
}