package com.egrobots.prochat.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String id;
    private String email;
    private String username;
    private String password;
    private String profession;
    private String token;
    private boolean available;
    private boolean availableLimit;
    private long availableFrom;
    private long availableTo;

    protected User(Parcel in) {
        id = in.readString();
        email = in.readString();
        username = in.readString();
        password = in.readString();
        profession = in.readString();
        token = in.readString();
        available = in.readByte() != 0;
        availableLimit = in.readByte() != 0;
        availableFrom = in.readLong();
        availableTo = in.readLong();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(boolean availableLimit) {
        this.availableLimit = availableLimit;
    }

    public long getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(long availableFrom) {
        this.availableFrom = availableFrom;
    }

    public long getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(long availableTo) {
        this.availableTo = availableTo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(email);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(profession);
        dest.writeString(token);
        dest.writeByte((byte) (available ? 1 : 0));
        dest.writeByte((byte) (availableLimit ? 1 : 0));
        dest.writeLong(availableFrom);
        dest.writeLong(availableTo);
    }
}
