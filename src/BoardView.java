import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.MouseListener;

class BoardViewTableModel extends DefaultTableModel {
    public BoardViewTableModel(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}

class BoardViewTable extends JTable {
    public BoardViewTable(TableModel tableModel) { super(tableModel); }
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        JComponent jc = (JComponent)super.prepareRenderer(renderer, row, column);
        jc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        return jc;
    }
}

public class BoardView {
    private JFrame frame = null;
    private JTable table = null;
    private DefaultTableModel tableModel = null;
    private TableColumnModel tableColumnModel = null;
    public BoardView() {

    }
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
    MouseListener[] mouseListeners = table.getMouseListeners();
        for(MouseListener mouseListener : mouseListeners) {
        table.removeMouseListener(mouseListener);
    }
        table.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int i = table.rowAtPoint(evt.getPoint());
            int j = table.columnAtPoint(evt.getPoint());
            if (i >= 0 && j >= 0 && !computersTurn) {
                board.setPiece(i, j, Piece.CROSS);
                computersTurn = true;
                computerPlay();
                updateView();
            }
        }
    });

}
