package com.ScienceFair;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void findZipCodes() throws FileNotFoundException {
        File inputFile = new File("dataFiles//travis-addresses-county.geojson");
        File outputFile = new File("dataFiles//cleanedData.dat");
        DataCleanser cleanser = new DataCleanser(inputFile, outputFile);

        cleanser.postcode = true;

        cleanser.cleanAddresses();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("dataFiles//OpioidTreatmentProgramsTexas.csv");
        File outputFile = new File("dataFiles//OpioidTreatmentProgramsTravisCounty.dat");
        DataCleanser cleanser = new DataCleanser(inputFile, outputFile);

        cleanser.printOpioidTreatmentsInTravisCounty(new File("dataFiles//uniqueHomeZipCodes.dat"));
    }
}


