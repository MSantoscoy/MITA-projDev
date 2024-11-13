package com.example.demo.passenger;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
//import org.springframework.stereotype.Component;

@Entity
@Table
public class Passenger {
    @Id
    @SequenceGenerator(
            name = "passenger_sequence",
            sequenceName = "passenger_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "passenger_sequence"
    )
    private Integer ID;
    private Integer UserID; // relates passenger to account
    private String fName;
    private String lName;
    private int contactNum;

    // ID will be determined by the database
    public Passenger(int userID, String fName, String lName, int contactNum) {
        this.UserID = userID;
        this.fName = fName;
        this.lName = lName;
        this.contactNum = contactNum;
    }

    // Getters and Setters
    public int getContactNum() {
        return contactNum;
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public int getUserID() {
        return UserID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "ID=" + ID +
                ", UserID=" + UserID +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", contactNum=" + contactNum +
                '}';
    }
}
