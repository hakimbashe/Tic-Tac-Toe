package ca.cmpt213.asn4.tictactoe.ui;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import ca.cmpt213.asn4.tictactoe.game.TicTacToe;

/**
 * @author Hakim Bashe, 301390647
 * CMPT 213, Fall 2020, A4
 * This is the Image Click Class
 * It allows the user to interact with the game board by clicking on various squares
 * If the turn is an even, put an x otherwise an 0
 */
public class ImageClick implements EventHandler<MouseEvent> {
    private TicTacToe obj;

    //Use the current game board
    public ImageClick(TicTacToe obj) {
        this.obj = obj;
    }

    //Get the current location
    //Get the row and collumn
    //Put the x or o depending on the turn number
    @Override
    public void handle(MouseEvent mouseEvent) {
        ImageView cell = (ImageView) mouseEvent.getSource();
        int collumn = GridPane.getColumnIndex(cell);
        int row = GridPane.getRowIndex(cell);
        if (obj.turnNumber % 2 == 0) {
            ((ImageView) mouseEvent.getSource()).setImage(new Image("file:src/ca/cmpt213/asn4/tictactoe/game/x.png"));
            obj.turnNumber++;
            obj.Array[row][collumn] = 1;
            obj.checkEveryTurn();
        } else {
            ((ImageView) mouseEvent.getSource()).setImage(new Image("file:src/ca/cmpt213/asn4/tictactoe/game/o.png"));
            obj.turnNumber++;
            obj.Array[row][collumn] = 2;
            obj.checkEveryTurn();
        }
    }

}