package ru.GB.Lesson5;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class ParserMain {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("test.csv"), Charset.defaultCharset());
        System.out.println(lines);
    }
}