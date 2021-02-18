package com.study.moviecatalog.model;

public class MovieDetail {

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private String id;
    public MovieDetail(String id, String name, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public MovieDetail() {
    }

    private String name;
    private String description;

}
