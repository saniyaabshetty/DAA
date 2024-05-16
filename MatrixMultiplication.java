import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows1, cols1;
        System.out.print("Enter rows and columns for the matrix: ");
        rows1 = scanner.nextInt();
        cols1 = scanner.nextInt();
        
        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows1][cols1];
        int[][] matrix3 = new int[rows1][cols1];
        
        System.out.println("Enter the first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the second matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        int m1 = matrix1[0][0] * (matrix2[0][1] - matrix2[1][1]);
        int m2 = (matrix1[0][0] + matrix1[0][1]) * matrix2[1][1];
        int m3 = (matrix1[1][0] + matrix1[1][1]) * matrix2[0][0];
        int m4 = matrix1[1][1] * (matrix2[1][0] - matrix2[0][0]);
        int m5 = (matrix1[0][0] + matrix1[1][1]) * (matrix2[0][0] + matrix2[1][1]);
        int m6 = (matrix1[0][1] - matrix1[1][1]) * (matrix2[1][0] + matrix2[1][1]);
        int m7 = (matrix1[0][0] - matrix1[1][0]) * (matrix2[0][0] + matrix2[0][1]);

        matrix3[0][0] = m5 + m4 - m2 + m6;
        matrix3[0][1] = m1 + m2;
        matrix3[1][0] = m3 + m4;
        matrix3[1][1] = m1 + m5 - m3 - m7;

        System.out.println("\nMatrix Multiplication:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
