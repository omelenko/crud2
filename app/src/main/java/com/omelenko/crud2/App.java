package com.omelenko.crud2;

import android.app.Application;

import com.omelenko.crud2.dagger.component.AppComponent;
import com.omelenko.crud2.dagger.component.DaggerAppComponent;
import com.omelenko.crud2.contact.ContactAdapter;
import com.omelenko.crud2.contact.ContactRepository;
import com.omelenko.crud2.contact.ContactRepositoryImpl;
import com.omelenko.crud2.dagger.module.NetworkModule;
import com.omelenko.crud2.dagger.module.StorageModule;

public class App extends Application {

    private static AppComponent component;
    private ContactAdapter adapter;
    private ContactRepository contactRepository;
    private NetworkModule networkModule;
    private StorageModule storageModule;

    @Override
    public void onCreate() {
        super.onCreate();
        adapter = new ContactAdapter(this);
        contactRepository = new ContactRepositoryImpl();
        component = DaggerAppComponent.builder().
                    contactAdapter(adapter).
                    contactRepository(contactRepository).
                    build();
        component.injectsContactAdapter(adapter);
    }

    public static AppComponent getComponent()
    {
        return component;
    }

}
