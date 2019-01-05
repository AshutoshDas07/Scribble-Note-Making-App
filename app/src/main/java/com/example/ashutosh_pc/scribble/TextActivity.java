package com.example.ashutosh_pc.scribble;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

public class TextActivity implements Parcelable{

    private String headtext, date, description;


    protected TextActivity(Parcel in) {
        headtext = in.readString();
        date = in.readString();
        description = in.readString();
    }

    public static final Creator<TextActivity> CREATOR = new Creator<TextActivity>() {
        @Override
        public TextActivity createFromParcel(Parcel in) {
            return new TextActivity(in);
        }

        @Override
        public TextActivity[] newArray(int size) {
            return new TextActivity[size];
        }
    };

    public void setHeadtext(String headtext) {
        this.headtext = headtext;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadtext() {
        return headtext;
    }

    public String getDate() {
        return date;
    }

    public TextActivity(String headtext, String date,String description) {

        this.headtext = headtext;
        this.date = date;
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(headtext);
        parcel.writeString(date);
        parcel.writeString(description);
    }
}
