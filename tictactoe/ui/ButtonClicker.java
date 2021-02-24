package ca.cmpt213.asn4.tictactoe.ui;

import ca.cmpt213.asn4.tictactoe.game.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Hakim Bashe, 301390647
 * CMPT 213, Fall 2020, A4
 * This is the Button Clicker Class
 * It fills up the board initially
 */
public class ButtonClicker implements EventHandler<ActionEvent> {
    private TicTacToe obj;

    //Use current board
    public ButtonClicker(TicTacToe obj) {
        this.obj = obj;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //Keep track of turn number
        obj.turnNumber = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                obj.Array[i][j] = 0;
            }
        }
        //Set all board values to nothing, and draw the grid
        obj.gameLabel.setText("");
        obj.drawGrid();
    }
}
