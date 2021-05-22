import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        int n = 50;
        int m = 50;
        int min_limit = -50;
        int max_limit = 50;
        int[][] matrix = Generator.matrix(m,n,min_limit,max_limit);
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        int[] massive = Generator.massive(n,min_limit,max_limit);
        new Sorts().selection_sort(massive);
        new Sorts().insertion_sort(massive);
        new Sorts().bubble_sort(matrix,n,m);
        new Sorts().shell_sort(matrix,n,m);
        double start_time = System.nanoTime();
        new Sorts().quick_sort(massive,0,n);
        System.out.println("quick sort: " + (System.nanoTime() - start_time)+" nano sec");
        start_time = System.nanoTime();
        new Sorts().heap_sort(massive);
        System.out.println("heap sort: " + (System.nanoTime() - start_time)+" nano sec");
    }
}
