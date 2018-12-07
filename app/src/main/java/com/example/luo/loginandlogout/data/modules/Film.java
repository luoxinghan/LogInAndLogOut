package com.example.luo.loginandlogout.data.modules;

import java.io.Serializable;
import java.util.Date;

public class Film implements Serializable {

    private String filmsPosterUrl;

    private String title;

    private Date showData;

    private String describe;

    public Film() {
    }

    public Film(String filmsPosterUrl, String title, Date showData, String describe) {
        this.filmsPosterUrl = filmsPosterUrl;
        this.title = title;
        this.showData = showData;
        this.describe = describe;
    }

    public String getFilmsPosterUrl() {
        return filmsPosterUrl;
    }

    public void setFilmsPosterUrl(String filmsPosterUrl) {
        this.filmsPosterUrl = filmsPosterUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getShowData() {
        return showData;
    }

    public void setShowData(Date showData) {
        this.showData = showData;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
