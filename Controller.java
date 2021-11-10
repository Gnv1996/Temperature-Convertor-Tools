package com.example.myjavaapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField userInputField;
    @FXML
    public Button convertButton;
    private static final String C_To_F_Text="Celsius to Fahrenheit";
    private static final String F_To_C_Text="Fahrenheit to celsius";

    private Boolean isC_To_F=true;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().add(C_To_F_Text);
        choiceBox.getItems().add(F_To_C_Text);
        choiceBox.setValue(C_To_F_Text);
        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (t1.equals(C_To_F_Text)){
                    isC_To_F=true;

                }else {
                    isC_To_F=false;
                }

            }
        });


        convertButton.setOnAction(event ->{
            Convert();



        });


    
    }

    private void Convert() {
       String input= userInputField.getText();
       float enteredTemperature=0.0f;

       try{
           enteredTemperature=Float.parseFloat(input);


       } catch (Exception exception){
           warnUser();
           return;
       }

       float newTemperature=0.0f;
       if (isC_To_F) {
           newTemperature=(enteredTemperature*9/5)+32;
       }else {
           newTemperature=(enteredTemperature-32)*5/9;
       }
       display (newTemperature);
    }

    private void warnUser() {

        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature");
        alert.setContentText("Please Enter a Valid Temperature ");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit=isC_To_F? "F" : "C";
        System.out.println("The new Temperature is:"+newTemperature+unit);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The New Temperature is :" +newTemperature+unit);
        alert.show();
    }
}
