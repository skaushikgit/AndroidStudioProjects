package com.leochin.volleydemo.model;

import java.util.ArrayList;

/**
 * Created by wenhao on 8/20/15.
 */
public class DailyNewsModel {

    private ArrayList<String> images;
    private int type;
    private long id;
    private String ga_prefix;
    private String title;

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
