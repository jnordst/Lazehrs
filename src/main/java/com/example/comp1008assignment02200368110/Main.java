package com.example.comp1008assignment02200368110;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("lazehrs-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/lazehrs-logo.png")));
        Font.loadFont(getClass().getResourceAsStream("fonts/Eina02-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Eina02-SemiBold.ttf"), 14);
        stage.setTitle("Lazehrs");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}