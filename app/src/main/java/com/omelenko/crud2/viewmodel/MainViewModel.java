package com.omelenko.crud2.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.contact.ContactAdapter;

public class MainViewModel extends ViewModel {
    ContactAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    private MutableLiveData<String> name = new MutableLiveData<>("Додаток для запису контактів");
    private MutableLiveData<String> button = new MutableLiveData<>("Додати контакт");

    public void button_onClick()
    {
        MainActivity.addCall();
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(MutableLiveData<String> name) {
        this.name = name;
    }

    public MutableLiveData<String> getButton() {
        return button;
    }

    public void setButton(MutableLiveData<String> button) {
        this.button = button;
    }

    public ContactAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public LinearLayoutManager getLinearLayoutManager() {
        return linearLayoutManager;
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }
}
