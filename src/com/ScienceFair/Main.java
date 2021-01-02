package com.ScienceFair;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void findHomes() throws FileNotFoundException {
        File inputFile = new File("dataFiles//Downloaded-Files//travis-addresses-county.geojson");
        File outputFile = new File("dataFiles//Geographic-Coordinates//HomeCoordinates.dat");
        DataParser cleanser = new DataParser(inputFile, outputFile);

        cleanser.coordinates = true;

        cleanser.cleanAddresses();
    }

    public static void filterOpioidTreatments() throws FileNotFoundException {
        File inputFile = new File("dataFiles//Downloaded-Files//OpioidTreatmentProgramsTexas.csv");
        File outputFile = new File("dataFiles//Intermediate-Files//OpioidTreatmentProgramsTravisCounty.dat");
        DataParser cleanser = new DataParser(inputFile, outputFile);

        cleanser.printOpioidTreatmentsInTravisCounty(new File("dataFiles//Downloaded-Files//uniqueHomeZipCodes.dat"));
    }

    public static void filterPharmacies() throws FileNotFoundException {
        File inputFile = new File("dataFiles//Downloaded-Files//pl_pfile_20050523-20201213.csv");
        File outputFile = new File("dataFiles//Intermediate-Files//PharmaciesInTravisCounty.dat");
        DataParser cleanser = new DataParser(inputFile, outputFile);

        cleanser.printPharmecyLocationsInTravisCounty(new File("dataFiles//Downloaded-Files//uniqueHomeZipCodes.dat"));
    }

    public static void determineCoordinatesofPharmacies() throws FileNotFoundException {
        //BE CAREFUL! USES MAPQUEST API TRIALS!

        File inputFile = new File("dataFiles//Intermediate-Files//PharmaciesInTravisCounty.dat");
        File outputFile = new File("dataFiles//Geographic-Coordinates//PharmaciesTravisCountyGeographicCoordinates.dat");
        DataParser cleanser = new DataParser(inputFile, outputFile);

        cleanser.convertToCoordinates();
    }

    public static void main(String[] args) throws FileNotFoundException {
        findHomes();
    }
}


