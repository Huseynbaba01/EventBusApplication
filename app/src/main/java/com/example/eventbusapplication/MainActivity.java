package com.example.eventbusapplication;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

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
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(MyEvent event){
        textView.setText(event.getEditText());
    }
}