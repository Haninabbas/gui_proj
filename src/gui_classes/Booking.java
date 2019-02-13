package gui_classes;

import java.sql.Date;
import java.util.Observable;

public class Booking extends Observable {
    private int ID;
    private Date date;
    private Payment payment;

    public Booking(int ID, Date date, Payment payment) {
        this.ID = ID;
        this.date = date;
        this.payment = payment;
        setChanged();
        notifyObservers();
    }

    public int getID() {
        return ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
