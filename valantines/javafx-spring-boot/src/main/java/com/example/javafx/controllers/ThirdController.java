package com.example.javafx.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.example.javafx.client.Client;
import com.example.javafx.client.Request;
import com.example.javafx.client.RequestBuilder;
import com.sun.prism.paint.Color;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

@Component
public class ThirdController {
    Client client = Client.getClient();
    private File path1;
    private File path2;
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane imageMergerId;
    @FXML
    private Button image1Id;
    @FXML 
    private Button imageId2;
    @FXML 
    private Button submitId;
    @FXML
    private ImageView imageViewId;
    @FXML
    
    private void goBack(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/functionalities.fxml"));
        AnchorPane pane = loader.load();
        pane.setStyle("-fx-background-color: #ffffff");
        imageMergerId.getChildren().setAll(pane);
    }
    
    @FXML
    private void uploadImage1(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = (Stage) imageMergerId.getScene().getWindow();
        path1 = fileChooser.showOpenDialog(stage);
        image1Id.setText(path1.getName());
    }
    @FXML
    private void uploadImage2(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        Stage stage = (Stage) imageMergerId.getScene().getWindow();  
        path2 = fileChooser.showOpenDialog(stage);
        imageId2.setText(path2.getName());
    }
    @FXML
    private void generateImage(ActionEvent event){
        String response=null;
        try {
            Request r= RequestBuilder.generateMergePhotosRequest(path1, path2);
            response= client.sendAndReceive(r);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response=response.substring(2);
        byte[] decodedimage = Base64.getDecoder().decode(response);
        InputStream is = new ByteArrayInputStream(decodedimage);
        BufferedImage img=null;
		try {
             img = ImageIO.read(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Image image = SwingFXUtils.toFXImage(img, null);
        imageViewId.setImage(image);
    }
    public void initialize() {
    }
}