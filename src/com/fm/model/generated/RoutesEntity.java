package com.fm.model.generated;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Routes", schema = "dbo", catalog = "pppk1db")
public class RoutesEntity {
    private int idRoute;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    private String coordA;
    private String coordB;
    private Integer distanceInKm;
    private Integer avgV;
    private Integer fuelSpent;
    private TravelWarrantsEntity travelWarrantsByWarrantId;

    @Id
    @Column(name = "IDRoute", nullable = false)
    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    @Basic
    @Column(name = "DateFrom", nullable = true)
    public Timestamp getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Timestamp dateFrom) {
        this.dateFrom = dateFrom;
    }

    @Basic
    @Column(name = "DateTo", nullable = true)
    public Timestamp getDateTo() {
        return dateTo;
    }

    public void setDateTo(Timestamp dateTo) {
        this.dateTo = dateTo;
    }

    @Basic
    @Column(name = "CoordA", nullable = true, length = 20)
    public String getCoordA() {
        return coordA;
    }

    public void setCoordA(String coordA) {
        this.coordA = coordA;
    }

    @Basic
    @Column(name = "CoordB", nullable = true, length = 20)
    public String getCoordB() {
        return coordB;
    }

    public void setCoordB(String coordB) {
        this.coordB = coordB;
    }

    @Basic
    @Column(name = "DistanceInKm", nullable = true)
    public Integer getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(Integer distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    @Basic
    @Column(name = "AvgV", nullable = true)
    public Integer getAvgV() {
        return avgV;
    }

    public void setAvgV(Integer avgV) {
        this.avgV = avgV;
    }

    @Basic
    @Column(name = "FuelSpent", nullable = true)
    public Integer getFuelSpent() {
        return fuelSpent;
    }

    public void setFuelSpent(Integer fuelSpent) {
        this.fuelSpent = fuelSpent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutesEntity that = (RoutesEntity) o;
        return idRoute == that.idRoute &&
                Objects.equals(dateFrom, that.dateFrom) &&
                Objects.equals(dateTo, that.dateTo) &&
                Objects.equals(coordA, that.coordA) &&
                Objects.equals(coordB, that.coordB) &&
                Objects.equals(distanceInKm, that.distanceInKm) &&
                Objects.equals(avgV, that.avgV) &&
                Objects.equals(fuelSpent, that.fuelSpent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoute, dateFrom, dateTo, coordA, coordB, distanceInKm, avgV, fuelSpent);
    }

    @ManyToOne
    @JoinColumn(name = "WarrantID", referencedColumnName = "IDTwarrant")
    public TravelWarrantsEntity getTravelWarrantsByWarrantId() {
        return travelWarrantsByWarrantId;
    }

    public void setTravelWarrantsByWarrantId(TravelWarrantsEntity travelWarrantsByWarrantId) {
        this.travelWarrantsByWarrantId = travelWarrantsByWarrantId;
    }

    @Override
    public String toString() {
        return "RoutesEntity{" +
                "idRoute=" + idRoute +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", coordA='" + coordA + '\'' +
                ", coordB='" + coordB + '\'' +
                ", distanceInKm=" + distanceInKm +
                ", avgV=" + avgV +
                ", fuelSpent=" + fuelSpent +
                ", travelWarrantsByWarrantId=" + travelWarrantsByWarrantId +
                '}';
    }
}
