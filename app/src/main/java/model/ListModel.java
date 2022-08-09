package model;

import com.google.gson.annotations.SerializedName;

public class ListModel {

    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String image;

    public ListModel(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
