/**
* Names:	   Jackson P, Maya T
* Date: 	   NOV2024
* Class:	   APCSA 3RD
* Description: prints before and after selection and
* 			   insertion sort of both list of 100 random 
* 			   integers and array of 100 random integers 
* 			   into a new text file
*/

package mainPackage;

import java.util.*;
import java.io.*;

public class InsertionAndSelection 
{
    public static void main(String[] args) throws IOException 
    {
        List<Integer> list = genRandomList();
        Integer[] arr = genRandomArray();
        print(list, arr, "Before sort:\n");
        insertionSort(list);
        selectionSort(arr);
        print(list, arr, "After sort:\n");
    }
    
    /**
    * generate list length 100 filled with random integers
    */
    public static List<Integer> genRandomList() 
    {
        Random random = new Random();
        List<Integer> alist = new ArrayList<Integer>();
        
        for(int i = 0; i < 100; i++) {
            alist.add(random.nextInt(100));
        }

        return alist;
    }

    /**
    * generate array length 100 filled with random integers
    */
    public static Integer[] genRandomArray() 
    {
        Random random = new Random();
        Integer[] intArr = new Integer[100];

        for(int i = 0; i < 100; i++) {
            intArr[i] = random.nextInt(100);
        }

        return intArr;
    }

    /**
    * adding elements individually assuming previous elements
    * are sorted
    * quadratic
    */
    public static void insertionSort(List<Integer> a) 
    {
        for(int i = 1; i < a.size(); i++)
        {
            int nextElement = a.get(i);
            int compareI = i - 1;
            while((compareI>=0) && (a.get(compareI)).compareTo(nextElement)>0) 
            {
                a.set(compareI+1, a.get(compareI));
                compareI=compareI-1;
            }
            a.set(compareI+1, nextElement);
        }
    }

    /**
    * find largest element and put in last slot then shorten array
    * quadratic
    */
    public static void selectionSort(Comparable<Integer>[] a) 
    {
        for(int i = a.length-1; i > 0; i--) 
        {
            int maxIndex = 0;
            for(int j = 1; j <= i; j++) 
            {
                if(a[j].compareTo((Integer) a[maxIndex]) > 0) 
                {
                    maxIndex = j;
                }
            }
            swapArray(a, maxIndex, i);
        }
    }

    /**
    * prints list and array before and after sorts into new
    * text file
    * @param a
    * @param b
    * @param msg
    * @throws IOException
    */
    public static void print(List<Integer> a, Comparable<Integer>[] b, String msg) throws IOException 
    {
    	
        FileWriter fw = new FileWriter("output", true);
        fw.write(msg);
    
        for (int i = 0; i < a.size(); i++) 
        {
            fw.write(a.get(i).toString() + ", ");
            if ((i + 1) % 10 == 0) fw.write("\n");
            if (i == 99) fw.write(".");
        }
    
        fw.write("\n");
    
        for (int i = 0; i < b.length; i++) 
        {
            fw.write(b[i].toString() + ", ");
            if ((i + 1) % 10 == 0) fw.write("\n");
            if (i == 99) fw.write(".");
        }
    
        fw.write("\n\n");
        fw.close();
    }

   /**
    * helper to slection sort
    * @param a
    * @param index1
    * @param index2
    */
    private static void swapArray(Comparable<Integer>[] a, int index1, int index2) 
    {
        if(index2 < 100) 
        {
            Comparable<Integer> temp = a[index1];
            a[index1] = a[index2];
            a[index2] = temp;
        }
    }
}
