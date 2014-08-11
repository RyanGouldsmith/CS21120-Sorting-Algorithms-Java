package sorting2014;
/**
 * @author Ryan Gouldsmith (ryg1)
 * @version 0.2
 * @since 07/03/14
 * This class implements the Sorter class, which gives a default Sort method.
 * This class implements the Sort Shell Sort
 * Based on the Algorithm from http://en.wikipedia.org/wiki/Shellsort
 */
public class ShellSort implements Sorter{
    /* (non-Javadoc)
	 * @see sorting.Sorter#sort(java.lang.Comparable[])
	 */
    @Override
    public void sort(Comparable[] items, int cutoff) {
        Comparable temp;
        int k;
        int i;
        int j;
        for (i = 0; i < items.length; i++){
            for (j = i; j <items.length; j++){
                temp = items[j];
                for (k = j; k >=j && items[k-i].compareTo(temp) <0; k=k-i){
                        items[k] = items[k-i];
                }
                items[k] = temp;
            }
        }
    }
}
