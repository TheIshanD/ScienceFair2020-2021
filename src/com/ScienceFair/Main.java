package com.ScienceFair;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("travis-addresses-county.geojson");
        File outputFile = new File("Home-Addresses-Travis-County-Cleaned.dat");
        DataCleanser cleanser = new DataCleanser(inputFile, outputFile);

        cleanser.postcode = true;
        cleanser.streetName = true;

        cleanser.cleanAddresses();
    }
}


