package com.fm.model.generated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "WarrantStateEnums", schema = "dbo", catalog = "pppk1db")
public class WarrantStateEnumsEntity {
    private int idWarrantState;
    private String state;

    @Id
    @Column(name = "IDWarrantState", nullable = false)
    public int getIdWarrantState() {
        return idWarrantState;
    }

    public void setIdWarrantState(int idWarrantState) {
        this.idWarrantState = idWarrantState;
    }

    @Basic
    @Column(name = "State", nullable = true, length = 6)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarrantStateEnumsEntity that = (WarrantStateEnumsEntity) o;
        return idWarrantState == that.idWarrantState &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWarrantState, state);
    }

    @Override
    public String toString() {
        return "WarrantStateEnumsEntity{" +
                "idWarrantState=" + idWarrantState +
                ", state='" + state + '\'' +
                '}';
    }
}
