package com.example.model;
import android.util.Log;

import com.example.Enum.MathOperation;
import com.example.Enum.NumericType;
import com.example.operations.IBinaryOperations;
import com.example.operations.Lambda;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public class BinaryOperations<T extends Number> implements IBinaryOperations<T>
{
    public  T x;
    public  T y;
    private MathOperation operation;
    //private NumericType type;
    public BinaryOperations() { Log.i("Information", " Math model was created sucessfull");}
    public BinaryOperations(T x , T y)
    {
       this.x = x;
       this.y = y;
    }
    @Override
    public T plus() {
        return performOperation(x, y, (a, b) -> a + b);
    }

    @Override
    public T minus() {
        return performOperation(x, y, (a, b) -> a - b);
    }

    @Override
    public T plus_minus() {
        return null;
    }

    @Override
    public T percent() {
        return performOperation(x, y, (a, b) -> a / b);
    }

    private T performOperation(Number x, Number y, BinaryOperator<T> operator) {
        if (x instanceof Long) {
            return operator.apply((T) x, (T) y);
        } else if (x instanceof Double) {
            return operator.apply((T) x, (T) y);
        } else {
            throw new UnsupportedOperationException("Unsupported numeric type");
        }
    }


    public T operate(T x, T y, MathOperation operation) {
        switch (operation) {
            case PLUS:

                break;
            case MINUS:

                break;
            case MULTIPLY:

                break;
            case DIVIDE:

                break;
            case PERCENT:
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
        return null;
    }
}
