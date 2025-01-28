package com.omelenko.crud2.contact;

import androidx.databinding.ObservableArrayList;

public interface ContactRepository {
    ObservableArrayList<Contact> getContacts();
    Contact getContact(int position);
    void addContact(Contact contact);
    void editContact(Contact contact, int position);
    void removeContact(int position);
    void removeContact(Contact contact);
    int getIndexOf(Contact contact);

}
