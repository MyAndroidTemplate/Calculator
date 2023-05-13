package com.example.operations;

import com.example.Enum.MathOperation;
import com.example.Enum.NumericType;

public interface IBinaryOperations<T extends Number> {
    public T plus ();
    public T minus();
    public T plus_minus();
    public T percent();
}