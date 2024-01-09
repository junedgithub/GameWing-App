package com.ty.gamewingmanagementapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class PlayArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int areaId;
    private String sport;
    private double chargePerHour;

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    @ManyToOne
    @JoinColumn(name = "sportclub_id")
    @JsonIgnore
    private SportClub sportClub;
    @OneToOne
    private User manager;

    @OneToMany(mappedBy = "playArea", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Slots> slotsList;

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public double getChargePerHour() {
        return chargePerHour;
    }

    public void setChargePerHour(double chargePerHour) {
        this.chargePerHour = chargePerHour;
    }

    public List<Slots> getSlotsList() {
        return slotsList;
    }

    public void setSlotsList(List<Slots> slotsList) {
        this.slotsList = slotsList;
    }

    public SportClub getSportClub() {
        return sportClub;
    }

    public void setSportClub(SportClub sportClub) {
        this.sportClub = sportClub;
    }
}
