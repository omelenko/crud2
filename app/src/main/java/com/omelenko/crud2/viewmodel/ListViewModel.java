package com.omelenko.crud2.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.AndroidViewModel;

import com.omelenko.crud2.App;
import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.contact.Contact;
import com.omelenko.crud2.contact.ContactRepository;

import java.util.List;

import javax.inject.Inject;

public class ListViewModel extends AndroidViewModel {
    @Inject
    ContactRepository contactRepository;
    public ListViewModel(@NonNull Application application) {
        super(application);
    }
    public List<Contact> getContacts()
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
    public void editButton_onClick(Contact contact)
    {
        MainActivity.editCall(contact);
    }
    public void removeButton_onClick(Contact contact)
    {
        contactRepository.removeContact(contact);
        App.getInstance().notifyItemRemoved(contactRepository.getIndexOf(contact));
    }
}
