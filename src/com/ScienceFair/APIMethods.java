package com.ScienceFair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIMethods {

    private static HttpURLConnection connection;

    public static void geocoding(String streetName, String zipCode, String stateCode) {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            String place = ((streetName.replace(" ", "-")) + "," + zipCode + "," + stateCode);
            URL url = new URL("http://www.mapquestapi.com/geocoding/v1/address?key=lgA9nZBGzY0WaddHoKmGK058qOOHuk1H&location=" + place);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();

            System.out.println(responseContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
    }
}
