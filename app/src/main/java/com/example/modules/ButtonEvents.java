package com.example.modules;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.example.calculator.R;
import com.example.model.DoubleBinaryOperations;
import com.example.model.IntegerBinaryOperations;

import java.util.Arrays;

public class ButtonEvents {
    private DoubleBinaryOperations doubleDigit = new DoubleBinaryOperations();
    private IntegerBinaryOperations intDigit = new IntegerBinaryOperations();
    private View view;
    private int[] buttonObject = {
            R.id.button_1, R.id.button_2, R.id.button_3,
            R.id.button_4, R.id.button_5, R.id.button_6,
            R.id.button_7, R.id.button_8, R.id.button_9,
            R.id.Reset, R.id.plus_minus, R.id.percent,
            R.id.button_Eq, R.id.floatDigit, R.id.Zero
    };
    public ButtonEvents() {}
    public ButtonEvents(View view) {
        this.view = view;
    }

    public void setOnClickListeners() {
        Arrays.stream(buttonObject).forEach(id -> {
            Button button = view.findViewById(id);
            button.setOnClickListener(view -> {
                if (view != null) {
                    handleButtonClick(view.getId());
                }
            });
        });
    }

    private void setDisplayValue(int value)
    {
        TextView display = view.findViewById(R.id.display);
        display.setText(String.valueOf(value));
    }
   private void handleButtonClick(int btn) {
        switch (btn) {
            case R.id.button_1:
                setDisplayValue(1);
                break;
            case R.id.button_2:
                setDisplayValue(2);
                break;
            case R.id.button_3:
                setDisplayValue(3);
                break;
            case R.id.button_4:
                setDisplayValue(4);
                break;
            case R.id.button_5:
                setDisplayValue(5);
                break;
            case R.id.button_6:
                setDisplayValue(6);
                break;
            case R.id.button_7:
                setDisplayValue(7);
                break;
            case R.id.button_8:
                setDisplayValue(8);
                break;
            case R.id.button_9:
                setDisplayValue(9);
                break;
            case R.id.Zero:
                setDisplayValue(0);
                break;
            case R.id.button_plus:
                break;
            case R.id.Reset:
                setDisplayValue(0);
                break;
            case R.id.plus_minus:
                break;
            case R.id.percent:
                break;
            case R.id.floatDigit:
                break;
            case R.id.button_Eq:
                break;
            default:
                break;
        }
    }
}