package com.example.tpraktikum6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.tpraktikum6.databinding.ActivityMainBinding;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding Binding;

    private FragmentManager fragmentManager;
    public static LinkedList<Post> posts = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(Binding.getRoot());

        fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        Fragment fragment =
                fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if (!(fragment instanceof HomeFragment)) {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        }

        Binding.homebutton.setOnClickListener(v -> switchFragment(new HomeFragment()));
        Binding.addbutton.setOnClickListener(v -> switchFragment(new PostFragment()));
        Binding.personbutton.setOnClickListener(v -> switchFragment(new ProfileFragment()));
    }

    private void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (fragment instanceof HomeFragment) {
            transaction
                    .replace(R.id.frame_container, fragment,
                            HomeFragment.class.getSimpleName())
                    .commit();
        } else {
            transaction
                    .replace(R.id.frame_container, fragment,
                            HomeFragment.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void onBackPress() {
        FragmentManager fm = getSupportFragmentManager();

        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        } else {
            super.onBackPressed();
        }
    }
}