package com.example.modules;

import android.view.View;
import android.widget.TextView;

import com.example.calculator.R;

public class DisplayShow{
    View view;
    TextView display;
    public DisplayShow(View view) {
        this.view = view;
        this.display = view.findViewById(R.id.display);
    }

    public void setDisplayValue(String value)
    {
        display.setText(value);
    }
}
