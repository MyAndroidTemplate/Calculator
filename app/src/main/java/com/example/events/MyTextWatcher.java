package com.example.events;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MyTextWatcher implements TextWatcher {
   public EditText display;
   
   public MyTextWatcher(){}
    public MyTextWatcher(EditText editText) {
       this.display = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    
    /**
     * Change tracking event
     * Отслеживает изменение данных у дисплея
     * @param charSequence
     * @param i
     * @param i1
     * @param i2
     */
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {
        try{
            long digit = Long.parseLong(display.getText().toString());
        }catch (NumberFormatException ex){
            Toast.makeText(display.getContext(), "Incorrect digit value", Toast.LENGTH_SHORT).show();
        }catch (NullPointerException ex){
            Toast.makeText(display.getContext(), "Cannot convert null type", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void afterTextChanged(Editable editable)
    {

    }
}
