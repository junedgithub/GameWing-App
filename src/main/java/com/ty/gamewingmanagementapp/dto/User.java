package com.ty.gamewingmanagementapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public SportClub getSportClubs() {
        return sportClubs;
    }

    public void setSportClubs(SportClub sportClubs) {
        this.sportClubs = sportClubs;
    }

    private Role role;
    @OneToOne
    private Booking booking;
    @OneToOne
    @JsonIgnore
    private SportClub sportClubs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;   //equal
        if (o == null || getClass() != o.getClass()) return false;   //not equal
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && role == user.role && Objects.equals(booking, user.booking) && Objects.equals(sportClubs, user.sportClubs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, role, booking, sportClubs);
    }
}
