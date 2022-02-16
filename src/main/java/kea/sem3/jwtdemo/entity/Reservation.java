package kea.sem3.jwtdemo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int reservationId;

    @CreationTimestamp
    private LocalDateTime reservationDate;


    private int rentalDate;

    public Reservation() {
    }

    public Reservation(int rentalDate) {
        this.rentalDate = rentalDate;
    }
    @ManyToOne
    Car car;

    @ManyToOne
    Member member;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(int rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
