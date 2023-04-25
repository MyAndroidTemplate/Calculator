package com.example.model;
import com.example.Interface.IBinaryOperations;

public class DoubleBinaryOperations implements IBinaryOperations<Double> {
    public double x=0.00;
    public double y=0.00;
    public DoubleBinaryOperations() {}

    @Override
    public Double sum(Double x, Double y) {
        this.x=x;
        this.y=y;
        return (x+y);
    }

    @Override
    public Double minus(Double x, Double y) {
        this.x=x;
        this.y=y;
        return (this.x-this.y);
    }

    @Override
    public Double percent(Double x, Double y) {
        this.x=x;
        this.y=y;
        return (this.x % this.y);
    }

    @Override
    public Double division(Double x, Double y) {
        this.x=x;
        this.y=y;
        return (this.x/this.y);
    }

    @Override
    public Double plus_or_minus(Double x, Double y) {
        this.x=x;
        this.y=y;
        return (-this.x+this.y);
    }
}
