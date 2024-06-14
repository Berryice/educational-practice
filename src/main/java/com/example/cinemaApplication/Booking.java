package com.example.cinemaApplication;

import jakarta.persistence.*;

@Entity
@Table(name="booking")
public class Booking {
    public Booking(Long ticket_id, String customer, String movie, int hall, int line, int place, String date) {
        this.ticket_id = ticket_id;
        this.customer = customer;
        this.movie = movie;
        this.hall = hall;
        this.line = line;
        this.place = place;
        this.date = date;
    }
    public Booking() {

    }
    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_id;
    private String customer;
    private  String movie;
    private int hall;
    private  int line;
    private int place;
    private String date;

}
