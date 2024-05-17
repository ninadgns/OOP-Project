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
    protected int checkinYear,checkoutYear,checkinDate,checkoutDate;
    //private final String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
         //   "Aug", "Sep", "Oct", "Nov", "Dec" };
    private final int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    CheckInandOut(String checkin, String checkout) {
        if (checkin.isEmpty() || checkout.isEmpty()
                || !checkin.matches("\\d{4}\\d{2}\\d{2}")
                || !checkout.matches("\\d{4}\\d{2}\\d{2}")) {
            this.checkin = null;
            this.checkout = null;
        }
        checkinDate = Integer.parseInt(checkin);
        checkoutDate = Integer.parseInt(checkout);
        int diff=checkoutDate-checkinDate;
        // int monthDiff=(diff%10000)/100;
//        try{
//        if(diff<=0){
//            throws Exception e;
//        }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public void setTotalDays(){
        checkinDate = Integer.parseInt(checkin);
        checkoutDate = Integer.parseInt(checkout);
        int diff=checkoutDate-checkinDate;
        if (diff<=50) {
            this.totalDays = checkoutDate - checkinDate;
        } else {
          int  checkinMon=(checkinDate%10000)/100;
          int  checkoutMon=(checkoutDate%10000)/100;
          int  checkinDay=(checkinDate%100);
          int checkoutDay=(checkoutDate%100);
            if((checkinDate/10000) == (checkoutDate/10000)) {
                this.totalDays = days[checkinMon-1] - checkinDay + checkoutDay;
                for (int i = (checkinMon + 1) % 12; i < checkoutMon; i++) {
                    this.totalDays += days[i % 12];
                }
            }
            else{
                int yearDiff=diff/10000;
                this.totalDays=yearDiff*365;
                for (int i = 0; i < checkoutMon-1; i++) {
                    this.totalDays += days[i % 12];
                }
                for (int i = checkinMon; i < 12; i++) {
                    this.totalDays += days[i % 12];
                }
                this.totalDays += days[checkinMon-1] - checkinDay + checkoutDay;
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
