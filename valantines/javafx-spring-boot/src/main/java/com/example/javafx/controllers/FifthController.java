package com.example.javafx.controllers;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.example.javafx.client.Client;
import com.example.javafx.client.Request;
import com.example.javafx.client.RequestBuilder;
import com.sun.prism.paint.Color;
import java.awt.image.BufferedImage;
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
import javafx.scene.text.Text;

public class FifthController {
    Client client = Client.getClient();
    
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane movieIdeasId;
    @FXML
    private Text titleId;
    @FXML
    private Text overviewId;
    @FXML
    private ImageView imageId;
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/functionalities.fxml"));
        AnchorPane pane = loader.load();
        pane.setStyle("-fx-background-color: #ffffff");
        movieIdeasId.getChildren().setAll(pane);
    }
    @FXML
    private void getMovie(ActionEvent event){
        Request r = RequestBuilder.generateMovieRecommendation();
        String response = null;
        try {
        response = client.sendAndReceive(r);
        } catch (IOException e) {
            e.printStackTrace();
        }
        response = response.substring(response.indexOf(";")+1);
        String[] results = response.split(";");
        titleId.setText(results[0]);
        overviewId.setText(results[1]);

        BufferedImage c=null;
        try {
            URL url = new URL("https://image.tmdb.org/t/p/w500"+results[2]);
            c = ImageIO.read(url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Image image = SwingFXUtils.toFXImage(c, null);
        imageId.setImage(image);
    }

}
