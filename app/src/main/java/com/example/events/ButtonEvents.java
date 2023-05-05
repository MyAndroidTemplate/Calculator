package com.example.events;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.model.DoubleBinaryOperations;
import com.example.model.IntegerBinaryOperations;
import com.example.component.DisplayShow;

import java.util.Arrays;

public class ButtonEvents {
    private DoubleBinaryOperations  doubleDigit = new DoubleBinaryOperations();
    private IntegerBinaryOperations intDigit = new IntegerBinaryOperations();
    private DisplayShow display;
    private View view;
    private int[] buttonObject = {
            R.id.button_1,  R.id.button_2,    R.id.button_3,
            R.id.button_4,  R.id.button_5,    R.id.button_6,
            R.id.button_7,  R.id.button_8,    R.id.button_9,
            R.id.Reset,     R.id.plus_minus,  R.id.percent,
            R.id.button_Eq, R.id.floatDigit,  R.id.Zero
    };
    public ButtonEvents() {}
    public ButtonEvents(View view) {
        this.view = view;
        this.display=new DisplayShow(this.view);
    }

    public void setOnClickListeners() {
        try{
            Arrays.stream(buttonObject).forEach(id -> {
                Button button = view.findViewById(id);
                button.setOnClickListener(view -> {
                    if (view != null) {
                        handleButtonClick(view.getId());
                    }
                });
            });
        }catch(NullPointerException ex)
        {
            Toast.makeText(view.getContext(), "Object does not exist in the current context", Toast.LENGTH_SHORT)
                 .show();
        }catch(ClassCastException ex)
        {
            Toast.makeText(view.getContext(), "Current ID is not an integer", Toast.LENGTH_SHORT)
                 .show();
        }catch (IllegalArgumentException ex)
        {
            Toast.makeText(view.getContext(), "Incorrect getId() method does not match any of the ids in the button object", Toast.LENGTH_SHORT)
                 .show();
        }catch(Exception ex){
            Toast.makeText(view.getContext(), ex.getMessage(), Toast.LENGTH_SHORT)
                 .show();
        }

    }
    private void setTextValue(String value)
    {
        this.display.setDisplayOperationValue(value);
    }
   private void handleButtonClick(int btn) {
        switch (btn) {
            case R.id.button_1:
                setTextValue("1");
                break;
            case R.id.button_2:
                setTextValue("2");
                break;
            case R.id.button_3:
                setTextValue("3");
                break;
            case R.id.button_4:
                setTextValue("4");
                break;
            case R.id.button_5:
                setTextValue("5");
                break;
            case R.id.button_6:
                setTextValue("6");
                break;
            case R.id.button_7:
                setTextValue("7");
                break;
            case R.id.button_8:
                setTextValue("8");
                break;
            case R.id.button_9:
                setTextValue("9");
                break;
            case R.id.Zero:
                break;
            case R.id.Reset:
                display.Clear();
                setTextValue("0");
                break;
            case R.id.button_plus:
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