package com.leaf.news.util;

import com.google.gson.Gson;
import com.leaf.news.NewsList;

public class Utility {
    public static NewsList parseJsonWithGson(final String requestText){
        Gson gson = new Gson();
        return gson.fromJson(requestText, NewsList.class);
    }

}