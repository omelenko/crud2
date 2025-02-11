package com.omelenko.crud2.contact;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private String phone;

    /*public Contact(String Name, String Phone) {
        name = Name;
        phone = Phone;
    }*/

    public String getName() {return name;}
    public String getPhone() {return phone;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
