import java.nio.file.Path;
import java.util.*;
import java.nio.file.Files;

public class ETA {

    public static void main(String[] args) throws Exception {
        ETA eta = new ETA();
        eta.generateCitiesMap();
    }

    String destination;
    String eta;
    String departureTime;
    String cities;
    String[] citiesArray;
    HashMap<String, String> citiesMap;

    public ETA() {}

    public ETA(String destination) {this.destination = destination;}

    /*
    public String calculateEta(String destination, String departureTime) {

        String[] arrayOfTime = departureTime.split(":"); // 15:24
        String[] arrayOfLengthOfFlight = city.split(","); // 7 hours, 30 minutes
        String[] hour = arrayOfLengthOfFlight[0].split(" "); // 7 hours

    }

     */

    public HashMap<String, String> generateCitiesMap() throws Exception {

        citiesMap = new HashMap<>();

        Path path = Path.of("C:\\Users\\19412\\GenSpark\\BoardingPass\\src\\main\\resources\\cities.txt");

        try{
            cities = Files.readString(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(cities);
        citiesArray = cities.split("\n");

        for (String name : citiesArray) {
            String[] split = name.split(", ");
            String city = split[0].trim();
            String country = split[1].trim();
            if(citiesMap.containsKey(country)){
                citiesMap.get(country).add(city);
            } else {
                citiesMap.put(country, city);
            }
        }
         return citiesMap;

        return null;
    }


    //Getters
    public String getEta() {return eta;}
    public String getDestination() {return destination;}

    //Setters
    public void setEta(String eta) {this.eta = eta;}
    public void setDestination(String destination) {this.destination = destination;}


    /*
    try {
        String url = "https://www.travelmath.com/flying-time/from/New+York,+NY/to/London,+United+Kingdom"; // or whatever goes here
        Document document = Jsoup.connect(url).followRedirects(false).timeout(60000 / wait up to 60sec for response /).
        get();
        String value = document.body().select("#flyingtime" / css selector /).get(0).text();
        System.out.println(value);
    } catch (Exception e) {
        System.out.println("dont work");
    }*/

}
