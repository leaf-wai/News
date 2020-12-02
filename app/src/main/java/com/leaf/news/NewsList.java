package com.leaf.news;

import com.google.gson.annotations.SerializedName;
import com.leaf.news.gson.News;

import java.util.List;

public class NewsList {
    public int code;

    public String msg;

    @SerializedName("newslist")
    public List<News> newsList ;
}
