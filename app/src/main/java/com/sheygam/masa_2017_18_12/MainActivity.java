package com.sheygam.masa_2017_18_12;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static float SCALE_X = (float) 1.0;
    public static float SCALE_Y = (float) 1.0;
    private String tag = "MY_";
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.fragment_container,new MyFragment());
//        transaction.commit();

        Button addFragment = findViewById(R.id.add_fragment_btn);
        addFragment.setOnClickListener(this);
        Button replaceFragment = findViewById(R.id.replace_fragment_btn);
        replaceFragment.setOnClickListener(this);
        Button remove = findViewById(R.id.remove_fragment_btn);
        remove.setOnClickListener(this);
        Button detach = findViewById(R.id.dettach_fragment_btn);
        Button attach = findViewById(R.id.attach_fragment_btn);
        detach.setOnClickListener(this);
        attach.setOnClickListener(this);
        Button backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(this);
        Button popToRemoveBtn = findViewById(R.id.pop_to_remove_btn);
        popToRemoveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.add_fragment_btn){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container,new MyFragment(),tag + count++)
                    .addToBackStack("ADD")
                    .commit();
        }else if(v.getId() == R.id.replace_fragment_btn){
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragment_container, new MyFragment(), tag + count++)
                    .commit();
        }else if(v.getId() == R.id.remove_fragment_btn){
            MyFragment fragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("MY_3");
            if(fragment != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack("REMOVE")
                        .remove(fragment)
                        .commit();
            }
        }else if(v.getId() == R.id.dettach_fragment_btn){
            MyFragment fragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("MY_1");
            if (fragment != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .detach(fragment)
                        .commit();
            }
        }else if(v.getId() == R.id.attach_fragment_btn){
            MyFragment fragment = (MyFragment) getSupportFragmentManager().findFragmentByTag("MY_1");
            if(fragment != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .attach(fragment)
                        .commit();
            }
        }else if(v.getId() == R.id.back_btn){
            getSupportFragmentManager().popBackStack();
        }else if(v.getId() == R.id.pop_to_remove_btn){
            getSupportFragmentManager().popBackStack("ADD", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}
