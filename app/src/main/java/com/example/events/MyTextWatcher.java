package com.example.events;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MyTextWatcher <T extends Number> implements TextWatcher {
   private T digit = null;
   private String text = "";
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
          text = display.getText().toString();
            if (text.contains(".")) {
                digit = (T) Double.valueOf(text);
                Log.i("Type information:", "Double type was detected: " + digit);
            } else {
                digit = (T) Long.valueOf(text);
                Log.i("Type information:", "Long type was detected: " + digit);
            }
        }catch (NumberFormatException ex){
            if(text.equals(""))
            {
                Log.i("Clear","Clearing zero value successfull") ;
            }else {
                Toast.makeText(display.getContext(), "Incorrect digit value", Toast.LENGTH_SHORT).show();
             }
        }catch (NullPointerException ex){
            Toast.makeText(display.getContext(), "Cannot convert null type", Toast.LENGTH_SHORT).show();
        }
    }

    /***
     * Apply the new changes made after the main change
     * Применить новые изменения, внесенные после основного изменения.
     * @param editable
     */
    @Override
    public void afterTextChanged(Editable editable)
    {
        text = display.getText().toString();
    }
}
