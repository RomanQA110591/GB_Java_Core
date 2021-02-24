package ru.GB.Lesson8;

import jdk.internal.access.JavaIOFileDescriptorAccess;
import jdk.internal.icu.lang.UCharacterDirection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Scanner;

public class UserInterface {



    public void runApplication() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {


        Scanner city = new Scanner(System.in);
        System.out.print("Введите город: ");
        String name = city.nextLine();
        System.out.printf("Город: %s  \n", name);



        Scanner pogod = new Scanner(System.in);
        System.out.print("Введите ответ: введите 1 - чтобы получить погоду на 5 дней");
        String pogoda = pogod.nextLine();
        System.out.printf("\n", pogoda);




        final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast?q=Moscow,us&mode=xml&appid=c2f2c3d138a4f239eb05182bbca9bdda";

        // создаем URL из строки
        URL url = JsonUtils.createUrl(WEATHER_URL);

        // загружаем Json в виде Java строки
        String resultJson = JsonUtils.parseUrl(url);
        //System.out.println("Полученный JSON:\n" + resultJson);

        // парсим полученный JSON и печатаем его на экран
        JsonUtils.parseCurrentWeatherJson(resultJson);



        try (FileWriter file = new FileWriter("./pogoda.json")) {
            String response = resultJson;
            file.write(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // соединение с БД
        System.out.println("JDBC Connection");
        Connection conn = null;

        Class.forName("org.sqlite.JDBC").newInstance();
        String url2 = "jdbc:sqlite:Lesson8db.db";
        System.out.println("Database Connection Established...");



        // Запись в БД
        String insertTableSQL = "INSERT INTO Pogoda"
                + "(id, name, time, value) " + "VALUES"
                + "(3, 'Moskva', 24, 10)";

        // Выборка данных
        String selectTableSQL = "SELECT id, name, time, value from Pogoda";


        Scanner scaner = new Scanner(System.in);
        System.out.print("Наберите Выход - чтобы завершить работу");
        String result = scaner.nextLine();
        System.out.printf("\n", result);
        scaner.close();





    }

}

