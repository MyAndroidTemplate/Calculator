package com.example.model;
import android.util.Log;

import com.example.modules.CheckType;
import com.example.operations.IBinaryOperations;

import java.util.function.BinaryOperator;

public class BinaryOperations<T extends Number> implements IBinaryOperations<T>
{
    public T x;
    public T y;
    public T result;
    public BinaryOperations() { Log.i("Information", " Math model was created sucessfull");}
    public BinaryOperations(T x , T y)
    {
        this.x=x;
        this.y=y;
    }

    @Override
    public T plus() {
        return performOperation((a, b) -> {
            if (CheckType.isDouble(a) || CheckType.isDouble(b)) {
                return (T) (Double) ((Double) a + (Double) b);
            } else if (CheckType.isLong(a) || CheckType.isLong(b)) {
                return (T) (Long) ((Long) a + (Long) b);
            } else if (CheckType.isInteger(a) || CheckType.isInteger(b)) {
                return (T) (Integer) ((Integer) a + (Integer) b);
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
        });
    }

    @Override
    public T minus() {
        return performOperation((a, b) -> {
            if (CheckType.isDouble(a) || CheckType.isDouble(b)) {
                return (T) (Double) ((Double) a - (Double) b);
            } else if (CheckType.isLong(a) || CheckType.isLong(b)) {
                return (T) (Long) ((Long) a - (Long) b);
            } else if (CheckType.isInteger(a) || CheckType.isInteger(b)) {
                return (T) (Integer) ((Integer) a - (Integer) b);
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
        });
    }

    @Override
    public T plus_minus() {
        return performOperation((a, b) -> {
            if (CheckType.isDouble(a) || CheckType.isDouble(b)) {
                return (T) (Double) ((Double) (a) - (Double) b);
            } else if (CheckType.isLong(a) || CheckType.isLong(b)) {
                return (T) (Long) ((Long) a - (Long) b);
            } else if (CheckType.isInteger(a) || CheckType.isInteger(b)) {
                return (T) (Integer) ((Integer) a - (Integer) b);
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
        });
    }

    public T multiply() {
        return performOperation((a, b) -> {
            if (CheckType.isDouble(a) || CheckType.isDouble(b)) {
                return (T) (Double) ((Double) (a) * (Double) b);
            } else if (CheckType.isLong(a) || CheckType.isLong(b)) {
                return (T) (Long) ((Long) a * (Long) b);
            } else if (CheckType.isInteger(a) || CheckType.isInteger(b)) {
                return (T) (Integer) ((Integer) a * (Integer) b);
            } else {
               throw new IllegalArgumentException("Unsupported type");
            }
        });
    }

    @Override
    public T percent() {
        return performOperation((a, b) -> {
            if (CheckType.isDouble(a) || CheckType.isDouble(b)) {
                return (T) (Double) ((Double) a * ((Double) b / 100.0));
            } else if (CheckType.isLong(a) || CheckType.isLong(b)) {
                return (T) (Long) ((Long) a * ((Long) b / 100L));
            } else if (CheckType.isInteger(a) || CheckType.isInteger(b)) {
                return (T) (Integer) ((Integer) a * ((Integer) b / 100));
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
        });
    }

    private T performOperation(BinaryOperator<T> operator) {
        return operator.apply(x, y);
    }
}
