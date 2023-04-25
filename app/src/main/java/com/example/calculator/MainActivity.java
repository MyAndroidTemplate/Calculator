package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.modules.ButtonEvents;

public class MainActivity extends AppCompatActivity {
    private ButtonEvents events = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(android.R.id.content);
        events= new ButtonEvents(view);
    }
    public void onClick(View views) {

        events.setOnClickListeners();
    }
}