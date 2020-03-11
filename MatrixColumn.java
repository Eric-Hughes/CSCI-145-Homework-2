public class MatrixColumn {
    private ValueNode first;
    private MatrixColumn next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixColumn getNext() {
        return next;
    }

    public void setNext(MatrixColumn next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        if (first == null) { // empty column, set as first
            first = value;
        } 
        else if (value.getRow() < first.getRow()) { // insert beforehand
            value.setNextRow(first);
            first = value;
        }
        else {
            ValueNode currentNode = first;
            while (currentNode.getNextRow() != null) {
                //If node is meant to go in between this row and the next row, put it in and return
                if ((currentNode.getRow() < value.getRow()) && (currentNode.getNextRow().getRow() > value.getRow())) {                 
                    value.setNextRow(currentNode.getNextRow());
                    currentNode.setNextRow(value);
                    return;
                }
                currentNode = currentNode.getNextRow();
            }
            currentNode.setNextRow(value);
        }
    }

    //Returns the value of the node in this column in the requested row position
    public int get(int position) {
        if (first == null || first.getRow() < position)
            return 0;
        else {
            ValueNode currentNode = first;
            while(currentNode.getRow() < position) {
                if (currentNode.getNextRow() == null)
                    return 0;
                currentNode = currentNode.getNextRow();
            }
            if (currentNode.getRow() == position)
                return currentNode.getValue();
        }
        return 0;
    }
}
