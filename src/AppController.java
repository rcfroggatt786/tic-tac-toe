import java.awt.*;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.*;



public class AppController {
    private boolean computersTurn = false;
    private void updateView() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                tableModel.setValueAt(Piece.symbol[board.getPiece(i, j)], i, j);
            }
    }
    private void computerPlay() {
        Outer:
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board.getPiece(i,j) == Piece.EMPTY) {
                    board.setPiece(i, j, Piece.NOUGHT);
                    break Outer;
                }
            }
        }
        computersTurn = false;
    }
    public AppController() {
    }
}
