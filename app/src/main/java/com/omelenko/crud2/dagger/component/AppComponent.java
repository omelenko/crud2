package com.omelenko.crud2.dagger.component;

import com.omelenko.crud2.contact.ContactAdapter;
import com.omelenko.crud2.contact.ContactRepository;
import com.omelenko.crud2.dagger.module.NetworkModule;
import com.omelenko.crud2.dagger.module.StorageModule;
import com.omelenko.crud2.fragment.MainFragment;
import com.omelenko.crud2.fragment.SecondaryFragment;

import dagger.Component;

@Component(modules = {StorageModule.class, NetworkModule.class}, dependencies = {ContactRepository.class, ContactAdapter.class})
public interface AppComponent {
    void injectsContactAdapter(ContactAdapter contactAdapter);
    void injectsMainFragment(MainFragment mainFragment);
    void injectsSecondaryFragment(SecondaryFragment secondaryFragment);
}
