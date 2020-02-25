package com.fm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "travelWarrants", schema = "dbo", catalog = "pppk1db")
public class TravelWarrantsEntity {
    private int idTwarrant;

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
}
