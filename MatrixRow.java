public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }

    public void setNext(MatrixRow next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        if (first == null) { // empty row, set as first
            first = value;
        } 
        else if (value.getColumn() < first.getColumn()) { // insert beforehand
            value.setNextColumn(first);
            first = value;
        }
        else {
            ValueNode currentNode = first;
            while (currentNode.getNextColumn() != null) {  
                if ((currentNode.getColumn() < value.getColumn()) && (currentNode.getNextColumn().getColumn() > value.getColumn())) {                 
                    value.setNextColumn(currentNode.getNextColumn());
                    currentNode.setNextColumn(value);
                    return;
                }
                currentNode = currentNode.getNextColumn();
            }
            currentNode.setNextColumn(value);
        }

    }

    public int get(int position) {
        if (first == null || first.getColumn() > position)
            return 0;
        else {
            ValueNode currentNode = first;
            while (currentNode.getColumn() < position) {
                if (currentNode.getNextColumn() == null)
                    return 0;
                currentNode = currentNode.getNextColumn();
            }
            if (currentNode.getColumn() == position)
                return currentNode.getValue();
        }
        return 0;
    }

}
