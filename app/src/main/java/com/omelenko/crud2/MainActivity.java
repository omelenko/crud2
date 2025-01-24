package com.omelenko.crud2;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.omelenko.crud2.fragment.MainFragment;
import com.omelenko.crud2.fragment.SecondaryFragment;

public class MainActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_activity);
        fragmentManager = getSupportFragmentManager();
        if(savedInstanceState == null)
        {
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.main, new MainFragment(), null)
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

    public static void popBackStack()
    {
        fragmentManager.popBackStack();
    }
}