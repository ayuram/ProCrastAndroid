package com.example.procrast;

import java.util.UUID;

public class User {
    public String firstName;
    public String lastName;
    public UUID id = UUID.randomUUID();
    public boolean signedIn = true;
    public User(String firstName, String lastName, String email){

    }
}