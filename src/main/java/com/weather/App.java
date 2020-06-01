package com.weather;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Locale;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import org.geojson.Feature;

/**
 * Prints the weather forecast
 * 
 * @usage java -cp target/client-1.0-SNAPSHOT.jar: com.weather.App
 *        "39.7456,-97.0892"
 */
public final class App {

    private static ResourceBundle rb = ResourceBundle.getBundle("config", Locale.getDefault());

    private static String URL = rb.getString("ENDPOINT_URL");
    private static String URL_GRID_POINTS = URL + "gridpoints/";

    private App() {
    }

    /**
     * Prints the weather for cast for next 5 days
     * 
     * 
     * @param args longitude,latitude comming from command line
     */
    public static void main(String[] args) {
        ForeCastRequestDetail foreCastDetail = fetchPoint(args[0]);
        fetchForeCastAndPrint(foreCastDetail, 5);

    }

    /**
     * fetch 5 days forecast and print that on console
     * 
     * @param foreCastDetail
     * @param no             Number of days
     */
    private static void fetchForeCastAndPrint(ForeCastRequestDetail foreCastDetail, int n) {

        ArrayList list = new ArrayList<>();
        try {
            URL url = new URL(URL_GRID_POINTS + foreCastDetail.forecastOffice + "/" + foreCastDetail.gridX + ","
                    + foreCastDetail.gridY + "/forecast");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // System.out.println(conn.getResponseCode());
            Feature feature = new ObjectMapper().readValue(conn.getInputStream(), Feature.class);
            Map<String, Object> properties = feature.getProperties();
            list = (ArrayList) properties.get("periods");
            System.out.println("Next Five Day Forecast" + "\n");
            list.stream().limit(n).forEach(item -> {
                Map map = (Map) item;
                System.out.println("Day " + map.get("number") + " --> " + (String) map.get("detailedForecast"));
                System.out.println("\n");
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Method Fetch Forecast details like Point and forecast office
     * 
     * @param coordinates
     * @return
     */
    private static ForeCastRequestDetail fetchPoint(String coordinates) {
        int gridX = 0, gridY = 0;
        String forecastOffice = "";
        try {
            URL url = new URL(URL + "points/" + coordinates);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // System.out.println(conn.getResponseCode());
            Feature feature = new ObjectMapper().readValue(conn.getInputStream(), Feature.class);
            Map<String, Object> properties = feature.getProperties();
            gridX = (Integer) properties.get("gridX");
            gridY = (Integer) properties.get("gridY");
            forecastOffice = (String) properties.get("cwa");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ForeCastRequestDetail(String.valueOf(gridX), String.valueOf(gridY), forecastOffice);

    }
}
