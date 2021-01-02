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

    public static void filterOpioidTreatments() throws FileNotFoundException {
        File inputFile = new File("dataFiles//OpioidTreatmentProgramsTexas.csv");
        File outputFile = new File("dataFiles//OpioidTreatmentProgramsTravisCounty.dat");
        DataCleanser cleanser = new DataCleanser(inputFile, outputFile);

        cleanser.printOpioidTreatmentsInTravisCounty(new File("dataFiles//uniqueHomeZipCodes.dat"));
    }

    public static void filterPharmacies() throws FileNotFoundException {
        File inputFile = new File("dataFiles//pl_pfile_20050523-20201213.csv");
        File outputFile = new File("dataFiles//PharmacysInTravisCounty.dat");
        DataCleanser cleanser = new DataCleanser(inputFile, outputFile);

        cleanser.printPharmecyLocationsInTravisCounty(new File("dataFiles//uniqueHomeZipCodes.dat"));
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("dataFiles//PharmacysInTravisCounty.dat");
        File outputFile = new File("dataFiles//PharmacysTravisCountyGeographicCoordinates.dat");
        DataCleanser cleanser = new DataCleanser(inputFile, outputFile);

        cleanser.convertToCoordinates();
        //System.out.println(APIMethods.geocode("1601-Trinity-St,78712,Austin"));
    }
}


