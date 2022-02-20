package com.example.javafx.client;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Request {
    private int type;
    private ArrayList<String> inputs;
    
    public Request(int type, ArrayList<String> inputs){
        this.type = type;
        this.inputs = inputs;
    }

    public int getType(){
        return this.type;
    }
    
    public ArrayList<String> getInputs(){
        return this.inputs;
    }

    public void setType(int type){
        this.type = type;
    }

    public void setInputs(ArrayList<String> inputs){
        this.inputs = inputs;
    }
    public String toString(){
        if (inputs!= null)
            return Integer.toString(type)+";"+ inputs.stream().collect(Collectors.joining(";"));
        return Integer.toString(type);
    }
}
