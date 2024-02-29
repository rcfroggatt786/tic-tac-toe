import java.util.ArrayList;

class Board {
    public static final byte EMPTY = 0;
    public static final byte NOUGHT = 1;
    public static final byte CROSS = 2;
    private byte[][] square = new byte[3][3];
    public byte getPiece(byte i, byte j) {
        return square[i][j];
    }
    public void setPiece(byte i, byte j, byte piece) {
        square[i][j] = piece;
    }
    public Board() {
        for(byte i = 0; i < 3; i++)
            for(byte j = 0; j < 3; j++)
                square[i][j] = EMPTY;
    }
}

class Coord {
    public byte x = 0;
    public byte y = 0;
    public Coord() {
    }
    public Coord(byte x, byte y) {
        this.x = x;
        this.y = y;
    }
}

class PositionEval {
    public enum Result {
        STILLPLAYING, CROSSESWON, NOUGHTSWON, GAMEDRAWN
    };
    public Result winner = Result.STILLPLAYING;
    public Coord[] winningLine = null;
    public PositionEval(Result winner, Coord[] winningLine) {
        this.winner = winner;
        this.winningLine = winningLine;
    }
}

public class GameModel {
    public static final byte GAMEOVER = 0;
    public static final byte COMPUTERTURN = 1;
    public static final byte PLAYERTURN = 2;
    private Board board = null;
    private byte playerPiece = Board.EMPTY;
    private byte computerPiece = Board.EMPTY;
    private byte whoseTurn = GAMEOVER;
    private Coord lastMove = null;
    public GameModel() {
        board = new Board();
        playerPiece = Board.CROSS;
        computerPiece = Board.NOUGHT;
        whoseTurn = PLAYERTURN;
    }
    public PositionEval evaluatePosition() {
        if(lastMove == null) return new PositionEval(PositionEval.Result.STILLPLAYING, null);
        
        return new PositionEval();
    }
}
