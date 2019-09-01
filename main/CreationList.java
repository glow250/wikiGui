package main;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreationList {

    private TableView<Creation> creationTable;
    private VBox vBox;
    private HBox hBox;


    public VBox getCreationList(){
        if(vBox == null){
            setUp();
            vBox = new VBox();
            vBox.getChildren().addAll(creationTable, hBox);
        }
        return vBox;
    }

    private void setUp(){
        //Number Column
        TableColumn<Creation, Integer> numberColumn = new TableColumn<>("Number");
        numberColumn.setMinWidth(50);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        //Name Column
        TableColumn<Creation, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(450);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        creationTable = new TableView<>();
        creationTable.setItems(getCreation());
        creationTable.getColumns().addAll(numberColumn, nameColumn);

        Button playButton = new Button("play");
        playButton.setOnAction(e -> playButtonClicked());
        Button deleteButton = new Button("delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(playButton, deleteButton);
    }


    //Gets all are creations and returns list will connect to file later
    private ObservableList<Creation> getCreation(){
        ObservableList<Creation> creations = FXCollections.observableArrayList();
        creations.add(new Creation("Banana", 1));
        creations.add(new Creation("Cat", 2));
        creations.add(new Creation("Car", 3));
        creations.add(new Creation("JavaFx", 4));
        return creations;
    }

    private void playButtonClicked(){

    }

    private void deleteButtonClicked(){
        ObservableList<Creation> creationSelected, allCreations;
        allCreations = creationTable.getItems();
        creationSelected = creationTable.getSelectionModel().getSelectedItems();

        creationSelected.forEach(allCreations::remove);
        System.out.println(creationSelected);
    }
}
