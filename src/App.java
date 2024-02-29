import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

class MyTableModel extends DefaultTableModel {
    public MyTableModel(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}

class MyTable extends JTable {
    public MyTable(TableModel tableModel) { super(tableModel); }
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        JComponent jc = (JComponent)super.prepareRenderer(renderer, row, column);
        jc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        return jc;
    }
}

class Piece {
    public static final int EMPTY = 0;
    public static final int NOUGHT = 1;
    public static final int CROSS = 2;
    public static final String[] symbol = {"", "O", "X"};
}

class Board {
    private int[][] square = new int[3][3];
    public int getPiece(int i, int j) {
        return square[i][j];
    }
    public void setPiece(int i, int j, int piece) {
        square[i][j] = piece;
    }
    public Board() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                square[i][j] = Piece.EMPTY;
    }
}

public class App {
    private JFrame frame = null;
    private JTable table = null;
    private DefaultTableModel tableModel = null;
    private TableColumnModel tableColumnModel = null;
    private Board board = null;
    private void updateView() {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                tableModel.setValueAt(Piece.symbol[board.getPiece(i, j)], i, j);
            }
    }
    public App() {
        board = new Board();
        frame = new JFrame("Noughts and Crosses");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table = new MyTable(tableModel = new MyTableModel(3,3));
        tableColumnModel = table.getColumnModel();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(256);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 8));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int colIdx = 0; colIdx < 3; colIdx++) {
            TableColumn col = tableColumnModel.getColumn(colIdx);
            col.setPreferredWidth(256);
            col.setCellRenderer(centerRenderer);
        }
        table.setBackground(new Color(0,128,0));
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);
        table.setCellSelectionEnabled(false);
        table.setFont(new Font("Arial", Font.PLAIN, 192));
        frame.add(table);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        updateView();
        frame.setVisible(true);
    }
}
