package com.fm.csv;

import com.fm.db.I2;
import com.fm.model.Driver;
import com.fm.model.Vehicle;

import java.util.ArrayList;
import java.util.List;


public class CsvKonverter {
    public static String PART_DELIM = "DELIMITER";
    public static String DELIMITER = ",";

    public static void saveCsv(String csvFile){
        String[] splitted = csvFile.split(PART_DELIM);
        List<Vehicle> vehicles = parseVehiclesFromCsv(splitted[0]);
        List<Driver> drivers = parseDriversFromCsv(splitted[1]);
        I2.SaveDrivers(drivers);
        I2.SaveVehicles(vehicles);
    }

    private static List<Driver> parseDriversFromCsv(String csvDrivers) {
        String[] lines;
        lines = csvDrivers.split(System.lineSeparator());
        List<Driver> drivers = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] line = lines[i].split(DELIMITER);
            Driver d = new Driver(line[1], line[2], line[3],line[4]);
            drivers.add(d);
        }
        return drivers;
    }

    private static List<Vehicle> parseVehiclesFromCsv(String csvVehicles) {
        List<Vehicle> vehicles = new ArrayList<>();
        String[] lines = csvVehicles.split(System.lineSeparator());
        for (int i = 1; i < lines.length; i++) {
            String[] line = lines[i].split(DELIMITER);
            Vehicle v = new Vehicle(line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]));
            vehicles.add(v);
        }
        return vehicles;
    }

}
