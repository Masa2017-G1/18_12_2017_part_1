package com.sheygam.masa_2017_18_12;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by gregorysheygam on 18/12/2017.
 */

public class MyFragment extends Fragment {

    private TextView titleTxt;
    private float scaleX;
    private float scaleY;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scaleX = MainActivity.SCALE_X;
        scaleY = MainActivity.SCALE_Y;
        MainActivity.SCALE_Y -= 0.1;
        MainActivity.SCALE_X -= 0.1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment_layout,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleTxt = view.findViewById(R.id.title_txt);
        titleTxt.setText("New title");
        Random rnd = new Random();
        int color = Color.rgb(rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
        FrameLayout root = view.findViewById(R.id.my_fragment_root);
        root.setBackgroundColor(color);
        root.setScaleX(scaleX);
        root.setScaleY(scaleY);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MY_TAG", "onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("MY_TAG", "onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("MY_TAG", "onDetach: ");
    }
}
