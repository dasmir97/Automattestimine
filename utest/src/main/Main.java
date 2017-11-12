package main;
import java.io.*;

public class Main {

    private String city;
    private CurrentWeatherReport currentWeatherReport;
    private ForecastReport forecastReport;

    public void setCity(String city) {
        this.city = city;
    }

    public void getWeatherAndForecast() {
        WeatherRequest request = new WeatherRequest(city, null, "metric");

        CurrentWeatherRepository currentWeatherRepository = new CurrentWeatherRepository();
        ForecastRepository forecastRepository = new ForecastRepository();

        currentWeatherReport = currentWeatherRepository.getCurrentWeather(request);
        forecastReport = forecastRepository.getForecast(request);
    }

    public void printResults() {
        System.out.println(currentWeatherReport);
        System.out.println("----------");
        System.out.println(forecastReport);
    }

    public void saveResults(String fileName) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            out.write("Weather report.");
            out.newLine();
            out.write("City: " + currentWeatherReport.getCity());
            out.newLine();
            if (currentWeatherReport.getCountry() != null) {
                out.write("Country: " + currentWeatherReport.getCountry());
                out.newLine();
            }
            out.write("Units: " + currentWeatherReport.getUnits());
            out.newLine();
            out.write("Coordinates: " + currentWeatherReport.getLongitude() + ", " + currentWeatherReport.getLatitude());
            out.newLine();
            out.write("Current temperature: " + currentWeatherReport.getCurrentTemp());
            out.newLine();
            out.write("Forecast (min; max).");
            out.newLine();
            out.write("Day 1: " + forecastReport.getDay1Min() + "; " +forecastReport.getDay1Max());
            out.newLine();
            out.write("Day 2: " + forecastReport.getDay2Min() + "; " +forecastReport.getDay2Max());
            out.newLine();
            out.write("Day 3: " + forecastReport.getDay3Min() + "; " +forecastReport.getDay3Max());
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        if (args.length == 1) {
            main.setCity(args[0]);
        } else {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("Automattestimine/utest/input.txt"), "UTF-8"))) {
                String line = in.readLine().trim();
                main.setCity(line);
            }
        }

        main.getWeatherAndForecast();
        main.printResults();
        main.saveResults("output.txt");
    }
}