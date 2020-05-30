package com.fm.db;

import com.fm.model.Driver;
import com.fm.model.Vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class I2 {
    // todo: Transactions

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlserver://DESKTOP-OSC7H6E\\SQLEXPRESS:64725;database=pppk1db","pppk","pppk");
    }

    public static void SaveVehicles(List<Vehicle> vehicles) throws SQLException {
        String sql = "insert into Vehicles(Type, Maker, YearOfMaking, miles) values(?,?,?,?)";
        Connection conn = getConnection();
        vehicles.forEach(x->{
            try {
                PreparedStatement psVehicle = conn.prepareStatement(sql);
                psVehicle.setString(1, x.getType());
                psVehicle.setString(2, x.getMaker());
                psVehicle.setInt(3, x.getYearOfMaking());
                psVehicle.setInt(4, x.getMiles());
                psVehicle.execute();
                conn.commit();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });
        conn.close();
    }

    public static void SaveDrivers(List<Driver> drivers) throws SQLException {
        String sql = "insert into Drivers(Name, Surname, phoneNumber, driversLicenseID) values(?,?,?,?)";
        Connection conn = getConnection();
        drivers.forEach(x->{
            PreparedStatement psDriver = null;
            try {
                psDriver = conn.prepareStatement(sql);
                psDriver.setString(1, x.getName());
                psDriver.setString(2, x.getSurname());
                psDriver.setString(3, x.getPhoneNumber());
                psDriver.setString(4,x.getDriversLicenseId());
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
