package com.example.operations;

import java.math.BigDecimal;

public interface Lambda<T> {
    T apply(T x, T y);
}
