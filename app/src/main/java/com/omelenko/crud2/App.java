package com.omelenko.crud2;

import android.annotation.SuppressLint;
import android.app.Application;

import androidx.databinding.ObservableList;

import com.omelenko.crud2.dagger.component.AppComponent;
import com.omelenko.crud2.dagger.component.DaggerAppComponent;
import com.omelenko.crud2.contact.ContactAdapter;
import com.omelenko.crud2.contact.ContactRepository;
import com.omelenko.crud2.contact.ContactRepositoryImpl;
import com.omelenko.crud2.viewmodel.ListViewModel;

public class App extends Application {

    private static AppComponent component;
    static ListViewModel viewModel;
    static ContactAdapter adapter;

    @Override
    public void onCreate() {
        super.onCreate();
        viewModel = new ListViewModel(this);
        adapter = new ContactAdapter(viewModel);
        ContactRepository contactRepository = new ContactRepositoryImpl();
        component = DaggerAppComponent.builder().
                    contactAdapter(adapter).
                    contactRepository(contactRepository).
                    build();
    }

    public static AppComponent getComponent()
    {
        return component;
    }

    public static void makeObservable()
    {
        viewModel.getContacts().addOnListChangedCallback(new ObservableList.OnListChangedCallback() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(ObservableList sender) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
                adapter.notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
                adapter.notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
            }

            @Override
            public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
                adapter.notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }

}
