package com.networks.project.server.handlers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.networks.project.server.functionality.CompatibilityApi;
import com.networks.project.server.functionality.MovieApi;
import com.networks.project.server.responses.Response;
import com.networks.project.server.responses.ResponseBuilder;


public class CompatibilityHandler {
    public static Response handleRequest(String Request){
        String[] names= Request.split(";");
        try {
         return generateCompatibility(names[0],names[1]);
     } catch (MalformedURLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
 return null;
 }

 public static Response generateCompatibility(String sname,String fname) throws MalformedURLException{
        URL url = new URL("https://love-calculator.p.rapidapi.com/getPercentage?sname="+sname+"&fname="+fname);
        ArrayList<String> result =  CompatibilityApi.lovePercentage(url);
        Response r = ResponseBuilder.compatibilityResponse(result);
        return r;
}
}
