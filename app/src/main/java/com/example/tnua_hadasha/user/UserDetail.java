package com.example.tnua_hadasha.user;

import android.widget.Spinner;

public class UserDetail {

    private String firstName;
    private String lastName;
    private String Email;
    private  String password;
    private Spinner Tafkid;

    public  UserDetail(String fName, String lName, String password, String email, String job)
    {

    }

    public UserDetail(String firstName, String lastName, String email, String password, Spinner tafkid) {
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        this.password = password;
        Tafkid = tafkid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Spinner getTafkid() {
        return Tafkid;
    }

}
