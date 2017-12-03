public class CurrentWeatherReport {
	
	private String city;
	private String country;
	private double longitude;
	private double latitude;
	private double currentTemp;
	
	public CurrentWeatherReport(String city,
								String country,
								double longitude,
								double latitude,
								double currentTemp) {
		this.city = city;
		this.country = country;
		this.longitude = longitude;
		this.latitude = latitude;
		this.currentTemp = currentTemp;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getCurrentTemp() {
		return currentTemp;
	}
	
	@Override
	public String toString() {
		String result = "Current weather report.\n" +
				"City: " + city + "\n";
		if (country != null) {
			result += "Country: " + country + "\n";
		}
		return result +
				"Coordinates: " + longitude + ", " + latitude + "\n" +
				"Current temperature: " + currentTemp;
	}
}
