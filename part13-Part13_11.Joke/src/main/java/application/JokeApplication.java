package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        BorderPane layout = new BorderPane();
        
        HBox topMenu = new HBox();
        topMenu.setPadding(new Insets(20, 20, 20, 20));        
        topMenu.setSpacing(10);
        
        Button first = new Button("Joke");
        Button second = new Button("Answer");
        Button third = new Button("Explanation");

        topMenu.getChildren().addAll(first,second,third);
        layout.setTop(topMenu);
        
        
        StackPane layout1 = new StackPane();
        layout1.getChildren().add(new Label("What do you call a bear with no teeth?"));
        layout1.setAlignment(Pos.CENTER);
        layout1.setPrefSize(300, 200);
        
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(new Label("A gummy bear."));
        layout2.setAlignment(Pos.CENTER);
        layout2.setPrefSize(300, 200);
        
        StackPane layout3 = new StackPane();
        layout3.getChildren().add(new Label("gummy bears have to teeth, funny"));
        layout3.setAlignment(Pos.CENTER);
        layout3.setPrefSize(300, 200);
        
        first.setOnAction((event)-> {
            layout.setCenter(layout1);
        });
        second.setOnAction((event)-> {
            layout.setCenter(layout2);
        });
        third.setOnAction((event)-> {
            layout.setCenter(layout3);
        });
        
        layout.setCenter(layout1);
        Scene window = new Scene(layout);
        stage.setScene(window);
        stage.show();
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
