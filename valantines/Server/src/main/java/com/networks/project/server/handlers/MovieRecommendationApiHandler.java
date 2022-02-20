package com.networks.project.server.handlers;

    import java.io.IOException;
    import java.net.HttpURLConnection;
    import java.net.MalformedURLException;
    import java.net.ProtocolException;
    import java.net.URL;
import java.util.ArrayList;

import com.networks.project.server.functionality.MovieApi;
import com.networks.project.server.responses.Response;
import com.networks.project.server.responses.ResponseBuilder;

    public class MovieRecommendationApiHandler {
        public static Response handleRequest(String Request){
               try {
                return generateRecommendation();
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return null;
        }

        public static Response generateRecommendation() throws MalformedURLException{
               MovieApi movie=new MovieApi();
               URL url = new URL("https://api.themoviedb.org/3/movie/550/recommendations?api_key=4a56b975740745ae46b79bb11a7271e4");
               ArrayList<String> result = movie.RecommendMovie(url);
               Response r = ResponseBuilder.movieRecomendationResponse(result);
               return r;
    }

    }