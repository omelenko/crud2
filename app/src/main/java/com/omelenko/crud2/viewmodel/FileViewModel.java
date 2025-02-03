package com.omelenko.crud2.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileViewModel extends ViewModel {
    private File file;
    private MutableLiveData<String> text = new MutableLiveData<>("");

    public void button_onClick()
    {
        StringBuilder stringBuilder = new StringBuilder();
        try
        {
            BufferedReader fin = new BufferedReader(new FileReader(file));
            String line;
            while ((line = fin.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            setText(stringBuilder.toString());
        } catch (IOException e) {
            Log.d(FileViewModel.class.getSimpleName(), "Помилка при відкритті");
        }
    }

    public MutableLiveData<String> getText() {
        return text;
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
            this.file = file;
    }
}
