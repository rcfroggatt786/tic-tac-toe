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
public class App {
    private JFrame frame = null;
    private JTable table = null;
    private DefaultTableModel tableModel = null;
    private TableColumnModel tableColumnModel = null;
    public App() {
        frame = new JFrame("Noughts and Crosses");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table = new JTable(tableModel = new MyTableModel(3,3));
        tableColumnModel = table.getColumnModel();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(256);
        table.setIntercellSpacing(new Dimension(8,8));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int colIdx = 0; colIdx < 3; colIdx++) {
            TableColumn col = tableColumnModel.getColumn(colIdx);
            col.setPreferredWidth(256);
            col.setCellRenderer(centerRenderer);
        }

        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);
        table.setCellSelectionEnabled(false);
        table.setFont(new Font("Arial", Font.PLAIN, 192));
        frame.add(table);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        tableModel.setValueAt("O",1,1);
        tableModel.setValueAt("X",1,2);
    }
}
