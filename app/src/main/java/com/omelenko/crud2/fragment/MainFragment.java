package com.omelenko.crud2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.omelenko.crud2.App;
import com.omelenko.crud2.R;
import com.omelenko.crud2.databinding.MainFragmentBinding;
import com.omelenko.crud2.viewmodel.MainViewModel;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.setLinearLayoutManager(new LinearLayoutManager(this.getContext()));

        App.getComponent().injectsMainViewModel(viewModel);

        View view = binding.getRoot();

        binding.setViewModel(viewModel);

        return view;
    }
}
