package com.ty.gamewingmanagementapp.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private User customer_id;
    @OneToOne
    private Slots slot_id;
    @CreationTimestamp
    private LocalDateTime dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(User customer_id) {
        this.customer_id = customer_id;
    }

    public Slots getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(Slots slot_id) {
        this.slot_id = slot_id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id && Objects.equals(customer_id, booking.customer_id) && Objects.equals(slot_id, booking.slot_id) && Objects.equals(dateTime, booking.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer_id, slot_id, dateTime);
    }
}
