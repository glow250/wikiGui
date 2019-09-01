package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class NewCreation {
    BorderPane creationTab;
    HBox search;
    HBox options;
    TableView<Line> lineTable;

    public BorderPane getCreationList(){
        if(creationTab == null){
            setUp();
            creationTab = new BorderPane();
            creationTab.setTop(search);
            creationTab.setCenter(lineTable);
            creationTab.setBottom(options);
        }
        return creationTab;
    }

    public void setUp(){
        searchSetup();
        lineViewSetup();
        optionsSetup();
    }

    public void searchSetup(){
        search = new HBox();
        Text searchPrompt = new Text("Term to Search: ");
        TextField searchInput = new TextField();
        Button searchButton = new Button("Search");
        search.setPadding(new Insets(10,10,10,10));
        search.setSpacing(10);
        search.getChildren().addAll(searchPrompt, searchInput, searchButton);
    }

    public void lineViewSetup(){
        //Number Column
        TableColumn<Line, Integer> numberColumn = new TableColumn<>("Number");
        numberColumn.setMinWidth(50);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        //Name Column
        TableColumn<Line, String> textColumn = new TableColumn<>("Text");
        textColumn.setMinWidth(450);
        textColumn.setCellValueFactory(new PropertyValueFactory<>("text"));

        lineTable = new TableView<>();
        lineTable.setItems(getLine());
        lineTable.getColumns().addAll(numberColumn, textColumn);
    }

    public void optionsSetup(){
        options = new HBox();

        Text linePrompt = new Text("How many lines: ");
        TextField lineInput = new TextField();

        Text namePrompt = new Text("Name of Creation: ");
        TextField nameInput = new TextField();

        Button searchButton = new Button("Create");

        options.setPadding(new Insets(10,10,10,10));
        options.setSpacing(10);

        options.getChildren().addAll(linePrompt, lineInput, namePrompt, nameInput, searchButton);
    }

    //Gets all are creations and returns list will connect to file later
    private ObservableList<Line> getLine(){
        ObservableList<Line> lines = FXCollections.observableArrayList();
        lines.add(new Line("Bananas are a berry.", 1));
        lines.add(new Line("Cats are felines.", 2));
        lines.add(new Line("Cars are used for transport.", 3));
        lines.add(new Line("JavaFx is used for making GUI's.", 4));
        return lines;
    }
}
