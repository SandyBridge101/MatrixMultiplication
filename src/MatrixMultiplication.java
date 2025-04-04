import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rows and columns (comma-separated) for Matrix A:");
        String[] size = scanner.nextLine().split(",");
        int rows = Integer.parseInt(size[0].trim());
        int cols = Integer.parseInt(size[1].trim());

        int[][] matrixA = new int[rows][cols];

        System.out.println("Enter the matrix A row by row (space-separated values):");

        for (int i = 0; i < rows; i++) {
            String[] tokens = scanner.nextLine().split(" "); // Read row and split by space
            for (int j = 0; j < cols; j++) {
                matrixA[i][j] = Integer.parseInt(tokens[j]); // Convert to integer
            }
        }// O(n^2)


        scanner = new Scanner(System.in);
        System.out.println("Enter rows and columns (comma-separated) for Matrix B:");
        size = scanner.nextLine().split(",");
        rows = Integer.parseInt(size[0].trim());
        cols = Integer.parseInt(size[1].trim());

        int[][] matrixB = new int[rows][cols];

        System.out.println("Enter the matrix B row by row (space-separated values):");

        for (int i = 0; i < rows; i++) {
            String[] tokens = scanner.nextLine().split(" "); // Read row and split by space
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = Integer.parseInt(tokens[j]); // Convert to integer
            }
        }

        //exception if the dimension contraints aren't met
        if (matrixA[0].length != matrixB.length) {
            System.out.println("Dimension Mismatch");
            return;
        }

        int n=matrixA.length;//number of rows in matrix A
        int m=matrixB[0].length;//number of columns in matrix B
        int[][] res=new int[n][m];//resultant matrix

        //For-loop to process the matrix calculation
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int a=0; a<matrixB.length;a++){
                    res[i][j]+=(matrixA[i][a]*matrixB[a][j]); // the ath element in the ith row * the ath element in the jth column
                }

            }
        }//O(n^3)

        //For-loop to print out matrix C
        System.out.println("Matrix C:");
        for(int i=0;i<res.length;i++){
            System.out.print('|');
            for(int j=0;j<res[0].length;j++){
                System.out.print(' ');
                System.out.print(res[i][j]);
                System.out.print(' ');
            }
            System.out.printf("|%n");
        }

        //O(n^2)+O(n^2)+O(n^3) == 0(n^3)
    }
}
