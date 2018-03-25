package com.bwieckowski.toolbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent menu = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setTitle("Toolbox");
        primaryStage.setScene(new Scene(menu));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
