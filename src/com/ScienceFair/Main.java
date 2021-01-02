package com.ScienceFair;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void findHomes() throws FileNotFoundException {
        File inputFile = new File("dataFiles//travis-addresses-county.geojson");
        File outputFile = new File("dataFiles//HomeCoordinates.dat");
        DataParser cleanser = new DataParser(inputFile, outputFile);

        cleanser.coordinates = true;

        cleanser.cleanAddresses();
    }

    public static void filterOpioidTreatments() throws FileNotFoundException {
        File inputFile = new File("dataFiles//OpioidTreatmentProgramsTexas.csv");
        File outputFile = new File("dataFiles//OpioidTreatmentProgramsTravisCounty.dat");
        DataParser cleanser = new DataParser(inputFile, outputFile);

        cleanser.printOpioidTreatmentsInTravisCounty(new File("dataFiles//uniqueHomeZipCodes.dat"));
    }

    public static void filterPharmacies() throws FileNotFoundException {
        File inputFile = new File("dataFiles//pl_pfile_20050523-20201213.csv");
        File outputFile = new File("dataFiles//PharmacysInTravisCounty.dat");
        DataParser cleanser = new DataParser(inputFile, outputFile);

        cleanser.printPharmecyLocationsInTravisCounty(new File("dataFiles//uniqueHomeZipCodes.dat"));
    }

    public static void determineCoordinatesofPharmacies() throws FileNotFoundException {
        //BE CAREFUL! USES MAPQUEST API TRIALS!

        File inputFile = new File("dataFiles//PharmacysInTravisCounty.dat");
        File outputFile = new File("dataFiles//PharmacysTravisCountyGeographicCoordinates.dat");
        DataParser cleanser = new DataParser(inputFile, outputFile);

        cleanser.convertToCoordinates();
    }

    public static void removeDuplicates(File input, File output) {

    }

    public static void main(String[] args) throws FileNotFoundException {
        findHomes();
    }
}


