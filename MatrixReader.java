import java.util.Scanner;

public class MatrixReader {

    public SparseMatrix read(String file){
        try{
            Scanner scanner = new Scanner(file);

            int r = Integer.parseInt(scanner.nextLine()), c = Integer.parseInt(scanner.nextLine());

            SparseMatrix matrix = new SparseMatrix(r,c);

            for(int i = 1; i <= r; i++){
                String line = scanner.nextLine();
                if(line != ""){
                    String[] items = line.split(" ");
                    for(String s : items){
                        String[] colVal = s.split(",");
                        matrix.insert(i, Integer.parseInt(colVal[0]), Integer.parseInt(colVal[1]));
                    }
                }
            }

            scanner.close();
            return matrix;
        }
        catch(Exception e){
            System.out.println("Too bad");
        }
        return null;
    }
}
