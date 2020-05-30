package com.fm.model.generated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Drivers", schema = "dbo", catalog = "pppk1db")
public class DriversEntity {
    private int idDriver;
    private String name;
    private String surname;
    private String phoneNumber;
    private String driversLicenseId;

    @Id
    @Column(name = "IDDriver", nullable = false)
    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Surname", nullable = true, length = 20)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "driversLicenseID", nullable = true, length = 30)
    public String getDriversLicenseId() {
        return driversLicenseId;
    }

    public void setDriversLicenseId(String driversLicenseId) {
        this.driversLicenseId = driversLicenseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriversEntity that = (DriversEntity) o;
        return idDriver == that.idDriver &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(driversLicenseId, that.driversLicenseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriver, name, surname, phoneNumber, driversLicenseId);
    }

    @Override
    public String toString() {
        return "DriversEntity{" +
                "idDriver=" + idDriver +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", driversLicenseId='" + driversLicenseId + '\'' +
                '}';
    }
}
