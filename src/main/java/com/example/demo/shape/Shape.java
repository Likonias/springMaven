package com.example.demo.shape;

import java.util.Map;

public abstract class Shape {

    Double circumference;
    Double area;
    ShapeEnum type;

    public Shape(Map<String, Object> shapeData) {

        circumference = shapeData.get("circumference") != null ? (double) shapeData.get("circumference") : null;
        area = shapeData.get("area") != null ? (double) shapeData.get("area") : null;

    }

    abstract void calculateArea();

    abstract void calculateCircumference();

    public abstract void finishShape();

}
