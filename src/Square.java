import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private Image[] X_O;
    private boolean isWinningSquare;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col) {
        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        X_O = new Image[2];
        X_O[0] = new ImageIcon("Resources/X.png").getImage();
        X_O[1] = new ImageIcon("Resources/O.png").getImage();
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    public void draw(Graphics g, TicTacToeViewer t) {
        if (isWinningSquare) {
            g.drawRect(250 + col*167 + 6*col, 250 + row*167 + 6*row + 22, 161, 161);
            g.setColor(Color.green);
            g.fillRect(250 + col*167 + 6*col, 250 + row*167 + 6*row + 22, 161, 161);
        }
        if (getMarker().equals("X")) {
            g.drawImage(X_O[0], 250 + col*167 + 6*col, 250 + row*167 + 6*row + 22, 155, 155, t);
        } else {
            g.drawImage(X_O[1], 250 + col*167 + 6*col, 250 + row*167 + 6*row + 22, 155, 155, t);
        }
    }
    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }
}