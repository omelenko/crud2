package com.omelenko.crud2.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
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
import com.omelenko.crud2.databinding.MainFragmentBinding;
import com.omelenko.crud2.viewmodel.MainViewModel;
import java.util.Locale;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        App.getComponent().injectsMainViewModel(viewModel);

        View view = binding.getRoot();

        binding.setViewModel(viewModel);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Context context = this.requireActivity();
        View view = this.requireView();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        String username = prefs.getString("username", "Не встановлено");

        TextView optionsText = view.findViewById(R.id.optionsText);
        optionsText.setText(username);

        boolean darkTheme = prefs.getBoolean("theme", false);

        TypedValue currentThemeName = new TypedValue();
        requireActivity().getTheme().resolveAttribute(R.attr.themeName, currentThemeName, true);

        if(darkTheme)
        {
            if("light".contentEquals(currentThemeName.string))
            {
                context.setTheme(R.style.DarkTheme);
                requireActivity().recreate();
            }
        }
        else
        {
            if("dark".contentEquals(currentThemeName.string))
            {
                context.setTheme(R.style.LightTheme);
                requireActivity().recreate();
            }
        }

        String language = prefs.getString("language", "uk");

        if(language.equals("uk"))
        {
            if(Locale.getDefault().getLanguage().equals("en"))
            {
                requireActivity().recreate();
            }
        }
        else if(language.equals("en"))
        {
            if(Locale.getDefault().getLanguage().equals("uk"))
            {
                requireActivity().recreate();
            }
        }
    }
}
