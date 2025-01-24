package com.omelenko.crud2.fragment;

import static com.omelenko.crud2.MainActivity.addCall;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omelenko.crud2.App;
import com.omelenko.crud2.MainActivity;
import com.omelenko.crud2.R;
import com.omelenko.crud2.contact.ContactAdapter;
import com.omelenko.crud2.databinding.MainFragmentBinding;
import com.omelenko.crud2.viewmodel.MainViewModel;

import javax.inject.Inject;

public class MainFragment extends Fragment {

    @Inject
    ContactAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        App.getComponent().injectsMainFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.setAdapter(adapter);
        viewModel.setLinearLayoutManager(new LinearLayoutManager(this.getContext()));

        View view = binding.getRoot();

        binding.setViewModel(viewModel);

        return view;
    }
}
