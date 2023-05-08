package com.example.model;
import com.example.operations.IBinaryOperations;

public class IntegerBinaryOperations implements IBinaryOperations
{
    public int x=0;
    public int y=0;
    private IBinaryOperations<Integer> operations;
    public IntegerBinaryOperations() {}

    @Override
    public Object calculate(Object x, Object y) {
        return null;
    }
}
