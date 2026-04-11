package com.example.javafxproject;

import java.util.HashMap;

public class UserStorage {

    // Store all users
    public static HashMap<String, User> users = new HashMap<>();

    // Store currently logged-in user
    public static User currentUser;

}