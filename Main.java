package ru.GB.Lesson6;

import java.net.URL;

public class Main {

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/forecast?q=Moscow,us&mode=xml&appid=c2f2c3d138a4f239eb05182bbca9bdda";

    public static void main(String[] args) {
        // создаем URL из строки
        URL url = JsonUtils.createUrl(WEATHER_URL);

        // загружаем Json в виде Java строки
        String resultJson = JsonUtils.parseUrl(url);
        System.out.println("Полученный JSON:\n" + resultJson);

        // парсим полученный JSON и печатаем его на экран
        JsonUtils.parseCurrentWeatherJson(resultJson);

        // формируем новый JSON объект из нужных нам погодных данных
        String json = JsonUtils.buildWeatherJson();
        System.out.println("Созданный нами JSON:\n" + json);
    }
}
