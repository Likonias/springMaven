package com.example.demo.shape;

import java.util.Map;

public class Triangle extends Shape {

    Double a;
    Double b;
    Double c;

    public Triangle(Map<String, Object> shapeData) {
        super(shapeData);
        type = ShapeEnum.TRIANGLE;
        a = shapeData.get("a") != null ? (double) shapeData.get("a") : null;
        b = shapeData.get("b") != null ? (double) shapeData.get("b") : null;
        c = shapeData.get("c") != null ? (double) shapeData.get("c") : null;
    }

    @Override
    void calculateArea() {

    }

    @Override
    void calculateCircumference() {

    }

    @Override
    public void finishShape() {

    }
}
