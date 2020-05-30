package com.fm.model.generated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Vehicles", schema = "dbo", catalog = "pppk1db")
public class VehiclesEntity {
    private int idVehicle;
    private String type;
    private String maker;
    private Integer yearOfMaking;
    private Integer miles;

    @Id
    @Column(name = "IDVehicle", nullable = false)
    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    @Basic
    @Column(name = "Type", nullable = true, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "Maker", nullable = true, length = 10)
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Basic
    @Column(name = "YearOfMaking", nullable = true)
    public Integer getYearOfMaking() {
        return yearOfMaking;
    }

    public void setYearOfMaking(Integer yearOfMaking) {
        this.yearOfMaking = yearOfMaking;
    }

    @Basic
    @Column(name = "miles", nullable = true)
    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiclesEntity that = (VehiclesEntity) o;
        return idVehicle == that.idVehicle &&
                Objects.equals(type, that.type) &&
                Objects.equals(maker, that.maker) &&
                Objects.equals(yearOfMaking, that.yearOfMaking) &&
                Objects.equals(miles, that.miles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVehicle, type, maker, yearOfMaking, miles);
    }

    @Override
    public String toString() {
        return "VehiclesEntity{" +
                "idVehicle=" + idVehicle +
                ", type='" + type + '\'' +
                ", maker='" + maker + '\'' +
                ", yearOfMaking=" + yearOfMaking +
                ", miles=" + miles +
                '}';
    }
}
