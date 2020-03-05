
public class Homework2 {
    public void run() {
        MatrixReader reader = new MatrixReader();

        SparseMatrix matrixA = reader.read("matrixA.txt");
        matrixA.print();

        System.out.println("-".repeat(30));

        SparseMatrix matrixB = reader.read("matrixB.txt");
        matrixB.print();

        System.out.println("-".repeat(30));

        SparseMatrix aTransposed = matrixA.transpose();
        aTransposed.print();
        
        System.out.println("-".repeat(30));

        SparseMatrix bTransposed = matrixB.transpose();
        bTransposed.print();

        System.out.println("-".repeat(30));

        SparseMatrix product = matrixA.product(matrixB);
        product.print();

    }
}
