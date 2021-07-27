package com.example.eventbusapplication;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentContainerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //    private final BlankFragment blankFragment = new BlankFragment();
        textView = findViewById(R.id.textView);


//        FragmentContainerView fragmentContainerView = (FragmentContainerView) findViewById(R.id.fragment);
//        FragmentManager fragmentManager = new FragmentManager(){
//
//        };
//        fragmentManager.beginTransaction().add(
//                R.id.fragment,
//                blankFragment
//        )
//                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        Log.i("onEvent Function","called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSecondEvent(MyEvent event){
        Log.i("onSecondEvent","called");
        Log.i("StickyTagHere",event.getEditText().toString());
    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(MyEvent event) {
        Log.i("onEvent Function","called");
        textView.setText(event.getEditText());
        Toast.makeText(this,"Toast",Toast.LENGTH_SHORT).show();
    }
}