package com.ScienceFair;

import java.io.*;
import java.util.Scanner;

class DataCleanser {
    PrintWriter out;
    Scanner in;

    boolean houseNumber  = false;
    boolean streetName = false;
    boolean cityName = false;
    boolean stateName = false;
    boolean postcode = false;
    boolean hashNum = false;
    boolean coordinates = false;

    public DataCleanser(){ }

    public DataCleanser(File fileIn, File fileOut) throws FileNotFoundException {
        setInput(fileIn);
        setOutput(fileOut);
    }

    public void setInput(File fileIn) throws FileNotFoundException {
        this.in = new Scanner(fileIn);
    }

    public void setOutput(File fileOut) throws FileNotFoundException {
        this.out = new PrintWriter(new FileOutputStream(fileOut));
    }

    public void cleanAddresses(){



        String hNum = "";
        String street = "";
        String city = "";
        String state = "";
        String zipCode = "";
        String hash = "";
        String longitude = "";
        String latitude = "";

        String line;
        String[] arr;

        while(in.hasNextLine()){
            line = in.nextLine();
            arr = line.split("[\\[,:]");


            if (houseNumber)
                out.print(arr[8].substring(1, arr[8].length() - 1) + " ");
            if(streetName)
                out.print(arr[10] + " ");
            if(cityName)
                out.print(arr[12] + " ");
            if(stateName)
                out.print(arr[16].substring(1, arr[16].length() - 1) + " ");
            if(postcode)
                out.print(arr[18].substring(1, arr[18].length() - 1) + " ");
            if(hashNum)
                out.print(arr[20].substring(1, arr[20].length() - 2) + " ");
            if(coordinates){
                out.print(arr[26] + " ");
                out.print(arr[27].substring(0, arr[27].length() - 3));
            }
            out.println();
        }

        out.close();
    }
}
