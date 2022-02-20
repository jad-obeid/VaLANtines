package com.example.javafx;

import javafx.application.Application;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.example.javafx.client.Client;
import com.example.javafx.client.Request;
import com.example.javafx.client.RequestBuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientMain {

	public static void main(String[] args) throws IOException {
		Application.launch(JavafxApplication.class, args);
		//Client client = new Client("localhost",12345);
		// File f1 = new File("/home/jad/Documents/networkprog/NetworkProg_project1/valantines/Server/src/main/resources/test.png");
		// File f2 = new File("/home/jad/Documents/networkprog/NetworkProg_project1/valantines/Server/src/main/resources/test.png");
		// Request r = RequestBuilder.generateMergePhotosRequest(f1, f2);
		// String image = client.sendAndReceive(r);
		// byte[] imagebuff = Base64.getDecoder().decode(image.substring(2));
		// InputStream is = new ByteArrayInputStream(imagebuff);
		// BufferedImage bi = ImageIO.read(is);
		// ImageIO.write(bi,"png",new File("/home/jad/Documents/networkprog/Testing/img.png"));
	//	Request rr = RequestBuilder.generateMovieRecommendation();
	//	System.out.println(client.sendAndReceive(rr));
	   // Request rrr=RequestBuilder.generateCompatibility("heba", "jad");
		//System.out.println(client.sendAndReceive(rrr));
	}

}
