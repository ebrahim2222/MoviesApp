package com.example.moviesapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {

    private String name,desc,rating,link;
    private int image;

    public Movies() {
    }

    public Movies(String name, String desc, String rating, String link, int image) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
        this.link = link;
        this.image = image;
    }

    protected Movies(Parcel in) {
        name = in.readString();
        desc = in.readString();
        rating = in.readString();
        link = in.readString();
        image = in.readInt();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeString(rating);
        dest.writeString(link);
        dest.writeInt(image);
    }
}
