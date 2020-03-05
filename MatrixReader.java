import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MatrixReader {

    public SparseMatrix read(String file){
        SparseMatrix matrix = new SparseMatrix(3, 3);
        try{
            File f = new File(file);
            Scanner scanner = new Scanner(f);

            int r = Integer.parseInt(scanner.nextLine()), c = Integer.parseInt(scanner.nextLine());

            matrix = new SparseMatrix(r,c);

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
        }
        catch(FileNotFoundException e){
            System.out.println("Too bad");
        }
        return matrix;
    }
}
