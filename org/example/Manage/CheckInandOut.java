package org.example.Manage;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class CheckInandOut {
    private String checkin, checkout;
    private int totalCost, totalDays;
    private boolean payment = false;
    private String[] dateOfCheckIn;
    private String[] dateOfCheckOut;
    protected int checkinDay, checkoutDay,checkinMon, checkoutMon,checkinYear,checkoutYear;
    //private final String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
         //   "Aug", "Sep", "Oct", "Nov", "Dec" };
    private final int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    CheckInandOut(String checkin, String checkout) {
        if (checkin.isEmpty() || checkout.isEmpty()
                || !checkin.matches("\\d{2} \\d{2} \\d{4}")
                || !checkout.matches("\\d{2} \\d{2} \\d{4}")) {
            this.checkin = null;
            this.checkout = null;
        }
        this.checkin = checkin;
        this.checkout = checkout;
        dateOfCheckIn = this.checkin.split(" ");
        dateOfCheckOut = this.checkout.split(" ");
    }

    public void setTotalDays() {
        checkinDay = Integer.parseInt(dateOfCheckIn[0]);
        checkoutDay = Integer.parseInt(dateOfCheckOut[0]);
        checkinMon = Integer.parseInt(dateOfCheckIn[1]);
        checkoutMon = Integer.parseInt(dateOfCheckOut[1]);
        checkinYear = Integer.parseInt(dateOfCheckIn[2]);
        checkoutYear = Integer.parseInt(dateOfCheckOut[2]);

        if (checkinMon == checkoutMon) {
            this.totalDays = checkoutDay - checkinDay;
        } else if(checkinYear == checkoutYear) {
            this.totalDays = days[checkinMon-1] - checkinDay + checkoutDay;
            for (int i = (checkinMon + 1) % 12; i < checkoutMon; i++) {
                this.totalDays += days[i % 12];
            }
        }
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public boolean getPayment() {
        return this.payment;
    }

    public void setTotalCost(int costPerNight) {
        this.totalCost = costPerNight * this.totalDays;
    }

    public int getTotalCost() {
        return this.totalCost;
    }

    public int getTotalDays() {
        return this.totalDays;
    }
}
