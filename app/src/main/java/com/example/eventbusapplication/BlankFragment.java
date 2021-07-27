package com.example.eventbusapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {
    private EditText editText;
    private Button button;
    public MyEvent myEvent = new MyEvent();

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("onCreateView","called");
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        editText = (EditText) view.findViewById(R.id.editText);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(
                viewSecond -> {
                    myEvent.setEditText(editText.getText());
                    EventBus.getDefault().postSticky(myEvent);
                }
        );
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}