
public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;

    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;
        int maxVal = Math.max(rows, columns); // how many times we iterate
        firstRow = new MatrixRow();
        firstColumn = new MatrixColumn();
        MatrixRow currentRow = firstRow;
        MatrixColumn currentColumn = firstColumn;

        for (int i = 0; i < maxVal; i++) {
            if (i < rows) {
                currentRow.setNext(new MatrixRow());
                currentRow = currentRow.getNext();
            }
            if (i < columns) {
                currentColumn.setNext(new MatrixColumn());
                currentColumn = currentColumn.getNext();
            }
        }
    }

    public void insert(int row, int column, int value) {
        MatrixRow rr = getRow(row); 
        MatrixColumn rc = getColumn(column);
        ValueNode node =  new ValueNode(row, column, value); // to insert
        rr.insert(node);
        rc.insert(node);

    }

    public MatrixRow getRow(int position) {
        MatrixRow current = firstRow;
        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }
        return current;
    }

    public MatrixColumn getColumn(int position) {
        MatrixColumn current = firstColumn;
        for (int i = 1; i < position; i++) {
            current = current.getNext();
        }
        return current;
    }

    public int getValue(int row, int column) {
        return 0;
    }

    public void print() {

    }

    public SparseMatrix transpose() {
        return null;
    }

    public SparseMatrix produce(SparseMatrix other) {
        return null;
    }
}
