package com.networks.project.server.handlers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.networks.project.server.functionality.ImageMerger;
import com.networks.project.server.responses.Response;
import com.networks.project.server.responses.ResponseBuilder;

import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;

public class ImageHandler {
    public static Response handleRequest(String request){
        Response r = processImage(request);
        return r;
    }
    private static BufferedImage stringToImage(String encodedImages) throws IOException{
        ArrayList<String> images = new ArrayList<String>(Arrays.asList(encodedImages.split(";")));
        String url = "/home/jad/Documents/networkprog/Testing/";

        //decode images
        byte[] decodedBytesImage1 = Base64.getDecoder().decode(images.get(0));
        byte[] decodedBytesImage2 = Base64.getDecoder().decode(images.get(1));
        BufferedImage img1 = ImageIO.read(new ByteArrayInputStream(decodedBytesImage1));
        BufferedImage img2 = ImageIO.read(new ByteArrayInputStream(decodedBytesImage2));

        //merge images into one
        BufferedImage mergedImg = ImageMerger.joinBufferedImage(img1, img2);
        int scaledw = (int) (mergedImg.getWidth()*1.2);
        int scaledh = (int) (mergedImg.getHeight()*1.2);
        mergedImg = Scalr.resize(mergedImg,Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,scaledw,scaledh,Scalr.OP_ANTIALIAS);
        int w = mergedImg.getWidth();
        int h = mergedImg.getHeight();
        
        //put heart over the image
        ClassLoader classLoader = ImageHandler.class.getClassLoader();
        URL heartImage = classLoader.getResource("pngegg.png");
        BufferedImage heartImg = ImageIO.read(heartImage);
        BufferedImage combined = new BufferedImage(heartImg.getWidth(), heartImg.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = combined.getGraphics();
        g.drawImage(mergedImg, 200, 220, null);
        g.drawImage(heartImg, 0, 0, null);

        return combined;
    }
    private static Response processImage(String request){
        BufferedImage img = null;
        try {
            img = stringToImage(request);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(img,"png",baos);
        } catch (IOException e) {
        }
        byte[] outputImgBuffer = baos.toByteArray();
        String outputImg = Base64.getEncoder().encodeToString(outputImgBuffer);
        Response response = ResponseBuilder.combinedImageResponse(outputImg);
        return response;
    }
}
