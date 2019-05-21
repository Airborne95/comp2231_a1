/**
 * A file to test the ShellArray class and various sorting algorithms
 *
 * @author Mohammad Chaudhry
 * @version 1.0
 * 2019.01.25
 * T00554758
 */

import java.io.*;
import java.util.Random;
import java.util.Arrays;
public class Driver{

    public static void main( String[] args )
    {
        System.out.print("\n\nRunning tests for the ShellArray class:\n\n");
        testShellArray();
        System.out.print("\n\nRunning tests for various sorting algorithms:\n\n");
        testSorting();

    }

  /**
   * The purpose of this method is to test the Shell Array class by creating arrays of various sizes
   * and sorting them.
   */
    public static void testShellArray(){

        // Array declarations
        ShellArray s = new  ShellArray(1);
        ShellArray s1 = new ShellArray(2);
        ShellArray s2 = new ShellArray(4);
        ShellArray s3 = new ShellArray(8);
        ShellArray s4 = new ShellArray(16);

        // Arrays being sorted and displayed
        runShellSort(s);
        runShellSort(s1);
        runShellSort(s2);
        runShellSort(s3);
        runShellSort(s4);
    }

   /**
	 * The purpose of this method is to call the functions defined in the ShellArray class which sort an array
     * or display the content of an array.
	 *
	 * @param s an object which has access to the array and the shellSort function
	 */
    public static void runShellSort(ShellArray s){
        System.out.println();
        s.showArray();
        s.shellSort();
        s.showArray();
    }

   /**
	 * The purpose of this method is to test the modifications made to the Sorting class as per this assignment.
	 */
    public static void testSorting(){

        int numberOfTests = 5;
        boolean sort = true;

        Sorting s = new Sorting();
        Integer[][] unsortedArrays = new Integer[numberOfTests][];
        Integer[][] sortedArrays = new Integer[numberOfTests][];

        System.out.println("***************Ignore the following*************");
        initArray(unsortedArrays,numberOfTests,!sort,s);
        initArray(sortedArrays,numberOfTests, sort,s);
        System.out.println("***********The following is relevant************\n\n");

        // Testing Unsorted Arrays
        testArray(unsortedArrays, numberOfTests,!sort, s);
        testArray(sortedArrays, numberOfTests,sort, s);


    }

   /**
    * The purpose of this method is to populate an array with random numbers.
    * @param data is an array that holds the object Integer. (the Integer object holds an int)
    */
    public static void initArray(Integer[][] data, int length, boolean sort, Sorting s){
       int arraySize = 9, increaseby=9;

       for(int i=0; i<length;i++){
           data[i]=new Integer[arraySize];
           arraySize=arraySize*increaseby;
           fillArray(data[i]);
           if(sort){
               s.quickSort(data[i]);
           }
       }

    }

   /**
	 * The purpose of this method is to populate an array with random numbers.
     * @param data is an array that holds the object Integer. (the Integer object holds an int)
	 */
    public static void testArray(Integer[][] data, int length, boolean sort, Sorting s){
         for(int i=0; i<length;i++){
            if(sort){
                System.out.println("Sorted Array of Size: " + data[i].length);
            }else{
                System.out.println("Unsorted Array of Size: " + data[i].length);
            }
                s.selectionSort(Arrays.copyOf(data[i], data[i].length));
                s.insertionSort(Arrays.copyOf(data[i], data[i].length));
                s.bubbleSort(Arrays.copyOf(data[i], data[i].length));
                s.quickSort(Arrays.copyOf(data[i], data[i].length));
                s.mergeSort(Arrays.copyOf(data[i], data[i].length));
                System.out.println();
         }
    }

   /**
	 * The purpose of this method is to populate an array with random numbers.
     * @param data is an array that holds the object Integer. (the Integer object holds an int)
	 */
    public static void fillArray(Integer[] data){
        Random r = new Random(10); // Seeded only for reproducibility
        for(int i=0;i<data.length;i++){
            data[i] = r.nextInt(4000);
        }
    }

	/**
	 * Shows the content of an array.
	 * @param data is an array of objects.
	 */
	  public static <T extends Comparable<T>>
		void printArray(T[] data){
         System.out.print(data[0]);
         for(int i=1;i<data.length;i++){
             System.out.print(", "+data[i]);
         }
         System.out.println();
    }

}
