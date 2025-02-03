package com.omelenko.crud2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import com.omelenko.crud2.fragment.FileFragment;
import com.omelenko.crud2.fragment.MainFragment;
import com.omelenko.crud2.fragment.OptionsFragment;
import com.omelenko.crud2.fragment.SecondaryFragment;

public class MainActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        boolean darkTheme = prefs.getBoolean("theme", false);

        if(darkTheme)
        {
            setTheme(R.style.DarkTheme);
        }
        else
        {
            setTheme(R.style.LightTheme);
        }

        setContentView(R.layout.main_activity);

        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState == null)
        {
            fragmentManager.beginTransaction()
                    .add(R.id.main, new MainFragment(), null)
                    .setReorderingAllowed(true)
                    .commit();
        }
    }

    public static void editCall(int position)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);

        SecondaryFragment secondaryFragment = new SecondaryFragment();
        secondaryFragment.setArguments(bundle);

        fragmentManager.beginTransaction()
                .replace(R.id.main, secondaryFragment)
                .setReorderingAllowed(true)
                .addToBackStack("edit")
                .commit();
    }
    public static void addCall()
    {
        fragmentManager.beginTransaction()
                .replace(R.id.main, new SecondaryFragment())
                .setReorderingAllowed(true)
                .addToBackStack("add")
                .commit();
    }

    public static void openOptions()
    {
        fragmentManager.beginTransaction()
                .replace(R.id.main, new OptionsFragment())
                .setReorderingAllowed(true)
                .addToBackStack("setting")
                .commit();
    }

    public static void openFileFragment()
    {
        fragmentManager.beginTransaction()
                .replace(R.id.main, new FileFragment())
                .setReorderingAllowed(true)
                .addToBackStack("file")
                .commit();
    }

    public static void popBackStack()
    {
        fragmentManager.popBackStack();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CustomContextWrapper.wrap(newBase));
    }
}