package com.example.ghibli.model;

import java.io.Serializable;
import java.util.ArrayList;

public class People implements Serializable {
    private String name;
    private String gender;
    private String age;
    private String eye_color;
    private String hair_color;
    private ArrayList films;
    private int imagePerson;

    public People(String name, String gender, String age, String eye_color, String hair_color, int imagePerson) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.eye_color = eye_color;
        this.hair_color = hair_color;
        this.imagePerson = imagePerson;
    }

    public People(String name) {
        this.name = name;
    }

    public People(String name, String gender, String age, String eye_color, String hair_color, ArrayList films, int imagePerson) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.eye_color = eye_color;
        this.hair_color = hair_color;
        this.films = films;
        this.imagePerson = imagePerson;
    }

    public People(String name, String gender, String age, String eye_color, String hair_color) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.eye_color = eye_color;
        this.hair_color = hair_color;
    }

    public People(String name, int imagePerson) {
        this.name = name;
        this.imagePerson = imagePerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public int getImagePerson() {
        return imagePerson;
    }

    public void setImagePerson(int imagePerson) {
        this.imagePerson = imagePerson;
    }

    public ArrayList getFilms() {
        return films;
    }

    public void setFilms(ArrayList films) {
        this.films = films;
    }
}
