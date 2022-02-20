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
import javafx.scene.text.Text;
public class SignupController {
    Client client = Client.getClient();
    @FXML
    private AnchorPane signupId;
    @FXML
    private Button submit;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    @FXML
    private void signup(ActionEvent event) throws IOException{
        String usrname = username.getText();
        String pswrd = password.getText();
        String eml = email.getText();
        String result=null;
        Request r = RequestBuilder.generateSignUpRequest(usrname, eml, pswrd);
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
            signupId.getChildren().setAll(pane);
        }
    }
}
