package com.example.modules;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator.R;
import com.example.events.MyTextWatcher;

public class DisplayShow{
  private View view;
  private EditText operation;
  private TextView display;
  private MyTextWatcher event;
    public DisplayShow(View view) {
        this.view = view;
        this.display = view.findViewById(R.id.display);
        this.operation = view.findViewById(R.id.operations);
             event = new MyTextWatcher(this.operation);
        this.operation.addTextChangedListener(event);
    }

    /**
     * Set new value for TextView
     * Устанавливает новое значение дисплея
     * @param value
     */
    public void setDisplayValue(String value)
    {
        display.setText(value);
    }

    /***
     * Current display contains operation
     * Отображает произведенную операцию
     * @param value
     */
    public void setDisplayOperationValue(String value)
    {
        operation.append(value);
    }

    /**
     * Clearing display
     * Очищает дисплей
     */
    public void Clear()
    {
        operation.setText("");
    }
}
