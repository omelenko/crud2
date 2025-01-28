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
    private final MutableLiveData<String> name = new MutableLiveData<>("Ім'я:");
    private final MutableLiveData<String> phone = new MutableLiveData<>("Номер:");
    private final MutableLiveData<String> edit = new MutableLiveData<>("Редагувати");
    private final MutableLiveData<String> remove = new MutableLiveData<>("Видалити");

    public ListViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getPhone() {
        return phone;
    }

    public MutableLiveData<String> getEdit() {
        return edit;
    }

    public MutableLiveData<String> getRemove() {
        return remove;
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
