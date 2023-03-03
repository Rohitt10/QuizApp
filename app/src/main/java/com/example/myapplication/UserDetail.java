package com.example.myapplication;

import java.io.Serializable;

public class UserDetail implements Serializable {
    String name;
    int javaScore;
    int pythonScore;
    int cppScore;
    int attempt;
    boolean pAttempt;
    boolean jAttempt;
    boolean cAttempt;
    UserDetail(String name)
    {
        this.name=name;
    }
    int totalScore()
    {
        return javaScore+pythonScore+cppScore;
    }
}
