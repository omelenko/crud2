package com.omelenko.crud2.fragment;

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
import com.omelenko.crud2.R;
import com.omelenko.crud2.databinding.FileFragmentBinding;
import com.omelenko.crud2.viewmodel.FileViewModel;
import java.util.Locale;

public class FileFragment extends Fragment {
    private static final String FILE_NAME_EN = "data_en.txt";
    private static final String FILE_NAME_UK = "data_uk.txt";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FileFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.file_fragment, container, false);
        FileViewModel viewModel = new ViewModelProvider(this).get(FileViewModel.class);

        if(Locale.getDefault().getLanguage().equals("en"))
        {
            viewModel.setFile(requireActivity().getFileStreamPath(FILE_NAME_EN));
        }
        else if(Locale.getDefault().getLanguage().equals("uk"))
        {
            viewModel.setFile(requireActivity().getFileStreamPath(FILE_NAME_UK));
        }

        View view = binding.getRoot();

        viewModel.getText().observe(requireActivity(), s -> {
            TextView textView = view.findViewById(R.id.textView4);
            textView.setText(s);
        });


        binding.setViewModel(viewModel);

        return view;
    }
}
