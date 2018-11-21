package com.dsman.uaapp.Comunities.FragmentComunity;

import android.os.Parcel;
import android.os.Parcelable;

public class ComunityObject implements Parcelable {
    private String namecomunity;
    private int imgcomunity;

    public String getTopicCommunity() {
        return topicCommunity;
    }

    public void setTopicCommunity(String topicCommunity) {
        this.topicCommunity = topicCommunity;
    }

    private String topicCommunity;

    public String getTextDescriptionCommunity() {
        return textDescriptionCommunity;
    }

    public void setTextDescriptionCommunity(String textDescriptionCommunity) {
        this.textDescriptionCommunity = textDescriptionCommunity;
    }

    private String textDescriptionCommunity;

    public ComunityObject(String namecomunity, int imgcomunity, String topicCommunity, String textDescriptionCommunity) {
        this.namecomunity = namecomunity;
        this.imgcomunity = imgcomunity;
        this.topicCommunity = topicCommunity;
        this.textDescriptionCommunity = textDescriptionCommunity;
    }

    public ComunityObject(Parcel in) {
        namecomunity = in.readString();
        imgcomunity = in.readInt();
        topicCommunity = in.readString();
        textDescriptionCommunity = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namecomunity);
        dest.writeInt(imgcomunity);
        dest.writeString(topicCommunity);
        dest.writeString(textDescriptionCommunity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ComunityObject> CREATOR = new Creator<ComunityObject>() {
        @Override
        public ComunityObject createFromParcel(Parcel in) {
            return new ComunityObject(in);
        }

        @Override
        public ComunityObject[] newArray(int size) {
            return new ComunityObject[size];
        }
    };

    public String getNamecomunity() {
        return namecomunity;
    }

    public void setNamecomunity(String namecomunity) {
        this.namecomunity = namecomunity;
    }

    public int getImgcomunity() {
        return imgcomunity;
    }

    public void setImgcomunity(int imgclass) {
        this.imgcomunity = imgcomunity;
    }
}
