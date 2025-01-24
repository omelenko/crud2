package com.omelenko.crud2.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.omelenko.crud2.App;
import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.R;
import com.omelenko.crud2.contact.Contact;
import com.omelenko.crud2.contact.ContactAdapter;
import com.omelenko.crud2.contact.ContactRepository;
import com.omelenko.crud2.databinding.SecondaryFragmentBinding;
import com.omelenko.crud2.viewmodel.SecondaryViewModel;

import java.util.Objects;

import javax.inject.Inject;

public class SecondaryFragment extends Fragment {

    @Inject
    ContactAdapter adapter;
    @Inject
    ContactRepository contactRepository;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        App.getComponent().injectsSecondaryFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SecondaryFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.secondary_fragment, container, false);
        SecondaryViewModel viewModel = new ViewModelProvider(this).get(SecondaryViewModel.class);

        viewModel.setAdapter(adapter);
        viewModel.setContactRepository(contactRepository);

        View view = binding.getRoot();

        if(getArguments() != null)
        {
            int position = getArguments().getInt("position");
            viewModel.setEditContact(position);
            viewModel.setPosition(position);
        }

        binding.setViewModel(viewModel);

        return view;
    }
}
