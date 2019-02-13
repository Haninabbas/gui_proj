package gui_classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;

public class Baby_sitter extends Person{
    private double price_hour;
    private int ID;
    private ArrayList<Booking> bookings;
    private ArrayList<Rating> ratings;
    private ArrayList<Payment> payments;

    public Baby_sitter(int ID,String username, String name, String phone, String email, String gender, String password, Date birthdate, Blob image, double price_hour) {
        super(username, name, phone, email, gender, password, birthdate, image);
        this.price_hour = price_hour;
        bookings = new ArrayList<>();
        ratings = new ArrayList<>();
        payments = new ArrayList<>();
        this.ID=ID;
    }

    public double getPrice_hour() {
        return price_hour;
    }

    public void setPrice_hour(double price_hour) {
        this.price_hour = price_hour;
    }
    public void addRating(Rating rating){
        ratings.add(rating);
    }
    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public void addPayment(Payment payment){
        payments.add(payment);
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public int getID() {
        return ID;
    }
}




