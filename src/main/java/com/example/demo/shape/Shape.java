package com.example.demo.shape;

public abstract class Shape {

    double circumference;
    double area;
    ShapeEnum type;

    abstract void calculateArea();

    abstract void calculateCircumference();

    public abstract void finishShape();

}
