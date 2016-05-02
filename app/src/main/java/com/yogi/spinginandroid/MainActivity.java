package com.yogi.spinginandroid;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yogi.spinginandroid.module.barcode.BarcodeFragment;
import com.yogi.spinginandroid.module.facebook.FacebookFragment;
import com.yogi.spinginandroid.module.spingforandroid.SpingForAndroidFragment;

public class MainActivity extends AppCompatActivity {


    private FragmentTransaction transaction;
    private String[] modules = new String[]{
            "Spring for Android",
            "Barcode and scan",
            "Facebook"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ModuleListFragment listFragment = new ModuleListFragment();
        listFragment.setData(modules);
        openFragment(listFragment);

    }

    private void openFragment(DemoFragment fragment){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void itemClick(int position) {
        switch (position){
            case 0:
                openFragment(new SpingForAndroidFragment());
                break;

            case 1:
                openFragment(new BarcodeFragment());
                break;

            case 2:
                openFragment(new FacebookFragment());
                break;
        }
    }
}
