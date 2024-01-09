package com.ty.gamewingmanagementapp.dto;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Slots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotId;
    private String sportType;
    private SlotStatus slotStatus;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sportclub_id")
    private SportClub sportClub;
    @OneToOne
    private Booking booking;

    public SportClub getSportClub() {
        return sportClub;
    }

    public void setSportClub(SportClub sportClub) {
        this.sportClub = sportClub;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slots slots = (Slots) o;
        return slotId == slots.slotId && Objects.equals(sportType, slots.sportType) && slotStatus == slots.slotStatus && Objects.equals(sportClub, slots.sportClub) && Objects.equals(booking, slots.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotId, sportType, slotStatus, sportClub, booking);
    }
}
