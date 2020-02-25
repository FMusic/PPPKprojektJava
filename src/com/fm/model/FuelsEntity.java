package com.fm.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Fuels", schema = "dbo", catalog = "pppk1db")
public class FuelsEntity {
    private int idFuel;
    private Date dateWhen;
    private Object timeWhen;
    private String location;
    private Integer quantity;
    private Integer price;

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
    public Date getDateWhen() {
        return dateWhen;
    }

    public void setDateWhen(Date dateWhen) {
        this.dateWhen = dateWhen;
    }

    @Basic
    @Column(name = "TimeWhen", nullable = true)
    public Object getTimeWhen() {
        return timeWhen;
    }

    public void setTimeWhen(Object timeWhen) {
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
}
