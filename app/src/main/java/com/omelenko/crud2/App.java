package com.omelenko.crud2;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.databinding.ObservableList;
import androidx.room.Room;

import com.omelenko.crud2.dagger.component.AppComponent;
import com.omelenko.crud2.dagger.component.DaggerAppComponent;
import com.omelenko.crud2.contact.ContactAdapter;
import com.omelenko.crud2.contact.ContactRepository;
import com.omelenko.crud2.contact.ContactRepositoryImpl;
import com.omelenko.crud2.viewmodel.ListViewModel;

public class App extends Application {
    public static App instance;
    private static AppComponent component;
    private AppDatabase database;
    static ListViewModel viewModel;
    static ContactAdapter adapter;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").
                allowMainThreadQueries().
                fallbackToDestructiveMigration().
                build();
        viewModel = new ListViewModel(this);
        adapter = new ContactAdapter(viewModel);
        ContactRepository contactRepository = new ContactRepositoryImpl();
        component = DaggerAppComponent.builder().
                    contactAdapter(adapter).
                    contactRepository(contactRepository).
                    build();
    }
    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public static AppComponent getComponent()
    {
        return component;
    }
    public void notifyItemRemoved(int position)
    {
        adapter.notifyItemRemoved(position);
    }

}
