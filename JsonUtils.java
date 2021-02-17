package ru.GB.Lesson6;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonUtils {

    /**
     * Метод для получения данных по указанной ссылке
     *
     * @param url - ссылка в виде объекта URL (Uniform Resource Locator)
     * @return содержимое страницы на указанной ссылке в @param url
     */
    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
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
            System.out.println("Название города: " + weatherJsonObject.get("name"));

            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather");
            // достаем из массива первый элемент
            JSONObject weatherData = (JSONObject) weatherArray.get(0);

            // печатаем погоду в консоль
            System.out.println("Погода на 5 день: " + weatherData.get("main"));
            // и описание к ней
            System.out.println("Более детальное описание погоды: " + weatherData.get("description"));

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    // формируем новый JSON объект из нужных нам погодных данных
    public static String buildWeatherJson() {
        // для простоты примера просто хардкодим нужные данные в методе
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Moskva");
        jsonObject.put("main", "Солнечно");
        jsonObject.put("description", "Мороз трескучий, На небе ни единой тучи");

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
