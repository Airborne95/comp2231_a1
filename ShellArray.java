/**
 * Shell Sort class, implements Shell sort, which is like Bubble sort but it adapts concepts
 * from the binary search by using a "gap" across which values are compared.
 *
 * @author Mohammad Chaudhry
 * @version 1.0
 * 2019.01.25
 * T00554758
 */
import java.util.Random;
public class ShellArray {

    public Integer[] data;
		private final static int DEFAULT_CAPACITY = 20;

	/**
	 * Creates and fills an array (of size equal to the DEFAULT_CAPACITY) with random numbers
	 *
	 */
		public ShellArray(){
				this(DEFAULT_CAPACITY);
		}

	/**
	 * Creates and fills an array with random numbers
	 *
	 * @param size is the size of the array to be creted
	 */
    public ShellArray(int size){
        Random r = new Random(10); // Seeded only for reproducibility
        this.data = new Integer[size];
        for(int i=0;i<size;i++){
            this.data[i]= r.nextInt(600);
        }
    }

  /**
	 * Sorts the specified array of objects using a shell sort
	 * algorithm.
	 */
    public void shellSort()
	{
        int gap = this.data.length/2;
        boolean swapflag;
        while(gap>0){
            swapflag=true;
            while(swapflag){
                swapflag=false;
                for(int i=0;i<this.data.length-gap;i++){
                    if(this.data[i] > this.data[i+gap]){
                        swap(i,i+gap);
                        swapflag = true;
                    } //End if
                } // End for loop
            }// Inner while loop
            gap=gap/2;
        }// Outer while loop
    }

  /**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 */
    private void swap(int index1, int index2)
	{
		int temp = this.data[index1];
		this.data[index1] = this.data[index2];
		this.data[index2] = temp;
        toString(this.data[index2],this.data[index1]);
	}

  /**
	 * outputs the result of each swap
	 *
	 * @param val1 the value with the smaller index that was swapped
   * @param val2 the value with the larger index that was swapped
	 */
     private void toString(int val1,int val2){
         System.out.println("Swapped: " + val1 + " with " +val2);
     }

    /**
	   * Shows the content of an array.
	   */
     public void showArray(){
         System.out.print(this.data[0]);
         for(int i=1;i<this.data.length;i++){
             System.out.print(", "+this.data[i]);
         }
         System.out.println();
     }

}
