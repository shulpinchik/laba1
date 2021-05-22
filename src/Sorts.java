public class Sorts {
    private double start_time;
    private int temp;

    public int[] selection_sort(int[] mass) {
        int min = mass[0];
        int temp;
        int que = 0;

        this.start_time = System.nanoTime();
        for (int i = 0; i < mass.length; i++) {
            min = mass[i];
            que = i;
            for (int j = i; j < mass.length; j++) {
                if (mass[j] < min) {
                    min = mass[j];
                    que = j;
                }
            }
            temp = mass[i];
            mass[i] = min;
            mass[que] = temp;
        }
        System.out.println("Selection sort: " + (System.nanoTime() - start_time) + " nano sec");
        return mass;
    }

    public int[] insertion_sort(int[] mass) {
        this.start_time = System.nanoTime();
        for (int i = 1; i < mass.length; i++){
           int current = mass[i];
            int j = i - 1;
            while (j >= 0 && current < mass[j]){
                mass[j + 1] = mass[j];
                j--;
            }
            mass[j + 1] = current;
        }

        System.out.println("Insertion sort: " + (System.nanoTime() - start_time) + " nano sec");
        return mass;
    }

    public int[][] bubble_sort(int[][] matrix, int n, int m) {
        boolean isSorted = false;

        this.start_time = System.nanoTime();
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (matrix[k][i] > matrix[k][j]) {
                        temp = matrix[k][i];
                        matrix[k][i] = matrix[k][j];
                        matrix[k][j] = temp;
                    }
                }
            }
        }
        System.out.println("bubble sort: " + (System.nanoTime() - start_time) + " nano sec");

        return matrix;
    }

    public int[][] shell_sort(int[][] matrix, int n, int m) {
        this.start_time = System.nanoTime();


        for (int k = 0; k < n; k++) {
            for (int step = m / 2; step > 0; step /= 2) {
                for (int i = step; i < m; i++) {
                    for (int j = i - step; j >= 0 && matrix[k][j] > matrix[k][j + step]; j -= step) {
                        temp = matrix[k][j];
                        matrix[k][j] = matrix[k][j + step];
                        matrix[k][j + step] = temp;
                    }
                }
            }
        }
        System.out.println("shell sort: " + (System.nanoTime() - start_time) + " nano sec");

        return matrix;
    }

    public void quick_sort(int[] mas, int low, int high) {

        int i = low;
        int j = high - 1;
        int x = mas[low + (high - low) / 2];
        do {
            while (mas[i] < x) i++;
            while (mas[j] > x) j--;
            if (i <= j) {
                temp = mas[i];
                mas[i] = mas[j];
                mas[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (low < j) quick_sort(mas, low, j);
        if (i < high) quick_sort(mas, i, high);
    }


    public void heap_sort(int[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }
}
