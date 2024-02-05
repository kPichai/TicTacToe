import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class TicTacToeViewer extends JFrame {
    private Image[] X_O;
    private Image background;

    private final int WINDOW_TITLE_HEIGHT = 23;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 1000 + WINDOW_TITLE_HEIGHT;
    private TicTacToe t;

    public TicTacToeViewer(TicTacToe t) {
        this.t = t;
        X_O = new Image[2];
        X_O[0] = new ImageIcon("Resources/X.png").getImage();
        X_O[1] = new ImageIcon("Resources/O.png").getImage();
        background = new ImageIcon("Resources/pixil-frame-0.png").getImage();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image[] getX_O() {
        return X_O;
    }

    public void paint(Graphics g) {
        g.drawImage(background, 0, WINDOW_TITLE_HEIGHT, this);
        Square[][] board = t.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k].getMarker().equals("X") || board[i][k].getMarker().equals("O")) {
                    board[i][k].draw(g, this);
                }
            }
        }
        if (t.getGameOver() && !t.checkTie()) {
            g.setFont(new Font("Serif", Font.BOLD, 30));
            g.setColor(Color.BLACK);
            g.drawString(t.getWinner() + " is the winner!", 375, 830);
        }
        if (t.getGameOver() && t.checkTie()) {
            g.setFont(new Font("Serif", Font.BOLD, 30));
            g.setColor(Color.BLACK);
            g.drawString("It's a tie!", 375, 830);
        }
    }
}