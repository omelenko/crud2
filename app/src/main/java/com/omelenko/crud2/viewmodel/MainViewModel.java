package com.omelenko.crud2.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.contact.ContactAdapter;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {
    @Inject
    ContactAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    public void button_onClick()
    {
        MainActivity.addCall();
    }
    public ContactAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ContactAdapter adapter) {
        this.adapter = adapter;
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    public LinearLayoutManager getLinearLayoutManager() {
        return linearLayoutManager;
    }
}
