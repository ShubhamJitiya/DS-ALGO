import java.util.Random;

public class SortingTimeAnalysis {
    private static final int N = 10000; // Maximum number of input values
    private static final int dN = 100; // Difference for input values

    public static void info(){
        System.out.println("\nPractical 1: Implementation and Time analysis of sorting algorithms.");
        System.out.println("Enrollment No: 190130107043");
        System.out.println("Date & Time: " + new java.util.Date());
        System.out.println("-----------------------------------------------------------------\n");
    }

    // ---------- Sorting Algorithms ----------
    // Bubble Sort Algorithm
    public static void bubbleSort(int[] list){
        boolean flag = true;
        for(int i = 1; i < list.length; i++){
            flag = false;
            for(int j = 0; j < list.length - i; j++){
                if(list[j + 1] < list[j]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    flag = true;
                }
            }
        }
    }

    // Selection Sort Algorithm
    public static void selectionSort(int[] list){
        for(int i = 0; i < list.length; i++){
            int currentMin = list[i];
            int minIndex = i;
            for(int j = i + 1; j < list.length; j++){
                if(list[j] < currentMin){
                    currentMin = list[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                list[minIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    // Insertion Sort Algorithm
    public static void insertionSort(int[] list){
        for(int i = 1; i < list.length; i++){
            int currentMin = list[i];
            int k;
            for(k = i - 1; k >= 0 && list[k] > currentMin; k--){
                list[k + 1] = list[k];
            }
            list[k + 1] = currentMin;
        }
    }

    // Merge Sort Algorithm
    public static void mergeSort(int[] list){
        if(list.length > 1){
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
    }
    public static void merge(int[] list1, int[] list2, int[] list){
        int c1 = 0;
        int c2 = 0;
        int c = 0;
        while(c1 < list1.length && c2 < list2.length){
            if(list1[c1] < list2[c2]){
                list[c++] = list1[c1++];
            }
            else{
                list[c++] = list2[c2++];
            }
        }
        while(c1 < list1.length){
            list[c++] = list1[c1++];
        }
        while(c2 < list2.length){
            list[c++] = list2[c2++];
        }
    }

    // Quick Sort Algorithm
    public static void quickSort(int[] list){
        quickSort(list, 0, list.length -1);
    }
    public static void quickSort(int[] list, int first, int last){
        if(last > first){
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    public static int partition(int[] list, int first, int last){
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while(high > low){
            while(low <= high && list[low] <= pivot)
                low++;
            while(low <= high && list[high] > pivot)
                high--;

            if(high > low){
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while(high > first && list[high] >= pivot)
            high--;

        if(pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else{
            return first;
        }
    }
    // ---------- ---------- ---------- ---------- ----------

    // ---> Methods for generating array of input values for sorting
    // Best Case Array
    private static int[] getBestN(int n){
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = i;
        }
        return list;
    }

    // Average Case Array
    private static int[] getAvgN(int n){
        Random random = new Random(10);
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = random.nextInt(n);
        }
        return list;
    }

    // Worst Case Array
    private static int[] getWorstN(int n){
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = n - i;
        }
        return list;
    }
    // ---------- ---------- ---------- ---------- ----------

    // ---------- Calculation of taken by time specific algorithm ----------
    // Best Case Time
    private static long[] getBestTime(){
        int n = N/dN;
        long[] bestTime = new long[n];
        int c = 0;
        for(int i = dN; i <= N; i = i + dN){
            int[] list = getBestN(i);
            long t0 = System.nanoTime();

            // Use different sorting algorithms here
            mergeSort(list);

            long t1 = System.nanoTime();
            bestTime[c++] = t1 - t0;
        }
        return bestTime;
    }

    // Average Case Time
    private static long[] getAvgTime(){
        int n = N/dN;
        long[] avgTime = new long[n];
        int c = 0;
        for(int i = dN; i <= N; i = i + dN){
            int[] list = getAvgN(i);
            long t0 = System.nanoTime();

            // Use different sorting algorithms here
            mergeSort(list);

            long t1 = System.nanoTime();
            avgTime[c++] = t1 - t0;
        }
        return avgTime;
    }

    // Worst Case Time
    private static long[] getWorstTime(){
        int n = N/dN;
        long[] worstTime = new long[n];
        int c = 0;
        for(int i = dN; i <= N; i = i + dN){
            int[] list = getWorstN(i);
            long t0 = System.nanoTime();

            // Use different sorting algorithms here
            mergeSort(list);

            long t1 = System.nanoTime();
            worstTime[c++] = t1 - t0;
        }
        return worstTime;
    }
    // ---------- ---------- ---------- ---------- ----------

    // ---------- Method to print array values ----------
    private static void printArray(long[] list){
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){

        info();

        // Array to store Best Case Time
        long[] bestTime = getBestTime();

        // Array to store Average Case Time
        long[] avgTime = getAvgTime();

        // Array to store Worst Case Time
        long[] worstTime = getWorstTime();

        System.out.println("---BestCase---");
        printArray(bestTime);
        System.out.println("---AvgCase---");
        printArray(avgTime);
        System.out.println("---WorstCase---");
        printArray(worstTime);
    }
}
