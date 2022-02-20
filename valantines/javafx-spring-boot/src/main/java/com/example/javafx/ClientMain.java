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
		
	}

}
