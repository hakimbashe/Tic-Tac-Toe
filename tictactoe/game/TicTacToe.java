package ca.cmpt213.asn4.tictactoe.game;

import ca.cmpt213.asn4.tictactoe.ui.ButtonClicker;
import ca.cmpt213.asn4.tictactoe.ui.ImageClick;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Hakim Bashe, 301390647
 * CMPT 213, Fall 2020, A4
 * This is the TicTacToe Class
 * It creates the game board, checks if the player has won diagonally, vertically, or horizontally
 * It also checks if the game has ended in a win or draw, and prints out messages accordingly
 */
public class TicTacToe extends Application {
    //Create the label and array and turn number
    public int Array[][] = new int[4][4];
    public int turnNumber = 0;
    public Label gameLabel = new Label("");

    //Play the game
    public static void main(String[] args) {
        launch(args);
    }

    //The board grid
    public GridPane boardGrid = new GridPane();

    //draw the entire board out
    public void drawGrid() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Image cell = new Image("file:src/ca/cmpt213/asn4/tictactoe/game/blank.png");
                ImageView cellSize = new ImageView(cell);
                cellSize.setFitHeight(100);
                cellSize.setFitWidth(100);
                boardGrid.add(cellSize, i, j);
                cellSize.addEventHandler(MouseEvent.MOUSE_CLICKED, new ImageClick(this));
            }
        }
    }

    //Set all the values to 0, so the board becomes empty
    public void endGame() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Array[i][j] = 0;
            }
        }
    }

    //Print out if player 1 wins
    public void playerXWins() {
        endGame();
        gameLabel.setText("Player 1 Wins!");
        boardGrid.add(gameLabel, 2, 4);
    }

    //Print out if player 2 wins
    public void playerYWins() {
        endGame();
        gameLabel.setText("Player 2 Wins!");
        boardGrid.add(gameLabel, 2, 4);
    }

    //Checks if the game is over every turn
    public void gameChecker() {
        /****** Checks if the game has been won Diagonally *************************/
        if ((Array[0][0] == Array[1][1]) && (Array[1][1] == Array[2][2]) && (Array[2][2] == Array[3][3])) {
            if (Array[0][0] == 1) {
                playerXWins();
            } else if (Array[0][0] == 2) {
                playerYWins();
            }
        }
        if ((Array[3][0] == Array[2][1]) && (Array[2][1] == Array[1][2]) && (Array[1][2] == Array[0][3])) {
            if (Array[3][0] == 1) {
                playerXWins();
            } else if (Array[3][0] == 2) {
                playerYWins();
            }
        }

        /****** Checks if the game has been won Vertically *************************/
        if ((Array[0][0] == Array[0][1]) && (Array[0][1] == Array[0][2]) && (Array[0][2] == Array[0][3])) {
            if (Array[0][0] == 1) {
                playerXWins();
            } else if (Array[0][0] == 2) {
                playerYWins();
            }
        }
        if ((Array[1][0] == Array[1][1]) && (Array[1][1] == Array[1][2]) && (Array[1][2] == Array[1][3])) {
            if (Array[1][0] == 1) {
                playerXWins();
            } else if (Array[1][0] == 2) {
                playerYWins();
            }
        }
        if ((Array[2][0] == Array[2][1]) && (Array[2][1] == Array[2][2]) && (Array[2][2] == Array[2][3])) {
            if (Array[2][0] == 1) {
                playerXWins();
            } else if (Array[2][0] == 2) {
                playerYWins();
            }
        }
        if ((Array[3][0] == Array[3][1]) && (Array[3][1] == Array[3][2]) && (Array[3][2] == Array[3][3])) {
            if (Array[3][0] == 1) {
                playerXWins();
            } else if (Array[3][0] == 2) {
                playerYWins();
            }
        }
        /****** Checks if the game has been won horizontally *************************/
        if ((Array[0][0] == Array[1][0]) && (Array[1][0] == Array[2][0]) && (Array[2][0] == Array[3][0])) {
            if (Array[0][0] == 1) {
                playerXWins();
            } else if (Array[0][0] == 2) {
                playerYWins();
            }
        }
        if ((Array[0][1] == Array[1][1]) && (Array[1][1] == Array[2][1]) && (Array[2][1] == Array[3][1])) {
            if (Array[0][1] == 1) {
                playerXWins();
            } else if (Array[0][1] == 2) {
                playerYWins();
            }
        }
        if ((Array[0][2] == Array[1][2]) && (Array[1][2] == Array[2][2]) && (Array[2][2] == Array[3][2])) {
            if (Array[0][2] == 1) {
                playerXWins();
            } else if (Array[0][2] == 2) {
                playerYWins();
            }
        }
        if ((Array[0][3] == Array[1][3]) && (Array[1][3] == Array[2][3]) && (Array[2][3] == Array[3][3])) {
            if (Array[0][3] == 1) {
                playerXWins();
            } else if (Array[0][3] == 2) {
                playerYWins();
            }
        }
    }

    //Checks if the game will end in a draw
    //1 means x, 2 means y
    public void noWinner() {
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Array[i][j] == 1) {
                    counter++;
                }
                if (Array[i][j] == 2) {
                    counter++;
                }
            }
        }
        //If counter is 16, all the spots must be filled therefore a draw
        if (counter == 16) {
            gameLabel.setText("Game ends in a Draw!");
            boardGrid.add(gameLabel, 2, 4);
        }
    }

    //Checks if the game has ended
    public void checkEveryTurn() {
        gameChecker();
        noWinner();
    }

    //Starts the game
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tic Tac Toe");
        Button reset = new Button("New Game");
        reset.setOnAction(new ButtonClicker(this));
        reset.setMaxSize(100, 50);
        boardGrid.add(reset, 3, 6);
        boardGrid.setHgap(10);
        boardGrid.setVgap(10);
        boardGrid.setAlignment(Pos.BOTTOM_CENTER);
        drawGrid();
        boardGrid.setPadding(new Insets(10));
        Scene newScene = new Scene(boardGrid, 600, 600);
        stage.setScene(newScene);
        stage.show();
    }
}

