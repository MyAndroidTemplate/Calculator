package com.example.operations;

import com.example.Enum.MathOperation;
import com.example.Enum.NumericType;

public interface IBinaryOperations<T extends Number> {
    public T plus (T x, T y);
    public T minus(T x, T y);
    public T plus_minus(T x , T y);
    public T percent(T x , T y, MathOperation operation, NumericType type);
}