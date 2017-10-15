package main;
public class ForecastReport {

    private String city;
    private String country;
    private String units;
    private double longitude;
    private double latitude;
    private double day1Min;
    private double day1Max;
    private double day2Min;
    private double day2Max;
    private double day3Min;
    private double day3Max;

    ForecastReport(String city,
                   String country,
                   String units,
                   double longitude,
                   double latitude,
                   double day1Min,
                   double day1Max,
                   double day2Min,
                   double day2Max,
                   double day3Min,
                   double day3Max) {
        this.city = city;
        this.country = country;
        this.units = units;
        this.longitude = longitude;
        this.latitude = latitude;
        this.day1Min = day1Min;
        this.day1Max = day1Max;
        this.day2Min = day2Min;
        this.day2Max = day2Max;
        this.day3Min = day3Min;
        this.day3Max = day3Max;
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

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getDay1Min() {
        return day1Min;
    }

    public double getDay1Max() {
        return day1Max;
    }

    public double getDay2Min() {
        return day2Min;
    }

    public double getDay2Max() {
        return day2Max;
    }

    public double getDay3Min() {
        return day3Min;
    }

    public double getDay3Max() {
        return day3Max;
    }

    @Override
    public String toString() {
        return "Weather report:\n" +
                "City: " + city + "\n" +
                "Country: " + country + "\n" +
                "Units: " + units + "\n" +
                "Coordinates: " + longitude + ", " + latitude + "\n" +
                "Forecast (min; max):\n" +
                "\tDay 1: " + day1Min + "; " + day1Max + "\n" +
                "\tDay 2: " + day2Min + "; " + day2Max + "\n" +
                "\tDay 3: " + day3Min + "; " + day3Max;
    }
}
