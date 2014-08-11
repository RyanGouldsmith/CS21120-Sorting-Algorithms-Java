package sorting2014;
/**
 * @author Ryan Gouldsmith (ryg1)
 * @version 0.2
 * @since 04/03/14.
 * This class implements the Quicksort Algorithm.
 * It also implements the sort method from Sorter class.
 * Based on RICHARDS SLIDES ON QuickSort LECTURE 60.
 */
public class QuickSort implements Sorter{
    /* (non-Javadoc)
	 * @see sorting.Sorter#sort(java.lang.Comparable[])
	 */
    @Override
    public void sort(Comparable[] items, int cutoff) {
        quickSort(items, 0, items.length);
    }
    /**
     * The Quick Sort algorithm, takes an array, right value, high value
     * @param array is the array of values from the data file
     * @param left is the left most value of the sub array
     * @param right is the right most value of the sub array
     */
    public void quickSort(Comparable[] array, int left, int right){
        ;
         /* Quick sort on the right side of the array*/
        if (left < right){
            /* Work out the pivot */
            int pivotValue = paritioning(array, left, right);
            /* Quick sort on the left side of array*/
            quickSort(array, left, pivotValue);
            quickSort(array, pivotValue+1, right);
        }
    }
    /**
     * Used to work out the partitioning of the pivot to sort the array
     * @param array is the array of values from the data file
     * @param left is the left most value of the sub array
     * @param right is the right most value of the sub array
     * @return A integer value which represents the pivot.
     */
    public int paritioning (Comparable[] array, int left, int right){
        int first = left;
        int swapPos;
        //middle of the array
        int pivotPos = (left + right)/2;
        //move pivot to the front doing some swapping
        Comparable indexFirst = array[first];
        array[first] = array[pivotPos];
        array[pivotPos] = indexFirst;
        //increment first
        swapPos = first + 1;
        for (int i = swapPos; i < right; i++){
            //move to the front if it's smaller
            if (array[i].compareTo(array[first]) < 0){
                //swap swapPos array with current element
                indexFirst = array[i];
                array[i] =array[swapPos];
                array[swapPos] = indexFirst;
                //increment swapPos
                swapPos = swapPos +1;
            }
        }
        //move pivot back

      indexFirst= array[swapPos -1];
        array[swapPos-1] = array[first];
        array[first] = indexFirst;
        //return pivot position
        return swapPos -1;
    }
}