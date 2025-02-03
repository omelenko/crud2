package com.omelenko.crud2.viewmodel;

import androidx.lifecycle.ViewModel;
import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.contact.ContactAdapter;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {
    @Inject
    ContactAdapter adapter;
    public void button_onClick()
    {
        MainActivity.addCall();
    }
    public void button2_onClick()
    {
        MainActivity.openOptions();
    }

    public void button3_onClick()
    {
        MainActivity.openFileFragment();
    }
    public ContactAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ContactAdapter adapter) {
        this.adapter = adapter;
    }
}
