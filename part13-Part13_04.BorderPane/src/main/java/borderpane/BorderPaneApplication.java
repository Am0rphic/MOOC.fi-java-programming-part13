package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        BorderPane bpane = new BorderPane();
        bpane.setTop(new Label("NORTH"));
        bpane.setRight(new Label("EAST"));
        bpane.setBottom(new Label("SOUTH"));
        
        Scene window = new Scene(bpane);
        stage.setScene(window);
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
    }

}
