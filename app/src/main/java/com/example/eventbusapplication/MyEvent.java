package com.example.eventbusapplication;

import android.text.Editable;
import android.widget.EditText;

public class MyEvent {
    private Editable editText;
    public MyEvent(){

    }
    public MyEvent(Editable editText){
        this.editText = editText;
    }

    public void setEditText(Editable editText) {
        this.editText = editText;
    }

    public Editable getEditText() {
        return editText;
    }
}
