
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * Lab 7 CSIT 150 spring 2017
 * Created by harmssk on 3/2/2017.
 *
 * A binary file named doubles.dat is provided with this lab.
 * This file has a list of numbers (doubles) such as 10.2, 20, 5.1, 8, 9.9.
 * This is a binary file, so it is not readable.
 * It does not contain the commas between the numbers.
 * We do not know how many numbers are in the file.

 Read the numbers stored in the binary file into an array or ArrayList.
 Output the values and their average.

 Use Exceptions to verify the file is found.
 use exceptions to keep reading from the file until the end of file is found.
 *
 *
 */
public class Lab7 {

    /**
     * Prompts the user to enter the name of the file they wish to analyze
     *
     * @return file name to analyze
     */
    public static String getFileName() {
        boolean typeFlag = false;
        String fileName = "";
        while (!typeFlag) {
            String prompt = "Please input the name of the file you wish\n"
                    + "to analyse. You will be asked to enter a\n"
                    + "file name until a valid file name is provided.\n"
                    + "The file name must have a '.dat' or '.csv' extension.\n";
            fileName = JOptionPane.showInputDialog(null, prompt,
                    "Enter File Name", 1);
            if (fileName.endsWith("dat") || fileName.endsWith("csv")) {
                typeFlag = true;
            }
        }
        return fileName;
    }

    /**
     * This method accepts .dat file type and attempts to establish a connection
     * with the file and will prompt the user to enter another file name if the file is not found.
     * Uses a try/catch block to catch "FileNotFoundException".
     * @param inputFile file name to establish connection to
     * @return the data input stream to read the contents of the binary file
     */
    public static DataInputStream openBinaryFile() {
        boolean fileFound = false;
        DataInputStream fileDIS = null;

            /*
            Your code goes here to
            within a try/catch block,
            Ask user for an input file (call the getFileName method)
            if the input file name it is a valid file,
             open the input file as a DataInputStream
            If it is not a valid file, keep asking the user for a valid file.
             */
            try {
                File file = new File(getFileName());
                FileInputStream fileInput = new FileInputStream(file);
                fileDIS = new DataInputStream(fileInput);
            } catch (FileNotFoundException e) {
                System.out.println("Error message " + e.getMessage());
            }

        return fileDIS;
    }

    /**
     * This method reads a .dat file and assigns each double to an array or array list - your choice
     * use a try/catch block and catch the "EOFException" to stop reading the numbers from the file.
     * you will need to catch other errors as well.
     * If you use an array, you will earn bonus points.
     * @param numbers   array list to assign contents of file to
     * @param inputFile object that reads the .dat file
     * @return array list or array containing the doubles in the .dat file
     */
    public static ArrayList<Double> getNumbers(DataInputStream inputFile) {
        // public static double[] getDatNumbers(DataInputStream inputFile) {   //bonus option
        boolean endOfFile = false;
        ArrayList<Double> numbers = new ArrayList<Double> ();

            try {
                while (!endOfFile) {
                    numbers.add(inputFile.readDouble());
                }
            }
                catch(EOFException e){
                    endOfFile = true;
            }catch(IOException e){
                e.printStackTrace();
            }

        return numbers;
    }

    public static Double getAverage(ArrayList<Double> numbers){
        
    }

    /**

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //determines which methods to run based on file type
        DataInputStream dataInputFile = openBinaryFile();
        ArrayList<Double> numbers = new ArrayList<Double>();
        numbers = getNumbers(dataInputFile);
        //output the numbers and their average.
        for(int i = 0; i < numbers.size(); i++) {
            Double number = numbers.get(i);
            System.out.println(number);
        }
        // Use methods appropriately
    }

}

