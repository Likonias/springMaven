package com.example.demo.shape;

import java.util.Map;

public class Rectangle extends Shape{

    Double height;
    Double width;

    public Rectangle(Map<String, Object> shapeData) {
        super(shapeData);
        type = ShapeEnum.RECTANGLE;
        height = shapeData.get("height") != null ? (double) shapeData.get("height") : null;
        width = circumference = shapeData.get("width") != null ? (double) shapeData.get("width") : null;
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
