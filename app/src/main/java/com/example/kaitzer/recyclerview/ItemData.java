package com.example.kaitzer.recyclerview;

/**
 * Created by KaiTzer on 14-May-16.
 */
public class ItemData {
    private String title;
    private int imageURL;

    public ItemData(String title, int imageURL)
    {
        this.title = title;
        this.imageURL = imageURL;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }
}
