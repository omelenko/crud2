package com.omelenko.crud2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.contact.Contact;
import com.omelenko.crud2.contact.ContactRepository;

import javax.inject.Inject;

public class ListViewModel extends AndroidViewModel {
    @Inject
    ContactRepository contactRepository;

    public ListViewModel(@NonNull Application application) {
        super(application);
    }
    public ObservableArrayList<Contact> getContacts()
    {
        return contactRepository.getContacts();
    }
    public Contact getContact(int position)
    {
        return contactRepository.getContact(position);
    }
    public int getContactId(Contact contact)
    {
        return contactRepository.getIndexOf(contact);
    }
    public void editButton_onClick(int position)
    {
        MainActivity.editCall(position);
    }
    public void removeButton_onClick(int position)
    {
        contactRepository.removeContact(position);
    }
}
