package com.networks.project.server.functionality;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CompatibilityApi {
    public static ArrayList<String> lovePercentage(URL url) {
        ArrayList<String> result = new ArrayList<>();
        try {
            HttpResponse<String> response = Unirest.get(url.toString())
            .header("x-rapidapi-host", "love-calculator.p.rapidapi.com")
            .header("x-rapidapi-key", "3bd7b3e746msh78db419d400581ep1121aejsnc5429ed423ab")
            .asString();
            //Getting the response code
            int responsecode = response.getStatus();
            System.out.println(response.getBody());
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                String inline = "";
                Scanner scanner = new Scanner(response.getBody());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                Object data_obj = parse.parse(inline);

                //Get the required object from the above created object
                JSONObject obj = (JSONObject)data_obj;
                result.add(obj.get("percentage").toString());
                result.add(obj.get("result").toString());
                //Get the required data using its key
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
