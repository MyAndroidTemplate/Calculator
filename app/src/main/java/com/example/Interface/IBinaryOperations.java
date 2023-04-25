package com.example.Interface;

public interface IBinaryOperations<T> {
    public T sum(T x, T y);

    public T minus(T x, T y);
    public T percent(T x, T y);
    public T division(T x, T y);
    public T plus_or_minus(T x, T y);
}