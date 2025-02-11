package com.omelenko.crud2.contact;

import android.annotation.SuppressLint;

import androidx.databinding.ObservableArrayList;

import com.omelenko.crud2.App;

import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {

    ContactDao dao;

    public ContactRepositoryImpl()
    {
        dao = App.getInstance().getDatabase().contactDao();
    }

    @Override
    public List<Contact> getContacts() {
        return dao.getAll();
    }

    @Override
    public Contact getContact(int position) {
        return dao.getAll().get(position);
    }
    @Override
    public void addContact(Contact contact) {
        dao.insert(contact);
    }

    @Override
    public void editContact(Contact contact) {
        dao.update(contact);
    }

    @Override
    public void removeContact(int position) {
        dao.delete(dao.getAll().get(position));
    }

    @Override
    public void removeContact(Contact contact) {
        dao.delete(contact);
    }

    @Override
    public int getIndexOf(Contact contact) {
        return dao.getAll().indexOf(contact);
    }
}
