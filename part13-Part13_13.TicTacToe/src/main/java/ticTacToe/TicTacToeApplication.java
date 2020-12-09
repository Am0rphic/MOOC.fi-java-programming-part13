package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {
    private int playerState; //used to swap between player X and player O
    private Label labelState; //label
    private int[][] boardState; //internal 2d array of game state
    private String winner; //maybe useless
    private Stage stage; //put here because cant use in methods otherwise i think?
    private BorderPane layout = new BorderPane();
    @Override
    public void start(Stage stage) {
        //define starting stuff
     //   BorderPane layout = new BorderPane();
        this.playerState=1;
        //maybe listener?
        layout.setPrefSize(300, 200);
        labelState = new Label("Turn: X");
        layout.setTop(labelState);
        
        //start up board state
        int[][] array = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };     
        boardState=array;
       
        //creation of 3x3 grid and dumb button creation and func. definition
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(10);
        Button button1 = new Button();
        pressButton(button1, 0, 0);
    //    updateBoardState(button1.getText(), 0, 0);
        Button button2 = new Button();
        pressButton(button2, 0, 1);
    //    updateBoardState(button2.getText(), 0, 1);
        Button button3 = new Button();
        pressButton(button3, 0, 2);
    //    updateBoardState(button3.getText(), 0, 2);
        Button button4 = new Button();
        pressButton(button4, 1, 0);
    //    updateBoardState(button4.getText(), 1, 0);
        Button button5 = new Button();
        pressButton(button5, 1, 1);
    //    updateBoardState(button5.getText(), 1, 1);
        Button button6 = new Button();
        pressButton(button6, 1, 2);
    //    updateBoardState(button6.getText(), 1, 2);
        Button button7 = new Button();
        pressButton(button7, 2, 0);
    //    updateBoardState(button7.getText(), 2, 0);
        Button button8 = new Button();
        pressButton(button8, 2, 1);
    //    updateBoardState(button8.getText(), 2, 1);
        Button button9 = new Button();
        pressButton(button9, 2, 2);
    //    updateBoardState(button9.getText(), 2, 2);
             
        grid.add(button1, 0, 0);
        grid.add(button2, 0, 1);
        grid.add(button3, 0, 2);
        grid.add(button4, 1, 0);
        grid.add(button5, 1, 1);
        grid.add(button6, 1, 2);
        grid.add(button7, 2, 0);
        grid.add(button8, 2, 1);
        grid.add(button9, 2, 2);


            
        layout.setCenter(grid);
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

    }
    
    //swap players on successfull button click
    private void swapPlayer() {
        if (this.playerState==1) {
            this.playerState=2;
            this.labelState.setText("Turn: O");
        }   else if (this.playerState==2) {
            this.playerState=1;
            this.labelState.setText("Turn: X");
        }
    }
    
    //if button has no value, press and set X/O text and .update array board state
    private void pressButton(Button button, int r, int c) {
        
        button.setOnAction((event)-> {
            if (button.getText().isEmpty()) {
                if (this.playerState==1) {
                    button.setText("X");
                    swapPlayer();
                }   else if (this.playerState==2) {
                    button.setText("O");
                    swapPlayer();
                }     
            }
//            if (button.getText().equals("X") || button.getText().equals("O")) {
//                button.setText("");
//            }
            updateBoardState(button.getText(), r, c);

        });
    }
    //update the internal board state (integers) and check if we have a winner already
    private void updateBoardState(String buttonText, int r, int c) {
        if (buttonText.equals("X")) {
            boardState[r][c] = 1;
        }
        if (buttonText.equals("O")) {
            boardState[r][c] = 2;
        }
//        if (buttonText.equals("")) {
//            boardState[r][c] = 0;
//        }
        if (checkWin()==true) {
            //if winner available, transition to scene2 and end game
            StackPane winnerPane = new StackPane();
            winnerPane.setAlignment(Pos.CENTER);
            winnerPane.setPrefSize(300, 200);
           // winnerPane.getChildren().add(new Label("Winner is :"+this.winner));
         //  winnerPane.getChildren().add(new Label("The end!"));
           labelState.setText("The end!");
        //    stage.setScene(new Scene(winnerPane));
            layout.setCenter(winnerPane);
        }
    }
    //thought process - stringbuilder & check for 111,222 etc. - changed into boolean calls
    
    private boolean checkWin() { //run through all winning conditions
        if (checkRow(0) || checkRow(1) || checkRow(2) || checkCol(0) || checkCol(1) || checkCol(2) || checkDiag()) {
            return true;
        }
        return false;
    }
    private boolean checkRow(int row) { //check all rows for win
    
        if (boardState[row][0]==boardState[row][1] && boardState[row][1]==boardState[row][2]) {
            if (boardState[row][0]==1) {
                this.winner="O"; //O and X swapped because the winning click changes internal current player
            }   else {
                this.winner="X";
            }
            if (boardState[row][0]==0) {
                return false;
            }
            return true;
        }  
        return false;
    }    
    private boolean checkCol(int col) { //check all columns for win
            if (boardState[0][col]==boardState[1][col] && boardState[1][col]==boardState[2][col]) {
                if (boardState[0][col]==1) {
                    this.winner="O"; //O and X swapped because the winning click changes internal current player
                }   else {
                    this.winner="X";
                }
                if (boardState[0][col]==0) {
                    return false;
                }
                return true;
            }
   
        return false;        
    }
    private boolean checkDiag(){ //check 2 diags for win
        if(boardState[1][1]==0) {
            return false;
        }
        if (boardState[0][0]==boardState[1][1] && boardState[1][1]==boardState[2][2]) {
            if (boardState[1][1]==1) {
                this.winner="X";
            }   else {
                this.winner="O";
            }
            return true;
        }
        if (boardState[0][2]==boardState[1][1] && boardState[1][1]==boardState[2][0]) {
            if (boardState[1][1]==1) {
                this.winner="X";
            }   else {
                this.winner="O";
            }
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
