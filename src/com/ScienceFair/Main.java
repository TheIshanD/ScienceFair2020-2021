package com.ScienceFair;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("dataFiles//travis-addresses-county.geojson");
        File outputFile = new File("dataFiles//homeZipCodes.dat");
        DataCleanser cleanser = new DataCleanser(inputFile, outputFile);

        cleanser.postcode = true;

        cleanser.cleanAddresses();
    }
}


