package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class MultipleViews extends Application {
    
    @Override
    public void start(Stage stage) {
        
        
        //implement first scene
        BorderPane pane = new BorderPane();
        pane.setTop(new Label("First view!"));
        Button firstButton = new Button("To the second view");
        pane.setCenter(firstButton);
        Scene firstScene = new Scene(pane);        
        
        //implement second scene
        VBox vbox = new VBox();
        Button secondButton = new Button("To the third view!");
        vbox.getChildren().addAll(secondButton, new Label("Second view!"));
        Scene secondScene = new Scene(vbox);
        
        
        //implement third scene
        GridPane grid = new GridPane();
        Label text1 = new Label("Third view!");
        Button thirdButton = new Button("To the first view!");
        grid.add(text1, 0, 0);
        grid.add(thirdButton, 1,1);
        Scene thirdScene = new Scene(grid);
        
        //1 button
        firstButton.setOnAction((event) -> {
            stage.setScene(secondScene);
        });
        //2 button
        secondButton.setOnAction((event) -> {
            stage.setScene(thirdScene);            
        });
        //3 button
        thirdButton.setOnAction((event) -> {
            stage.setScene(firstScene);
        });       
        
        stage.setScene(firstScene);
        stage.show();
        
    }
    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
