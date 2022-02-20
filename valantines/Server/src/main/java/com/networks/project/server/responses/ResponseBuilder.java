package com.networks.project.server.responses;

import java.util.ArrayList;

public class ResponseBuilder {
    public static Response combinedImageResponse(String img){
        ArrayList<String> outputs = new ArrayList<String>();
        outputs.add(img);
        Response r = new Response(1,outputs);
        return r;
    }
    public static Response movieRecomendationResponse(ArrayList<String> outputs){
        Response r = new Response(2, outputs);
        return r;
    }
    public static Response compatibilityResponse(ArrayList<String> outputs){
        Response r=new Response(3, outputs);
        return r;
    }
}
