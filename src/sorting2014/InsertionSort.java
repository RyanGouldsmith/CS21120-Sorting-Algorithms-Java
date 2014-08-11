package sorting2014;

/**
 * @author Ryan Gouldsmith (ryg1)
 * @version 0.1
 * @since 05/03/14.
 * This class implements the Insertion Sort using the Sorter interface.
 * Based on Aglorithm from http://www.sorting-algorithms.com/insertion-sort
 */
public class InsertionSort implements Sorter {
    /* (non-Javadoc)
	 * @see sorting.Sorter#sort(java.lang.Comparable[])
	 */
    @Override
    public void sort(Comparable[] items, int cutoff) {
        Comparable value;
        for (int j = 0; j < items.length; j++){
            for (int k = j; k >= 1 && items[k].compareTo(items[k-1]) < 0; k--){
                   value = items[k];
                   items[k] = items[k-1];
                   items[k-1] = value;
           }

        }
    }
}
