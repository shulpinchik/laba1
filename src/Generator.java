import java.util.Random;

public class Generator {
    public static int[][] matrix(int m, int n, int min, int max) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix[i][j] = (int)(Math.random() * ((max - min) + 1) + min);
            }
        }
                return matrix;
    }

    public static int[] massive(int n, int min_limit, int max_limit) {
        int[] mass = new int[n];
        for (int i = 0; i < n; i++){
            mass[i] = (int)(Math.random() * ((max_limit - min_limit) + 1) + min_limit);
        }
        return mass;
    }
}
