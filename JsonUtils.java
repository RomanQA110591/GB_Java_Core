package ru.GB.Lesson8;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JsonUtils {

    public static String parseUrl(URL url) {
        if (url == null) {
            return "\n";
        }
        StringBuilder stringBuilder = new StringBuilder();
        // открываем соедиение к указанному URL
        // помощью конструкции try-with-resources
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            // построчно считываем результат в объект StringBuilder
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    // парсим некоторые данные о погоде
    public static void parseCurrentWeatherJson(String resultJson) {
        try {
            // конвертируем строку с Json в JSONObject для дальнейшего его парсинга
            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);

            // получаем название города, для которого смотрим погоду
            System.out.println("Название города: \n" + weatherJsonObject.get("name\n"));

            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather\n");
            // достаем из массива первый элемент
            JSONObject weatherData = (JSONObject) weatherArray.get(0);

            // печатаем погоду в консоль
            System.out.println("Погода на 5 день: \n" + weatherData.get("main\n"));
            // и описание к ней
            System.out.println("Более детальное описание погоды: \n" + weatherData.get("description\n"));

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    // формируем новый JSON объект из нужных нам погодных данных
    public static String buildWeatherJson() {
        // для простоты примера просто хардкодим нужные данные в методе
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name\n", "Moskva");
        jsonObject.put("main\n", "Солнечно");
        jsonObject.put("description\n", "Мороз трескучий, На небе ни единой тучи");

        return jsonObject.toJSONString();
    }

    // создаем объект URL из указанной в параметре строки
    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
