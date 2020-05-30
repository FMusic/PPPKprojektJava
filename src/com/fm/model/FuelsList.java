package com.fm.model;

import com.fm.model.generated.FuelsEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="receipts")
public class FuelsList {
    private List<FuelsEntity> fuels;

    public FuelsList() {
    }

    public FuelsList(List<FuelsEntity> fuels) {
        this.fuels = fuels;
    }

    public List<FuelsEntity> getFuels() {
        return fuels;
    }

    public void setFuels(List<FuelsEntity> fuels) {
        this.fuels = fuels;
    }
}
