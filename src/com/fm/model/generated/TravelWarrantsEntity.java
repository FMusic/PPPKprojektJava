package com.fm.model.generated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "travelWarrants", schema = "dbo", catalog = "pppk1db")
public class TravelWarrantsEntity {
    private int idTwarrant;
    private DriversEntity driversByDriverId;
    private VehiclesEntity vehicleByVehiclesId;

    @Id
    @Column(name = "IDTwarrant", nullable = false)
    public int getIdTwarrant() {
        return idTwarrant;
    }

    public void setIdTwarrant(int idTwarrant) {
        this.idTwarrant = idTwarrant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelWarrantsEntity that = (TravelWarrantsEntity) o;
        return idTwarrant == that.idTwarrant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTwarrant);
    }

    @Override
    public String toString() {
        return "TW:" +
                " Driver=" + driversByDriverId.getName()+ " " + driversByDriverId.getSurname() +
                ", Vehicle=" + vehicleByVehiclesId.getMaker() + " " + vehicleByVehiclesId.getType();
    }

    @ManyToOne
    @JoinColumn(name = "DriverID", referencedColumnName = "IDDriver")
    public DriversEntity getDriversByDriverId() {
        return driversByDriverId;
    }

    public void setDriversByDriverId(DriversEntity driversByDriverId) {
        this.driversByDriverId = driversByDriverId;
    }
    @ManyToOne
    @JoinColumn(name = "VehicleID", referencedColumnName = "IDVehicle")
    public VehiclesEntity getVehicleByVehiclesId() {
        return vehicleByVehiclesId;
    }

    public void setVehicleByVehiclesId(VehiclesEntity vehicleByVehiclesId) {
        this.vehicleByVehiclesId = vehicleByVehiclesId;
    }


}
