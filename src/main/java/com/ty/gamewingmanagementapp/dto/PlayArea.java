package com.ty.gamewingmanagementapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class PlayArea {
    public SportClub getSportClub() {
        return sportClub;
    }

    public void setSportClub(SportClub sportClub) {
        this.sportClub = sportClub;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int areaId;
    private String sport;
    private double chargePerHour;
    @ManyToOne
    @JoinColumn(name = "sportclub_id")
    @JsonIgnore
    private SportClub sportClub;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayArea playArea = (PlayArea) o;
        return areaId == playArea.areaId && Double.compare(chargePerHour, playArea.chargePerHour) == 0 && Objects.equals(sport, playArea.sport) && Objects.equals(sportClub, playArea.sportClub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, sport, chargePerHour, sportClub);
    }
}
