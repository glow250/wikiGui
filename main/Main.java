package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    CreationList creations;
    NewCreation newCreation;
    BorderPane layout;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("wiki speak");
        layout = new BorderPane();

        creations = new CreationList();
        newCreation = new NewCreation();

        Button newButton = new Button("new");
        newButton.setOnAction(e -> layout.setCenter(newCreation.getCreationList()));
        Button creationButton = new Button("creations");
        creationButton.setOnAction(e -> layout.setCenter(creations.getCreationList()));

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(creationButton, newButton);

        MenuBar menuBar = new MenuBar();
        layout.setTop(hBox);
        layout.setCenter(creations.getCreationList());
        scene = new Scene(layout, 600, 400);

        window.setScene(scene);
        window.show();
    }
}
