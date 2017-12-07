import java.io.*;

public class 	FileReadWrite {

	private CurrentWeatherReport currentWeatherReport;
	private ForecastReport forecastReport;

	public void readFromFile() throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"))) {
			String line;
			String city;
			String country = null;

			while ((line = in.readLine()) != null) {
				String[] request = line.trim().split(",");
				city = request[0];

				if (request.length > 1) {
					country = request[1];
				}

				getWeatherAndForecast(city, country);
				writeToFile(currentWeatherReport, forecastReport);
			}
		}
	}

	public void writeToFile(CurrentWeatherReport currentWeatherReport, ForecastReport forecastReport) throws IOException {
		try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currentWeatherReport.getCity() + ".txt"), "UTF-8"))) {
			out.write("Place: " + currentWeatherReport.getCity());
			if (currentWeatherReport.getCountry() != null) {
				out.write(", " + currentWeatherReport.getCountry());
				out.newLine();
			}
			out.write("Coordinates: " + currentWeatherReport.getLongitude() + ", " + currentWeatherReport.getLatitude());
			out.newLine();
			out.write("Day 1 forecast: " + forecastReport.getDay1Max() + "; " +forecastReport.getDay1Min());
			out.newLine();
			out.write("Day 2 forecast: " + forecastReport.getDay2Max() + "; " +forecastReport.getDay2Min());
			out.newLine();
			out.write("Day 3 forecast: " + forecastReport.getDay3Max() + "; " +forecastReport.getDay3Min());
			out.newLine();
			out.write("Current temperature: " + currentWeatherReport.getCurrentTemp());
		}
	}

	private void getWeatherAndForecast(String city, String country) {
		WeatherRequest request = new WeatherRequest(city, country, "metric");

		CurrentWeatherRepository currentWeatherRepository = new CurrentWeatherRepository();
		ForecastRepository forecastRepository = new ForecastRepository();

		currentWeatherReport = currentWeatherRepository.getCurrentWeather(request);
		forecastReport = forecastRepository.getForecast(request);
	}
}
