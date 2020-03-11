import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MatrixReader {

    public SparseMatrix read(String file){

        try{//Create file from the input path
            File f = new File(file);
            Scanner scanner = new Scanner(f);

            int r = Integer.parseInt(scanner.nextLine()), c = Integer.parseInt(scanner.nextLine());

            SparseMatrix matrix = new SparseMatrix(r,c);

            for(int i = 1; i <= r; i++){ //Loop through remaining lines and parse each pair of numbers as a new node
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
        catch(FileNotFoundException e){
            System.out.println("File " + file + " not found");
        }
        return null;
    }
}
