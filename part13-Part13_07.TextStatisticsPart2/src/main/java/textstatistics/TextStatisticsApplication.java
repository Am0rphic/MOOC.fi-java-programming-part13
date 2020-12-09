package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
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
        TextArea text = new TextArea();
        bordPane.setCenter(text);
        HBox bot = new HBox();
        Label letters = new Label("Letters: ");
        Label wordsLabel = new Label("Words: ");
        Label longestWord = new Label("The longest word is: ");        
        bot.getChildren().addAll(letters, wordsLabel,longestWord);
        
        bordPane.setBottom(bot);
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int chars = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((w1, w2) -> w2.length() - w1.length())
                    .findFirst()
                    .get();
            letters.setText("Letters: "+chars);
            wordsLabel.setText("Words: "+words);
            longestWord.setText("The longest word is: "+longest);
            
        });

        

       

        bot.setSpacing(10);
        
        Scene view = new Scene(bordPane);
        
        stage.setScene(view);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
