package com.omelenko.crud2.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;

import com.omelenko.crud2.App;
import com.omelenko.crud2.R;
import com.omelenko.crud2.databinding.SecondaryFragmentBinding;
import com.omelenko.crud2.viewmodel.SecondaryViewModel;

public class SecondaryFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SecondaryFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.secondary_fragment, container, false);
        SecondaryViewModel viewModel = new ViewModelProvider(this).get(SecondaryViewModel.class);

        App.getComponent().injectsSecondaryViewModel(viewModel);

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

    @Override
    public void onResume() {
        super.onResume();
        Context context = this.requireContext();
        View view = this.requireView();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        String username = prefs.getString("username", "Не встановлено");

        TextView optionsText = view.findViewById(R.id.optionsText1);
        optionsText.setText(username);
    }
}
