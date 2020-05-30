package com.fm.model.generated;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="receipt")
@Entity
@Table(name = "Fuels", schema = "dbo", catalog = "pppk1db")
public class FuelsEntity {
    private int idFuel;
    private Timestamp dateWhen;
    private Time timeWhen;
    private String location;
    private Integer quantity;
    private Integer price;
    private DriversEntity driversByDriverId;
    private VehiclesEntity vehiclesByVehicleId;

    @Id
    @Column(name = "IDFuel", nullable = false)
    public int getIdFuel() {
        return idFuel;
    }

    public void setIdFuel(int idFuel) {
        this.idFuel = idFuel;
    }

    @Basic
    @Column(name = "DateWhen", nullable = true)
    public Timestamp getDateWhen() {
        return dateWhen;
    }

    public void setDateWhen(Timestamp dateWhen) {
        this.dateWhen = dateWhen;
    }

    @Basic
    @Column(name = "TimeWhen", nullable = true)
    public Time getTimeWhen() {
        return timeWhen;
    }

    public void setTimeWhen(Time timeWhen) {
        this.timeWhen = timeWhen;
    }

    @Basic
    @Column(name = "Location", nullable = true, length = 20)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "Quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelsEntity that = (FuelsEntity) o;
        return idFuel == that.idFuel &&
                Objects.equals(dateWhen, that.dateWhen) &&
                Objects.equals(timeWhen, that.timeWhen) &&
                Objects.equals(location, that.location) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFuel, dateWhen, timeWhen, location, quantity, price);
    }

    @ManyToOne
    @JoinColumn(name = "DriverId", referencedColumnName = "IDDriver")
    public DriversEntity getDriversByDriverId() {
        return driversByDriverId;
    }

    public void setDriversByDriverId(DriversEntity driversByDriverId) {
        this.driversByDriverId = driversByDriverId;
    }

    @ManyToOne
    @JoinColumn(name = "VehicleID", referencedColumnName = "IDVehicle")
    public VehiclesEntity getVehiclesByVehicleId() {
        return vehiclesByVehicleId;
    }

    public void setVehiclesByVehicleId(VehiclesEntity vehiclesByVehicleId) {
        this.vehiclesByVehicleId = vehiclesByVehicleId;
    }

    @Override
    public String toString() {
        return "FuelsEntity{" +
                "idFuel=" + idFuel +
                ", dateWhen=" + dateWhen +
                ", timeWhen=" + timeWhen +
                ", location='" + location + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", driversByDriverId=" + driversByDriverId +
                ", vehiclesByVehicleId=" + vehiclesByVehicleId +
                '}';
    }
}
