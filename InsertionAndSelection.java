import java.util.*;
import java.io.*;

public class InsertionAndSelection {
    public static void main(String[] args) {
        ArrayList<Integer> list = genRandomList();
        Integer[] arr = genRandomArray();
        insertionSort(list);
        selectionSort(arr);
    }

    public static ArrayList<Integer> genRandomList() {
        Random random = new Random();
        ArrayList<Integer> alist = new ArrayList<Integer>();
        
        for(int i = 0; i < 100; i++) {
            alist.add(random.nextInt());
        }

        return alist;
    }

    public static Integer[] genRandomArray() {
        Random random = new Random();
        Integer[] intArr = new Integer[100];

        for(int i = 0; i < 100; i++) {
            intArr[i] = random.nextInt();
        }

        return intArr;
    }

    public static void insertionSort(ArrayList<Integer> a) {
        for(int currentSortedIndex = 1; currentSortedIndex < a.size(); currentSortedIndex++) {
            int nextElement = a.get(currentSortedIndex);
            int compareI = currentSortedIndex - 1;
            while((compareI > 0) && (a.get(compareI) > nextElement)) {
                a.set(compareI, a.get(compareI - 1));
                compareI--;
            }
            a.set(compareI, nextElement);
        }
    }

    public static void selectionSort(Comparable<Integer> a[]) {
        for(int endOfArrayIndex = a.length; endOfArrayIndex > 0; endOfArrayIndex--) {
            Comparable<Integer> max = a[0];
            int maxIndex = 0;
            for(int i = 0; i < endOfArrayIndex; i++) {
                if(a[i].compareTo((Integer) max) > 0) {
                    max = a[i];
                    maxIndex = i;
                }
                swapArray(a, maxIndex, endOfArrayIndex);
            }
        }
    }

    public static void swapArray(Comparable<Integer>[] a, int index1, int index2) {
        if(index2 < 100) {
            Comparable<Integer> temp = a[index1];
            a[index1] = a[index2];
            a[index2] = temp;
        }
    }

    public static void print(ArrayList<Integer> a, Comparable<Integer> b[], String msg) throws FileNotFoundException, IOException {
        FileWriter     file   = new FileWriter("output.txt");
    }
}
