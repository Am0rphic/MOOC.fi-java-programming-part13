package myFirstApplication;


import javafx.application.Application;
import javafx.stage.Stage;

public class MyFirstApplication extends Application{
    
    @Override
    public void start(Stage test) {
        test.setTitle("My first application");
     //   test.setAlwaysOnTop(true);
        test.show();
    }

    public static void main(String[] args) {
        launch(MyFirstApplication.class);
    }

}
