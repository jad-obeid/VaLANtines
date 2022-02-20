package com.example.javafx.controllers;

import java.io.IOException;

import com.example.javafx.client.Client;
import com.example.javafx.client.Request;
import com.example.javafx.client.RequestBuilder;

import org.springframework.expression.spel.CodeFlow.ClinitAdder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {
    Client client = Client.getClient();
    @FXML
    private Button submit;
    @FXML
    private AnchorPane loginId;
    @FXML
    private Button signup;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public void goToSignup(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signup.fxml"));
        AnchorPane pane = loader.load();
        loginId.getChildren().setAll(pane);
    }

    @FXML
    public void onSubmit(ActionEvent event) throws IOException{
        String usrname = username.getText();
        String pswrd = password.getText();
        Request r = RequestBuilder.generateSignInRequest(usrname, pswrd);
        String result=null;
        try {
            result = client.sendAndReceive(r);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        result = result.substring(2);
        System.out.println(result);
        if(result.equals("success")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/functionalities.fxml"));
            AnchorPane pane = loader.load();
            loginId.getChildren().setAll(pane);
        }
    }
}
