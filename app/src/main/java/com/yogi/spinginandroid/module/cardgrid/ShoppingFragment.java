package com.yogi.spinginandroid.module.cardgrid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.yogi.spinginandroid.DemoFragment;
import com.yogi.spinginandroid.R;

public class ShoppingFragment extends DemoFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_shopping, container, false);
    }
}
