package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        
        
        //implement first scene
        Label text1 = new Label("Enter your name and start");
        TextField text2 = new TextField();
        Button firstButton = new Button("Start");        
        GridPane pane = new GridPane();
        pane.add(text1, 0, 0);
        pane.add(text2, 0, 1);
        pane.add(firstButton, 0, 2);
        pane.setPrefSize(300, 200);
        pane.setAlignment(Pos.CENTER);
        pane.setVgap(15);
        pane.setHgap(15);
        
        Scene firstScene = new Scene(pane);        
        
        //implement second scene
        StackPane welcome = new StackPane();
        Label welcomeText = new Label("Welcome "+text2.getText()+"!");
        welcome.setPrefSize(300, 200);
        welcome.getChildren().add(welcomeText);
        welcome.setAlignment(Pos.CENTER);
        Scene secondScene = new Scene(welcome);
        
        
        //1 button
        firstButton.setOnAction((event) -> {
            welcomeText.setText("Welcome "+text2.getText()+"!");
            stage.setScene(secondScene);
        });

   
        
        stage.setScene(firstScene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
