package com.omelenko.crud2.contact;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Contact implements Parcelable {
    private final String name;
    private final String phone;

    public static final Creator<Contact> CREATOR = new Creator<>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public Contact(String Name, String Phone) {
        name = Name;
        phone = Phone;
    }

    protected Contact(Parcel in) {
        name = in.readString();
        phone = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phone);
    }

    public String getName() {return name;}
    public String getPhone() {return phone;}
}
