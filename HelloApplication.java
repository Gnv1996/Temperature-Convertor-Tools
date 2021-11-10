package com.example.myjavaapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class HelloApplication extends Application {


    public static void main(String[]args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        VBox rootnode=loader.load();
        MenuBar menuBar=createMenu();
        rootnode.getChildren().add(0,menuBar);


        Scene scene = new Scene(rootnode);
        stage.setTitle("Temperature Convertor Tool");
        stage.setScene(scene);
        stage.show();




    }
    private MenuBar createMenu(){
        // Menu Item
        Menu fileMenu=new Menu("File");
        MenuItem newMenuItem=new MenuItem("New");
        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("New Menu Item Clicked");
            }
        });
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem quitMenuItem=new MenuItem("Quit");
        quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
                System.exit(0);
            }
        });
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        //Help Menu
        Menu helpMenu=new Menu("Help");
        MenuItem aboutApp=new MenuItem("About");
        aboutApp.setOnAction(actionEvent -> aboutApp());// using lambda
        helpMenu.getItems().addAll(aboutApp);
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;

    }

    private void aboutApp() {
        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My Desktop Application");
        alertDialog.setHeaderText("Learning Of Java");
        alertDialog.setContentText("I am just a beginner but soon in pro and start java developing game");
        ButtonType yesBtn=new ButtonType("Yes");
        ButtonType noBtn=new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
       Optional<ButtonType> clickedBtn=alertDialog.showAndWait();
       if (clickedBtn.isPresent() && clickedBtn.get()==yesBtn){
           System.out.println("Yes button was clicked!");
       }else {
           System.out.println("No button was clicked!");

       }


    }
}