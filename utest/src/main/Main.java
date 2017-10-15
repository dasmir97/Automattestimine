package main;
public class Main {

    public static void main(String[] args) {
        WeatherRequest request = new WeatherRequest("Tallinn", "EE", "metric");
        CurrentWeatherRepository currentWeatherRepository = new CurrentWeatherRepository();
        ForecastRepository forecastRepository = new ForecastRepository();

        CurrentWeatherReport currentWeatherReport = currentWeatherRepository.getCurrentWeather(request);
        ForecastReport forecastReport = forecastRepository.getForecast(request);

        System.out.println(currentWeatherReport);
        System.out.println("----------");
        System.out.println(forecastReport);
    }
}