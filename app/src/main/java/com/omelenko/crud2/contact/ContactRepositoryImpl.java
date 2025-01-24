package com.omelenko.crud2.contact;

import android.annotation.SuppressLint;

import java.util.ArrayList;

public class ContactRepositoryImpl implements ContactRepository {

    ArrayList<Contact> items;

    public ContactRepositoryImpl()
    {
        items = new ArrayList<>();
    }

    @Override
    public ArrayList<Contact> getContacts() {
        return items;
    }

    @Override
    public Contact getContact(int position) {
        return items.get(position);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void addContact(Contact contact) {
        items.add(contact);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void editContact(Contact contact, int position) {
        items.remove(position);
        items.add(position, contact);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void removeContact(int position) {
        items.remove(position);
    }
}
