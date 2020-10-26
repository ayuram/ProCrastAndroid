package com.example.procrast;

import java.util.UUID;

public class User {
    public String firstName;
    public String lastName;
    public UUID id;
    public boolean signedIn = true;
    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        id = UUID.randomUUID();
    }
}