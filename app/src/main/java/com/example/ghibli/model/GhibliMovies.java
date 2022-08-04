package com.example.ghibli.model;

import java.io.Serializable;
import java.util.ArrayList;

public class GhibliMovies implements Serializable {
    private String title;
    private String original_title;
    private String original_title_romanised;
    private String description;
    private String director;
    private String producer;
    private String release_date;
    private String running_time;
    private String rt_score;
    private String url;
    private ArrayList<String> people;
    private int imageCardInt;
    private int position;

    public ArrayList<String> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<String> people) {
        this.people = people;
    }

    public GhibliMovies(String title, String original_title, String original_title_romanised, String description, String director, String producer, String release_date, String running_time, String rt_score, ArrayList<String> people, int imageCardInt, int position, String url) {
        this.title = title;
        this.original_title = original_title;
        this.original_title_romanised = original_title_romanised;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
        this.running_time = running_time;
        this.rt_score = rt_score;
        this.people = people;
        this.imageCardInt = imageCardInt;
        this.position = position;
        this.url = url;
    }

    public GhibliMovies(String title, String originalTitle, String originalTitleRomaji, String description,
                        String director, String producer, String releaseDate,
                        String runningRime, String rating, int imageCardView) {
        this.title = title;
        this.original_title = originalTitle;
        this.original_title_romanised = originalTitleRomaji;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.release_date = releaseDate;
        this.running_time = runningRime;
        this.rt_score = rating;
        this.imageCardInt = imageCardView;
    }

    public GhibliMovies(String title, String originalTitle, String originalTitleRomaji, String description,
                        String director, String producer, String releaseDate, String runningRime,
                        String rating, int imageCardInt, int position) {
        this.title = title;
        this.original_title = originalTitle;
        this.original_title_romanised = originalTitleRomaji;
        this.description = description;
        this.director = director;
        this.producer = producer;
        this.release_date = releaseDate;
        this.running_time = runningRime;
        this.rt_score = rating;
        this.imageCardInt = imageCardInt;
        this.position = position;
    }

    public GhibliMovies(String originalTitle, String originalTitleRomaji, String releaseDate, String rating) {
        this.original_title = originalTitle;
        this.original_title_romanised = originalTitleRomaji;
        this.release_date = releaseDate;
        this.rt_score = rating;
    }

    public GhibliMovies() {
    }

    public String getTitle() {
        return title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOriginal_title_romanised() {
        return original_title_romanised;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setOriginal_title_romanised(String original_title_romanised) {
        this.original_title_romanised = original_title_romanised;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setRunning_time(String running_time) {
        this.running_time = running_time;
    }

    public void setRt_score(String rt_score) {
        this.rt_score = rt_score;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getRunning_time() {
        return running_time;
    }

    public String getRt_score() {
        return rt_score;
    }

    public void setImageCardInt(int imageCardInt) {
        this.imageCardInt = imageCardInt;
    }

    public int getImageCardInt() {
        return imageCardInt;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
