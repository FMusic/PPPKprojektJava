package com.fm.db;

import com.fm.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class I2 {

    public static void saveCsv(String csvFile){
        List<Vehicle> vehicles = parseVehiclesFromCsv(csvFile);
        SaveVehiclesToDb(vehicles);
    }

    private static void SaveVehiclesToDb(List<Vehicle> vehicles) {
        //todo - Prepared Statements
        //todo - transactions
    }

    private static List<Vehicle> parseVehiclesFromCsv(String csvFile) {
        List<Vehicle> vehicles = new ArrayList<>();
        //todo
        return vehicles;
    }
}
