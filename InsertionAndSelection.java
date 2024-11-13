import java.util.*;
import java.io.*;

public class InsertionAndSelection {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = genRandomList();
        Integer[] arr = genRandomArray();
        print(list, arr, "Before sort:\n");
        insertionSort(list);
        selectionSort(arr);
        print(list, arr, "After sort:\n");
    }

    public static ArrayList<Integer> genRandomList() {
        Random random = new Random();
        ArrayList<Integer> alist = new ArrayList<Integer>();
        
        for(int i = 0; i < 100; i++) {
            alist.add(random.nextInt(100));
        }

        return alist;
    }

    public static Integer[] genRandomArray() {
        Random random = new Random();
        Integer[] intArr = new Integer[100];

        for(int i = 0; i < 100; i++) {
            intArr[i] = random.nextInt(100);
        }

        return intArr;
    }

    public static void insertionSort(ArrayList<Integer> a) {
        for(int i = 1; i < a.size(); i++) {
            int nextElement = a.get(i);
            int compareI = i - 1;
            while((compareI >= 0) && (a.get(compareI) > nextElement)) {
                a.set(compareI + 1, a.get(compareI));
                compareI--;
            }
            a.set(compareI + 1, nextElement);
        }
    }

    public static void selectionSort(Comparable<Integer>[] a) {
        for(int i = a.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for(int j = 1; j <= i; j++) {
                if(a[j].compareTo((Integer) a[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swapArray(a, maxIndex, i);
        }
    }

    public static void swapArray(Comparable<Integer>[] a, int index1, int index2) {
        if(index2 < 100) {
            Comparable<Integer> temp = a[index1];
            a[index1] = a[index2];
            a[index2] = temp;
        }
    }

    public static void print(ArrayList<Integer> a, Comparable<Integer>[] b, String msg) throws IOException {
        FileWriter fw = new FileWriter("output", true);
        fw.write(msg);
    
        for (int i = 0; i < a.size(); i++) {
            fw.write(a.get(i).toString() + " ");
            if ((i + 1) % 10 == 0) fw.write("\n");
        }
    
        fw.write("\n");
    
        for (int i = 0; i < b.length; i++) {
            fw.write(b[i].toString() + " ");
            if ((i + 1) % 10 == 0) fw.write("\n");
        }
    
        fw.write("\n\n");
        fw.close();
    }
}
