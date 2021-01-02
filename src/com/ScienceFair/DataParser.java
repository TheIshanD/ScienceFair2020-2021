package com.ScienceFair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class DataParser {
    PrintWriter out;
    Scanner in;

    boolean houseNumber = false;
    boolean streetName = false;
    boolean cityName = false;
    boolean stateName = false;
    boolean postcode = false;
    boolean hashNum = false;
    boolean coordinates = false;

    public DataParser() {
    }

    public DataParser(File fileIn, File fileOut) throws FileNotFoundException {
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

        HashSet<String> removeDups = new HashSet<>();

        while (in.hasNextLine()) {
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
                removeDups.add(ans.substring(0, ans.length() - 1));
            else
                removeDups.add("");


        }

        for (String str : removeDups) {
            out.println(str);
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

    public void printPharmecyLocationsInTravisCounty(File uniqueZipCodes) throws FileNotFoundException {
        Scanner temp = new Scanner(uniqueZipCodes);
        HashSet<String> set = new HashSet();
        String line;

        while (temp.hasNextLine()) {
            line = temp.nextLine();
            set.add(line);
        }

        in.useDelimiter(",");
        in.nextLine();

        ArrayList<String> removeDups = new ArrayList<>();

        String[] arr;
        while (in.hasNextLine()) {
            arr = in.nextLine().split(",");
            if (arr[3].equals("\"Austin\"") && arr[4].equals("\"TX\"")) {
                //TODO: the below code is longer than O(n^2).
                // This can  be optimized to O(n) by changing the csv file format
                for (String str : set) {
                    if (arr[5].equals("\"" + str + "\"")) {
                        String streetName = arr[1].substring(1, arr[1].length() - 1).replace(" ", "-");
                        String zipCode = arr[5].substring(1, arr[5].length() - 1);
                        String cityCode = "Austin";
                        removeDups.add(streetName + "," + zipCode + "," + cityCode);
                    }
                }
            }
        }

        for (String str : removeDups) {
            out.println(str);
        }

        out.close();
    }

    public void convertToCoordinates() {
        HashSet<String> removeDups = new HashSet<>();

        while (in.hasNextLine()) {
            String location = in.nextLine();
            removeDups.add(APIMethods.geocode(location));
        }

        for (String str : removeDups) {
            out.println(str);
        }

        out.close();
    }


}
