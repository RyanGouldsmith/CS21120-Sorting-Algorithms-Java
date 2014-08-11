/*
 * Created on Nov 28, 2003
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package sorting2014;
import java.io.*;
import java.util.*;
/**
 * @author rcs
 * @author Ryan Gouldsmith
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
@SuppressWarnings("unchecked")
public class SortDemo {
    /**
     * This reads the Data from a text file into a comparable array
     * @param fileName is the name of .dat file that will be loaded
     * @return a comparable array of the Items from a text file.
     */
	public Comparable[] readData(String fileName)
	{
		Comparable[] items;
		File file = new File(fileName);
		BufferedReader reader=null;
		try 
		{
			reader = new BufferedReader(
						 new FileReader(file));
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found "+fileName);
			System.exit(0);
		}
		boolean eof = false;
		String inLine=null;
		int numLines=0;
		while (! eof)
		{
			try 
			{
				inLine=reader.readLine();
				if (inLine==null)
				{
					eof=true;
				} else {
					numLines++;
				}
			} catch (IOException e)
			{
			}
		}
		try 
		{
			reader.close();
		} catch (IOException e)
		{
		}
		
		items = new Comparable[numLines];
		
		try 
		{
			reader = new BufferedReader(
						 new FileReader(file));
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found "+fileName);
			System.exit(0);
		}
		eof = false;
		inLine=null;
		numLines=0;
		while (! eof)
		{
			try 
			{
				inLine=reader.readLine();
				if (inLine==null)
				{
					eof=true;
				} else {
					items[numLines]=inLine;
					numLines++;
				}
			} catch (IOException e)
			{
			}
		}
		try 
		{
			reader.close();
		} catch (IOException e)
		{
		}
		return items;	
	}

    /**
     * This tests one of the sorting algorithms, which sorts it and works out how long the algorithm took to complete.
     * @param type is the the sort name
     * @param items is the data items in a comparable array
     * @return the time taken to complete the algorithm.
     */
	public long testOne(String type, Comparable[] items)
	{
		long start;
		long finish;
		long timeTaken = 0;
		Sorter s = SortFactory.getSorter(type);
		if (s != null)
		{
			start=Calendar.getInstance().getTimeInMillis();
			s.sort(items,0);
			finish=Calendar.getInstance().getTimeInMillis();
			timeTaken=finish-start;
		} else {
			System.out.println("Failed loading the sorter, no sorting will happen.");
		}
		return timeTaken;
	}
    /**
     * This method tests all the values with a given Sort name and tests them against all the data sets
     * @param sortname is the name of the sort in which you want to test
     * @return a string representation of the name and time taken in ms
     */
	public String testAll(String sortname)
	{
		String dataSets[] = {"test3.dat", "test3a.dat", "test3b.dat", "test4.dat",
"test4a.dat", "test4b.dat","test5.dat","test5a.dat","test5b.dat", "test6.dat", "test6a.dat", "test6b.dat"};
		long timeTaken[] = new long[dataSets.length];
		StringBuffer retLine=new StringBuffer();
        for (int i= 0; i<dataSets.length;i++)
		{
			Comparable[] items=this.readData(dataSets[i]);
			//if (items.length>10000 && i>1) break;
			timeTaken[i]=
				this.testOne("sorting2014."+sortname,items);
			retLine.append(dataSets[i]+"\t"+timeTaken[i]+"\n");
		}

		return retLine.toString();
	}
	public static void main(String[] args) {
		SortDemo sd = new SortDemo();
        System.out.println(sd.testAll("QuickSort"));
	}
}
