/**
 * This class tests how long ThreeSumFast takes to run given a specific size of random ints
 * <p>
 * This class reads a file specified by the user of unique random ints. These ints are placed into
 * an integer array and then used as the parameter for the ThreeSumFast algorithm from the algs4
 * library. The class times how long this processes takes by using the stop watch class also in
 * the algs4 library. Finally, it prints out how long the processes took to run.
 * <p>
 * author Charles Ray and Alfredo Sandoval-Luis
 * edu.uwp.cs.340.course CSCI 340 - Data Structures/Algotrithm Design
 * edu.uwp.cs.340.section 001
 * edu.uwp.cs.340.assignment 2
 * bugs none
 */

import edu.princeton.cs.algs4.ThreeSumFast;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        int size = 32000;
        int [] integerList = new int [size];
        int index = 0;
        File inputFile = new File("src/32Kints.txt");
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            // Sorting data into respective lists based on their type
            while (scanner.hasNextInt() && index < size) {
                // Read the next integer and insert it into the array at the current index
                integerList[index] = scanner.nextInt();
                index++; // Increment the index for the next insertion
            }
            lineScanner.close();
        }
        scanner.close();
        
        //start timer
        Stopwatch stopwatch = new Stopwatch();
        //run ThreeSumFast
        ThreeSumFast.count(integerList);
        //stop timer
        double time = stopwatch.elapsedTime();
        //print out how long ThreeSumFast took to run
        System.out.println(time);
    }
}

