package com.example.events;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.model.BinaryOperations;
import com.example.component.DisplayShow;
import java.util.Arrays;

public class ButtonEvents <T extends Number> {
    private BinaryOperations<T> digit = null;
    private DisplayShow display;
    private View view;
    private int[] buttonObject = {
            R.id.button_1,  R.id.button_2,   R.id.button_3,
            R.id.button_4,  R.id.button_5,   R.id.button_6,
            R.id.button_7,  R.id.button_8,   R.id.button_9,
            R.id.Reset,     R.id.plus_minus, R.id.percent,
            R.id.button_Eq, R.id.floatDigit, R.id.Zero
    };
    public ButtonEvents() {}
    public ButtonEvents(View view) {
        this.view = view;
        this.display=new DisplayShow(this.view);
    }

    /**
     * The current method sets up listeners for all buttons in use
     * Текущий метод настраивает слушатели для всех используемых кнопок.
     */
    public void setOnClickListeners() {
        try{
            Arrays.stream(buttonObject).forEach(id ->
            {
                Button button = view.findViewById(id);
                button.setOnClickListener(view ->
                {
                    if (view != null)
                    {
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

    /**
     * Current method is denied duplicate math operator symbol
     * Текущий метод запрещает использование повторяющихся символов математических операторов
     * @param operation
     */
    private void DeniedRepeatMathOperation(String operation)
    {
        try{
            if(display.getText().equals(operation) || display.getText().contains(operation))
            {
                return;
            }else{
                setTextValue(operation);
            }
        }catch(NullPointerException ex)
        {
             Log.e("Error", "The method DeniedRepeatMathOperation received a null object.Abort");
        }

    }
    /**
     * When the button is pressed, the method assigns a value to EditText
     * Текущий метод устанавливает значение для EditText при нажатии на кнопку
     */
    private void setTextValue(String value)
    {
        this.display.setDisplayOperationValue(value);
    }

    /**
     * The current method processes keyboard input
     * @param btn
     */
   private void handleButtonClick(int btn) {
        switch (btn) {
            case R.id.button_1:
                // setTextValue("1");
                digit = (BinaryOperations<T>) new BinaryOperations<Double>(5.5, 5.2);
                setTextValue(String.valueOf(digit.plus()));
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
                setTextValue("0");
                break;
            case R.id.Reset:
                display.Clear();
                break;
            case R.id.button_plus:

                DeniedRepeatMathOperation("+");
                break;
            case R.id.plus_minus:

                DeniedRepeatMathOperation("-");
                break;
            case R.id.percent:
                DeniedRepeatMathOperation("%");
                break;
            case R.id.floatDigit:
                digit = (BinaryOperations<T>) new BinaryOperations<Double>();
                DeniedRepeatMathOperation(".");
                break;
            case R.id.button_Eq:
                DeniedRepeatMathOperation("=");
                break;
            default:
                break;
        }
    }
}