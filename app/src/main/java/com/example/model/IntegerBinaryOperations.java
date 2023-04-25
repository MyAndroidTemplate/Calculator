package com.example.model;

import com.example.operations.IBinaryOperations;

public class IntegerBinaryOperations implements IBinaryOperations<Integer>
{
    public int x=0;
    public int y=0;
    public IntegerBinaryOperations() {}
    @Override
    public Integer sum(Integer x, Integer y) {
        this.x=x;
        this.y=y;
        return (this.x+this.y);
    }

    @Override
    public Integer minus(Integer x, Integer y) {
        this.x=x;
        this.y=y;
        return (this.x-this.y);
    }

    @Override
    public Integer percent(Integer x, Integer y) {
        this.x=x;
        this.y=y;
        return (this.x%this.y);
    }

    @Override
    public Integer division(Integer x, Integer y) {
        this.x=x;
        this.y=y;
        return (this.x/this.y);
    }

    @Override
    public Integer plus_or_minus(Integer x, Integer y) {
        this.x=x;
        this.y=y;
        return (-this.x+this.y);
    }
}
