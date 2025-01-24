package com.omelenko.crud2.viewmodel;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.contact.Contact;
import com.omelenko.crud2.contact.ContactAdapter;
import com.omelenko.crud2.contact.ContactRepository;

import java.util.Objects;

public class SecondaryViewModel extends ViewModel {

    ContactAdapter adapter;
    ContactRepository contactRepository;
    Contact editContact;

    private final MutableLiveData<String> title = new MutableLiveData<>("Додаток для запису контактів");
    private final MutableLiveData<String> name = new MutableLiveData<>("Ім'я:");
    private MutableLiveData<String> contactName = new MutableLiveData<>(editContact == null ? "~" : editContact.getName());
    private final MutableLiveData<String> phone = new MutableLiveData<>("Номер:");
    private MutableLiveData<String> contactPhone = new MutableLiveData<>(editContact == null ? "~" : editContact.getPhone());
    private final MutableLiveData<String> button = new MutableLiveData<>(editContact == null ? "Додати контакт" : "Редагувати контакт");
    private int position = 1999;

    public void nameTextChanged()
    {

    }

    public void phoneTextChanged()
    {

    }
    public void setEditContact(int position)
    {
        editContact = contactRepository.getContact(position);
    }
    @SuppressLint("NotifyDataSetChanged")
    public void button_onClick()
    {
        if(!Objects.equals(contactName.getValue(), "") && !Objects.equals(contactName.getValue(), ""))
        {
            Contact newContact = new Contact(contactName.getValue(), contactPhone.getValue());
            if(position != 1999)
            {
                contactRepository.editContact(newContact, position);
            }
            else
            {
                contactRepository.addContact(newContact);
            }
            adapter.notifyDataSetChanged();
            MainActivity.popBackStack();
        }
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getPhone() {
        return phone;
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

    public MutableLiveData<String> getButton() {
        return button;
    }

    public MutableLiveData<String> getTitle() {
        return title;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setAdapter(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void setEditContact(Contact editContact) {
        this.editContact = editContact;
    }
}
