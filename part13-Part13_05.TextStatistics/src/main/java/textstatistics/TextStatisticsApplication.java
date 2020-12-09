package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        BorderPane bordPane = new BorderPane();
        
        bordPane.setCenter(new TextArea());
        HBox bot = new HBox();
        bot.getChildren().add(new Label("Letters: 0"));
        bot.getChildren().add(new Label("Words: 0"));  
        bot.getChildren().add(new Label("The longest word is:"));
        bot.setSpacing(10);
        
        bordPane.setBottom(bot);
        
        Scene view = new Scene(bordPane);
        
        stage.setScene(view);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
