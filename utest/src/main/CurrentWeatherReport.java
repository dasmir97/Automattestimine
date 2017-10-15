package main;
public class CurrentWeatherReport {

    private String city;
    private String country;
    private String units;
    private double longitude;
    private double latitude;
    private double currentTemp;

    CurrentWeatherReport(String city,
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

    String getCity() {
        return city;
    }

    String getCountry() {
        return country;
    }

    String getUnits() {
        return units;
    }

    double getLongitude() {
        return longitude;
    }

    double getLatitude() {
        return latitude;
    }

    public double getCurrentTemp() {
        return currentTemp;
    }

    @Override
    public String toString() {
        return "Weather report:\n" +
                "City: " + city + "\n" +
                "Country: " + country + "\n" +
                "Units: " + units + "\n" +
                "Coordinates: " + longitude + ", " + latitude + "\n" +
                "Current temperature: " + currentTemp;
    }
}
