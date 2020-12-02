package com.leaf.news;

public class Title {
    private String title;
    private String desc;
    private String imageUrl;
    private String uri;
    private String time;

    public Title(String title, String desc, String imageUrl, String uri, String time) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.desc = desc;
        this.uri = uri;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDesc() {
        return desc;
    }

    public String getUri() {
        return uri;
    }

    public String getTime() {
        return time;
    }
}