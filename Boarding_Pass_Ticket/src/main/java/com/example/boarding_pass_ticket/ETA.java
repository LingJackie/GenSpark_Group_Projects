import org.jetbrains.annotations.NotNull;

import javax.swing.text.Document;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.nio.file.Files;

public class ETA {

    String destination;
    String eta;
    String flightDuration;
    String departureTime;


    public ETA() {}

    public ETA(String destination) {this.destination = destination;}


    /**
     * @param flightDuration - Duration of the flight in the format of "7 hours, 30 minutes"
     * @param departureTime - 24 hour time in the format of "15:24"
     * @return
     */

    public String calculateEta(String flightDuration, String departureTime) {

        DecimalFormat formatter = new DecimalFormat("00");

        // Creates int variables for local time hours and minutes // 15:24
        String[] localTimeArray = departureTime.split(":"); // {15, 24}
        int localTimeHour = Integer.parseInt(localTimeArray[0]);   // 15
        int localTimeMinutes = Integer.parseInt(localTimeArray[1]);  // 24

        // Creates int variables for duration hours and minutes                //7 hours, 30 minutes
        String[] arrayOfLengthOfFlight = flightDuration.split(",");            // {7 hours, 30 minutes}
        String[] hoursSplitArray = arrayOfLengthOfFlight[0].trim().split(" "); // {7, hours}
        String[] minutesSplitArray = arrayOfLengthOfFlight[1].trim().split(" ");  // {30, minutes}
        int durationHours = Integer.parseInt(hoursSplitArray[0]);               // 7
        int durationMinutes = Integer.parseInt(minutesSplitArray[0]);           //30

        if((localTimeMinutes + durationMinutes) >= 60) {
            localTimeHour++;
            localTimeMinutes = (localTimeMinutes + durationMinutes) - 60;
        }

        if ((localTimeHour + durationHours) >= 24) {
            localTimeHour = (localTimeHour + durationHours) - 24;
            localTimeMinutes = localTimeMinutes + durationMinutes;
        } else {
            localTimeHour = localTimeHour + durationHours;
            localTimeMinutes = localTimeMinutes + durationMinutes;
        }

        String localTimeHourString = formatter.format(localTimeHour);
        String localTimeMinutesString = String.valueOf(localTimeMinutes);

        return localTimeHourString + ":" + localTimeMinutesString;
    }


    public HashMap<String, ArrayList<String>> generateCitiesMap() throws Exception {

        HashMap<String, ArrayList<String>> citiesMap = new HashMap<>();

        ArrayList<String> currCountriesCity;

        // Reads test file and saves it to a list
        URL url = getClass().getResource("cities.txt");
        Path path = Paths.get(url.toURI());
        List<String> citiesList = Files.readAllLines(path);


        String city = null;
        String country = null;

        for (String name : citiesList) {
            String[] split = name.split(", ");
            city = split[0].trim();
            country = split[1].trim();


            if(citiesMap.containsKey(country)){
                currCountriesCity = citiesMap.get(country); // Grabs the list of cities from country
                currCountriesCity.add(city); // Adds the new city into the list
                citiesMap.put(country, currCountriesCity); // Adds the new updated list into the hashmap
            } else {
                citiesMap.put(country, new ArrayList<String>( Arrays.asList(city)) );
            }
        }

        return citiesMap;
    }

    /*
    public String generateFlightDuration(String origin, String destination) {

        String[] originArray = origin.split(", ");
        String[] destinationArray = origin.split(", ");
        String originCity = originArray[0];
        String originCountry = originArray[1];
        String destinationCity = destinationArray[0];
        String destinationCountry = destinationArray[1];


        try {
            String url = "https://www.travelmath.com/flying-time/from/New+York,+NY/to/London,+United+Kingdom"; // or whatever goes here
            Document document = Jsoup.connect(url).followRedirects(false).timeout(60000 / wait up to 60sec for response /).
            get();
            String value = document.body().select("#flyingtime" / css selector /).get(0).text();
            System.out.println(value);
        } catch (Exception e) {
            System.out.println("dont work");
        }

        return duration;
    }

     */
    
    //Getters
    public String getEta() {return eta;}
    public String getDestination() {return destination;}
    public String getFlightDuration() {return flightDuration;}
    public String getDepartureTime() {return departureTime;}

    //Setters
    public void setEta(String eta) {this.eta = eta;}
    public void setDestination(String destination) {this.destination = destination;}
    public void setDuration(String flightDuration) {this.flightDuration = flightDuration;}
    public void setDepartureTime(String departureTime) {this.departureTime = departureTime;}


}