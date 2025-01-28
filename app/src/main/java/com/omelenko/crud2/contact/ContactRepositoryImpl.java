package com.omelenko.crud2.contact;

import android.annotation.SuppressLint;

import androidx.databinding.ObservableArrayList;

public class ContactRepositoryImpl implements ContactRepository {

    ObservableArrayList<Contact> items;

    public ContactRepositoryImpl()
    {
        items = new ObservableArrayList<>();
    }

    @Override
    public ObservableArrayList<Contact> getContacts() {
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

    @Override
    public void removeContact(Contact contact) {
        items.remove(contact);
    }

    @Override
    public int getIndexOf(Contact contact) {
        return items.indexOf(contact);
    }
}
