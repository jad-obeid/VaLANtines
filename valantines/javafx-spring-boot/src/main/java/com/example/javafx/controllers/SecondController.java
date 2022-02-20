package com.example.javafx.controllers;

import java.io.IOException;

import com.example.javafx.client.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class SecondController {

    @FXML
    private Button imageLoveId;
    @FXML
    private Button lovePercentageId;
    @FXML
    private Button movieRecommendationId;
    @FXML
    private AnchorPane functionalityId;
    @FXML
    private void goToImageMerger(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/loversImage.fxml"));
        AnchorPane pane = loader.load();
        functionalityId.getChildren().setAll(pane);
    }
    @FXML
    private void goToCompatibility(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/lovaPercentage.fxml"));
        AnchorPane pane = loader.load();
        functionalityId.getChildren().setAll(pane);
    }
    @FXML
    private void goToMovieRecom(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/movieRecommender.fxml"));
        AnchorPane pane = loader.load();
        functionalityId.getChildren().setAll(pane);
    }
}
