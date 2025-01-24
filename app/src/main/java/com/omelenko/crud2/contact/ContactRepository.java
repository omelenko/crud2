package com.omelenko.crud2.contact;

import java.util.ArrayList;

public interface ContactRepository {
    ArrayList<Contact> getContacts();
    Contact getContact(int position);
    void addContact(Contact contact);
    void editContact(Contact contact, int position);
    void removeContact(int position);

}
