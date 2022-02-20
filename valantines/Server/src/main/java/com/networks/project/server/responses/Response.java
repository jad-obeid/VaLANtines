package com.networks.project.server.responses;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Response {
    private int type;
    private ArrayList<String> outputs;

    public Response(int type, ArrayList<String> outputs){
        this.type = type;
        this.outputs = outputs;
    }

    public String toString(){
        return Integer.toString(type)+";"+ outputs.stream().collect(Collectors.joining(";"));
    }

}