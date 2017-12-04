import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        input:
        while (true) {
            System.out.print("Read cities from input.txt (1) or input them yourself (2)? ");
            switch (sc.nextLine()) {
                case "1":
                    try {
                        new FileReadWrite().readFromFile();
                        System.out.println("Success\n");
                    } catch (Exception e) {
                        System.out.println("Wrong input\n");
                    }
                    break input;
                case "2":
                    userInput();
                    break input;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    private static void userInput() {
        String city;
        String country;

        while (true) {
            System.out.println("Input \"q\" for quit");
            System.out.print("City: ");
            city = sc.nextLine();
            System.out.print("Country code: ");
            country = sc.nextLine();

            if (city.equals("q") || country.equals("q")) {
                break;
            }

            try {
                FileReadWrite fileReadWrite = new FileReadWrite();
                fileReadWrite.getWeatherAndForecast(city, country);
                fileReadWrite.writeToFile();
                System.out.println("Success\n");
            } catch (Exception e) {
                System.out.println("Wrong input\n");
            }
        }
    }
}