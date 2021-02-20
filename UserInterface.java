package ru.GB.Lesson7;

import java.net.URL;
import java.util.Scanner;

public class UserInterface {


    public void runApplication() {


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


        Scanner scaner = new Scanner(System.in);
        System.out.print("Наберите Выход - чтобы завершить работу");
        String result = scaner.nextLine();
        System.out.printf("\n", result);
        scaner.close();





        }

}
