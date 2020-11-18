package com.example.myapplication1113;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    public int age;
    public String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ",name='"+name+"'" + '}';
    }
}
