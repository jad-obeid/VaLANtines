package com.example.javafx.client;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class RequestBuilder{
    public static Request generateMergePhotosRequest(File f1, File f2) throws IOException{
        byte[] f1Content = FileUtils.readFileToByteArray(f1);
        String f1String = Base64.getEncoder().encodeToString(f1Content);
        
        byte[] f2Content = FileUtils.readFileToByteArray(f2);
        String f2String = Base64.getEncoder().encodeToString(f2Content);
        ArrayList<String> images = new ArrayList<String>();
        images.add(f1String); images.add(f2String);

        Request  r = new Request(1,images);
        return r;
    }
    public static Request generateMovieRecommendation(){
        Request r= new Request(2,null);
        return r;
        }

    public static Request generateCompatibility(String sname,String fname){
        ArrayList<String> names=new ArrayList<>();
        names.add(sname);
        names.add(fname);
        Request r=new Request(3, names);
        return r;
    }    
}
