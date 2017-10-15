package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

class CurrentWeatherRepository {

    private Map<String, String> fullResult = new HashMap<>();

    CurrentWeatherReport getCurrentWeather(WeatherRequest request) {
        fullResult.clear();
        fullResult.putAll(parseCurrentWeatherRequest(request.getCurrentWeatherRequest()));
        fullResult.putAll(parseForecastRequest(request.getForecastRequest()));

        return new CurrentWeatherReport(
                request.getCity(),
                request.getCountry(),
                request.getUnits(),
                Double.parseDouble(fullResult.get("longitude")),
                Double.parseDouble(fullResult.get("latitude")),
                Double.parseDouble(fullResult.get("currentTemp")),
                Double.parseDouble(fullResult.get("day1Min")),
                Double.parseDouble(fullResult.get("day1Max")),
                Double.parseDouble(fullResult.get("day2Min")),
                Double.parseDouble(fullResult.get("day2Max")),
                Double.parseDouble(fullResult.get("day3Min")),
                Double.parseDouble(fullResult.get("day3Max")));
    }

    Map<String, String> parseCurrentWeatherRequest(String json) {
        Map<String, String> result = new HashMap<>();

        try {
            JSONParser parser = new JSONParser();
            JSONObject mainObj = (JSONObject) parser.parse(json);
            JSONObject coordinates = (JSONObject) mainObj.get("coord");

            String longitude = String.valueOf(coordinates.get("lon"));
            String latitude = String.valueOf(coordinates.get("lat"));
            result.put("longitude", longitude);
            result.put("latitude", latitude);

            JSONObject currentTempObj = (JSONObject) mainObj.get("main");
            String currentTemp = String.valueOf(currentTempObj.get("temp"));
            result.put("currentTemp", currentTemp);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    Map<String, String> parseForecastRequest(String json) {
        Map<String, String> result = new HashMap<>();

        try {
            JSONParser parser = new JSONParser();
            JSONObject mainObj = (JSONObject) parser.parse(json);
            JSONArray days = (JSONArray) mainObj.get("list");

            for (int i = 0; i < 3; i++) {
                JSONObject day = (JSONObject) days.get(0);
                JSONObject forecastTempObj = (JSONObject) day.get("main");

                String min = String.valueOf(forecastTempObj.get("temp_min"));
                String max = String.valueOf(forecastTempObj.get("temp_max"));
                result.put("day" + (i + 1) + "Min", min);
                result.put("day" + (i + 1) + "Max", max);
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
