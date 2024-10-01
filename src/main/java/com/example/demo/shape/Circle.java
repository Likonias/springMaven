package com.example.demo.shape;

import java.util.Map;

public class Circle extends Shape{

    Double radius;

    public Circle(Map<String, Object> shapeData) {
        super(shapeData);
        type = ShapeEnum.CIRCLE;
        radius = shapeData.get("radius") != null ? (double) shapeData.get("radius") : null;
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
