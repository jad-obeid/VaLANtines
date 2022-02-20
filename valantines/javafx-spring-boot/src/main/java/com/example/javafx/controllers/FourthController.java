package com.example.javafx.controllers;
import java.io.IOException;

import com.example.javafx.client.Client;
import com.example.javafx.client.Request;
import com.example.javafx.client.RequestBuilder;
import com.sun.prism.paint.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

@Component
public class FourthController {

    Client client = Client.getClient();
    // The FXML stuff
    @FXML
    private Button backButton;
    @FXML
    private AnchorPane lovePercentageId;
    @FXML
    private Button submitId;
    @FXML
    private TextField sname;
    @FXML  
    private TextField fname;
    @FXML
    private Text percentageId;
    @FXML 
    private Text descriptionId;
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/functionalities.fxml"));
        AnchorPane pane = loader.load();
        pane.setStyle("-fx-background-color: #ffffff");
        lovePercentageId.getChildren().setAll(pane);
    }
    @FXML
    private void generateCompatibility(ActionEvent event){
        Request r = RequestBuilder.generateCompatibility(sname.getText(), fname.getText());
        String response = null;
        try {
            response = client.sendAndReceive(r); 
        } catch (IOException e) {
            e.printStackTrace();
        }
        response = response.substring(response.indexOf(";")+1);
        String[] results = response.split(";");
        percentageId.setText(results[0]+"%");
        descriptionId.setText(results[1]);
    }
    

}
