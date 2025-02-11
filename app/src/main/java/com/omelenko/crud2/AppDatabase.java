package com.omelenko.crud2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.omelenko.crud2.contact.Contact;
import com.omelenko.crud2.contact.ContactDao;

@Database(entities = {Contact.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();
}
