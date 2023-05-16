package com.example.events;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

import com.example.model.BinaryOperations;
import com.example.modules.CheckType;

public class MyTextWatcher <T extends Number> implements TextWatcher {
   private T x = null;
   private T y = null;
   private T digit;
   private String text = "";
   BinaryOperations<T> binary = null;
   public EditText display;
   public MyTextWatcher(){}
   public MyTextWatcher(EditText editText) {
       this.display = editText;
    }

    /**
     * Change Tracking event before
     * Событие отслеживания изменений до
     * @param charSequence
     * @param i
     * @param i1
     * @param i2
     */
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {

    }

    private int extractValue(String text) {
        int plusIndex = text.indexOf(text);
        String xString = text.substring(0, plusIndex).trim();
        return Integer.parseInt(xString);
    }

    public void onTextType()
    {
        if(CheckType.isDouble(this.x) || CheckType.isDouble(this.y)){
            binary = (BinaryOperations<T>) new BinaryOperations<Double>(this.x.doubleValue(),this.y.doubleValue());
            Log.i("Math model:" ," Double Math model created successfull");
        }else if (CheckType.isInteger(this.x) || CheckType.isInteger(this.y))
        {
            binary = (BinaryOperations<T>) new BinaryOperations<Integer>(this.x.intValue(), this.y.intValue());
            Log.i("Math model:" ," Double Math model created successfull");
        }else if(CheckType.isLong(this.x) || CheckType.isLong(this.y))
        {
            binary = (BinaryOperations<T>) new BinaryOperations<Long>(this.x.longValue(),this.y.longValue());
        }else{

        }
    }
    /**
     * Change tracking event
     * Отслеживает изменение данных у дисплея
     * @param charSequence
     * @param
     * @param i1
     * @param i2
     */
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
    {
        try{
          text = display.getText().toString();
            if (text.contains("."))
            {
               this.x = (T) Double.valueOf(text);
                 Log.i("Type information:", "Double type was detected: " + digit);
            } else {
                this.x = (T) Long.valueOf(text);
                 Log.i("Type information:", "Long type was detected: " + digit);
            }
        }catch (NumberFormatException ex){
            if(text.equals(""))
            {
                Log.i("Clear","Clearing old value") ;
            }else {
                Toast.makeText(display.getContext(), "Incorrect digit value", Toast.LENGTH_SHORT).show();
            }

        }catch (NullPointerException ex){
                Toast.makeText(display.getContext(), "Cannot convert null type", Toast.LENGTH_SHORT).show();
        }

    }

    /***
     * Change tracking event after
     * Событие отслеживания изменений после
     * @param editable
     */
    @Override
    public void afterTextChanged(Editable editable)
    {
        try{
            text=display.getText().toString();
            if(text.contains("-"))
            {

            }else if(text.contains("+"))  {

            }else if(text.contains("X")){

            }else if(text.contains("/"))
            {

            }else{
                Toast.makeText(display.getContext(), "Unknown operations", Toast.LENGTH_SHORT).show();
            }
        }catch (NullPointerException ex){
            Toast.makeText(display.getContext(), "Cannot convert null type", Toast.LENGTH_SHORT).show();
        }
    }
}
