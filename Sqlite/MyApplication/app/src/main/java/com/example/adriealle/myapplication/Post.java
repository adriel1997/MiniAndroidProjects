package com.example.adriealle.myapplication;

/**
 * Created by Adriealle on 03-04-2017.
 */
public class Post {

    public String name;
    public String room;
    public String phone;
    public String email;

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Post(String name,String room,String phone, String email) {
        this.name = name;
        this.room=room;
        this.phone=phone;
        this.email = email;
    }

}