package com.example.demo.shape;

import java.util.Map;

public class Rectangle extends Shape{

    Double height;
    Double width;

    public Rectangle(Map<String, Object> shapeData) {
        super(shapeData);
        type = ShapeEnum.RECTANGLE;
        height = shapeData.get("height") != null ? (Double) shapeData.get("height") : null;
        width = shapeData.get("width") != null ? (Double) shapeData.get("width") : null;
    }

    @Override
    void calculateArea() {
        area = height * width;
    }

    @Override
    void calculateCircumference() {
        circumference = 2 * height + 2 * width;
    }

    private void calculateSides() {

        if(height == null){
            height = (circumference - width * 2) / 2 ;
        }

        if(width == null){
            width = (circumference - height * 2) / 2;
        }

    }

    @Override
    public void finishShape() {

        if(area == null){calculateArea();}

        if(circumference == null){calculateCircumference();}

        if(width == null || height == null){calculateSides();}

    }

    @Override
    public String toString() {
        return "type: " + type + ", height: " + height + ", width: " + width + ", circumference: " + circumference + ", area: " + area;
    }
}
