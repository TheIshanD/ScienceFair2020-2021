package com.ScienceFair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
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
        String ans;

        while(in.hasNextLine()){
            line = in.nextLine();
            arr = line.split("[\\[,:]");

            ans = "";

            if (houseNumber)
                ans += arr[8].substring(1, arr[8].length() - 1) + ",";
            if (streetName)
                ans += arr[10].substring(1, arr[10].length() - 1) + ",";
            if (cityName)
                ans += arr[12].substring(1, arr[12].length() - 1) + ",";
            if (stateName)
                ans += arr[16].substring(1, arr[16].length() - 1) + ",";
            if (postcode)
                ans += arr[18].substring(1, arr[18].length() - 1) + ",";
            if (hashNum)
                ans += arr[20].substring(1, arr[20].length() - 2) + ",";
            if (coordinates) {
                ans += arr[26] + ",";
                ans += arr[27].substring(0, arr[27].length() - 3);
            }

            if (ans.length() > 0)
                out.println(ans.substring(0, ans.length() - 1));
            else
                out.println(ans);
        }

        out.close();
    }

    public void printUniqueLines() {
        String line;
        HashSet<String> set = new HashSet<>();
        while (in.hasNextLine()) {
            line = in.nextLine();
            set.add(line);
        }

        for (String s : set) {
            out.println(s);
        }
        out.close();
    }

    public void printOpioidTreatmentsInTravisCounty(File uniqueZipCodes) throws FileNotFoundException {
        Scanner temp = new Scanner(uniqueZipCodes);
        HashSet<String> set = new HashSet();
        String line;

        while (temp.hasNextLine()) {
            line = temp.nextLine();
            set.add(line);
        }

        in.useDelimiter(",");
        in.nextLine();

        //TODO: the below code is longer than O(n^2).
        // This can  be optimized to O(n) by changing the csv file format
        while (in.hasNextLine()) {
            line = in.nextLine();
            for (String str : set) {
                if (line.contains(str)) {
                    out.println(line);
                }
            }
        }

        out.close();
    }

}
