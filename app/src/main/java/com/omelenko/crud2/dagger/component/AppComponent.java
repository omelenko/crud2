package com.omelenko.crud2.dagger.component;

import com.omelenko.crud2.contact.ContactAdapter;
import com.omelenko.crud2.contact.ContactRepository;
import com.omelenko.crud2.viewmodel.ListViewModel;
import com.omelenko.crud2.viewmodel.MainViewModel;
import com.omelenko.crud2.viewmodel.SecondaryViewModel;

import dagger.Component;

@Component(dependencies = {ContactRepository.class, ContactAdapter.class})
public interface AppComponent {
    void injectsListViewModel(ListViewModel listViewModel);
    void injectsMainViewModel(MainViewModel mainViewModel);
    void injectsSecondaryViewModel(SecondaryViewModel secondaryViewModel);
}
