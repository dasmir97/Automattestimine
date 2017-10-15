package main;


public class Main {

    public static void main(String[] args) {
        WeatherRequest request = new WeatherRequest("Tallinn", "ee", "metric");
        CurrentWeatherRepository repository = new CurrentWeatherRepository();

        CurrentWeatherReport report = repository.getCurrentWeather(request);

        System.out.println(report);
    }
}
