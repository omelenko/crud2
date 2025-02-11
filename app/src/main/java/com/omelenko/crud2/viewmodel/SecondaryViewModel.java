package com.omelenko.crud2.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.contact.Contact;
import com.omelenko.crud2.contact.ContactAdapter;
import com.omelenko.crud2.contact.ContactRepository;

import java.util.Objects;

import javax.inject.Inject;

public class SecondaryViewModel extends ViewModel {

    @Inject
    ContactAdapter adapter;
    @Inject
    ContactRepository contactRepository;
    Contact editContact;
    private MutableLiveData<String> contactName = new MutableLiveData<>("~");
    private MutableLiveData<String> contactPhone = new MutableLiveData<>("~");
    private int position = 1999;

    public void setEditContact(int position)
    {
        this.editContact = contactRepository.getContact(position);
        contactName.setValue(editContact.getName());
        contactPhone.setValue(editContact.getPhone());
    }
    public void setPosition(int position)
    {
        this.position = position;
    }
    public void button_onClick()
    {
        if(!Objects.equals(contactName.getValue(), "") && !Objects.equals(contactName.getValue(), ""))
        {
            Contact newContact = new Contact();
            newContact.setName(contactName.getValue());
            newContact.setPhone(contactPhone.getValue());
            if(position != 1999)
            {
                Contact contactToEdit = contactRepository.getContact(position);
                newContact.setId(contactToEdit.getId());
                contactRepository.editContact(newContact);
            }
            else
            {
                contactRepository.addContact(newContact);
            }
            MainActivity.popBackStack();
        }
    }
    public MutableLiveData<String> getContactName() {
        return contactName;
    }

    public void setContactName(MutableLiveData<String> contactName) {
        this.contactName = contactName;
    }

    public MutableLiveData<String> getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(MutableLiveData<String> contactPhone) {
        this.contactPhone = contactPhone;
    }
}
