package main;
public class CurrentWeatherReport {

    private String city;
    private String country;
    private String units;
    private double longitude;
    private double latitude;
    private double currentTemp;

    public CurrentWeatherReport(String city,
                                String country,
                                String units,
                                double longitude,
                                double latitude,
                                double currentTemp) {
        this.city = city;
        this.country = country;
        this.units = units;
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

    public String getUnits() {
        return units;
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
                "Units: " + units + "\n" +
                "Coordinates: " + longitude + ", " + latitude + "\n" +
                "Current temperature: " + currentTemp;
    }
}
