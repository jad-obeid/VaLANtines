package com.example.javafx.controllers;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

@Component
public class FirstController {
    @FXML
    private Button button;
    @FXML
    private AnchorPane starterId;

    @FXML
    private void openFuncTab(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        AnchorPane pane = loader.load();
        starterId.getChildren().setAll(pane);
    }
    public void initialize() {
    }
}
