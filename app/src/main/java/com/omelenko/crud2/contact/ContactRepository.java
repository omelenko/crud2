package com.omelenko.crud2.contact;

import androidx.databinding.ObservableArrayList;

import java.util.List;

public interface ContactRepository {
    List<Contact> getContacts();
    Contact getContact(int position);
    void addContact(Contact contact);
    void editContact(Contact contact);
    void removeContact(int position);
    void removeContact(Contact contact);
    int getIndexOf(Contact contact);

}
