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
        if (value.getRow() < first.getRow()) { // insert beforehand
            value.setNextRow(first);
            first = value;
        } 
        else if (first == null) { // empty row, set as first
            first = value;
        }
        else {
            ValueNode currentNode = first;
            while (currentNode.getNextRow() != null) {

                if ((currentNode.getRow() < value.getRow()) && 
                    (currentNode.getNextRow().getRow() > value.getRow())) {                 
                    value.setNextRow(currentNode.getNextRow());
                    currentNode.setNextRow(value);
                    break;
                }
                else if (currentNode.getNextRow() == null) {
                    currentNode.setNextRow(value);
                    break;
                }
                currentNode = currentNode.getNextRow();
            }
        }
    }

    public int get(int position) {
        if (first == null || first.getRow() < position)
            return 0;
        else {
            ValueNode currentNode = first;
            while (currentNode.getRow() < position) {
                currentNode = currentNode.getNextRow();
            }
            if (currentNode.getRow() == position)
                return currentNode.getValue();
        }
        return 0;
    }
}
