package com.networks.project.server.functionality;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieApi {
    public static ArrayList<String> RecommendMovie(URL url) {
        ArrayList<String> result = new ArrayList<>();
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                //Close the scanner
                scanner.close();
                conn.disconnect();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                Object data_obj = parse.parse(inline);

                //Get the required object from the above created object
                JSONObject obj = (JSONObject)data_obj;
                JSONArray results = (JSONArray) obj.get("results");
                int randomMovie = (int)(Math.random()*(results.size()));

                JSONObject movie= (JSONObject)(results.get(randomMovie));
                result.add(movie.get("title").toString());
                result.add(movie.get("overview").toString());
                result.add(movie.get("poster_path").toString());
                //Get the required data using its key
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}