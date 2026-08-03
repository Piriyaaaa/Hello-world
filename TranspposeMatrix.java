package Intermediate;

import java.util.Scanner;

public class TranspposeMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] a = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int[][] t = transpose(a);

        System.out.println("Transpose:");
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                System.out.print(t[i][j] + (j + 1 == t[0].length ? "" : " "));
            }
            System.out.println();
        }

        sc.close();
    }

    // Transpose of a matrix: result has shape (cols x rows)
    static int[][] transpose(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;

        int[][] t = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                t[j][i] = a[i][j];
            }
        }
        return t;
    }
}

