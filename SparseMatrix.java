
public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;
    private int maxDigits = 1;

    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;
        int maxVal = Math.max(rows, columns); // how many times we iterate
        firstRow = new MatrixRow();
        firstColumn = new MatrixColumn();
        MatrixRow currentRow = firstRow;
        MatrixColumn currentColumn = firstColumn;

        for (int i = 0; i < maxVal; i++) { // Create appropriate number of rows and columns
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

        int digits = (value + "").length();
        if (digits > maxDigits && column != totalColumns)
            maxDigits = digits;

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
        return getRow(row).get(column);
    }

    public void print() {//Prints Matrix In Console
        for (int i = 1; totalRows >= i; i++){
            for (int j = 1; totalColumns >= j; j++){
                int val = getValue(i,j);
                System.out.print(val  + " ".repeat(maxDigits + 1 - (val + "").length()));
            }
            System.out.println();
        }
    }

    public SparseMatrix transpose() {
        //Resulting matrix
        SparseMatrix res = new SparseMatrix(this.totalColumns, this.totalRows);

        //Get all values in matrix and insert it into the new matrix (Row and Column Switched) if it's not a 0
        for(int i = 1; i <= this.totalRows; i++){
            for(int j = 1; j <= this.totalColumns; j++){
                int val = getValue(i, j);
                if(val != 0){
                    res.insert(j, i, val);
                }
            }
        }
        return res;
    }

    public SparseMatrix product(SparseMatrix other) {
        if(this.totalColumns != other.totalRows){ // Return Null if you can't multiply matrices
            System.out.println("Can't multiply matrices due to wrong size");
            return null;
        }

        SparseMatrix res = new SparseMatrix(this.totalRows, other.totalColumns);

        for(int i = 1; i <= this.totalRows; i++) { // Loop Through all rows of this matrix
            for(int j = 1; j <= other.totalColumns; j++) { // Loop through all columns of second matrix
                int val = 0;
                for(int x = 1; x <= this.totalColumns; x++) { // Get product of item in this matrix row and other matrix column
                    val += this.getValue(i, x) * other.getValue(x, j);
                }
                res.insert(i, j, val);
            }
        }
        return res;
    }
}
