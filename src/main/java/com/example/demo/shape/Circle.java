package com.example.demo.shape;

import java.util.Map;

public class Circle extends Shape{

    Double radius;

    public Circle(Map<String, Object> shapeData) {
        super(shapeData);
        type = ShapeEnum.CIRCLE;
        radius = shapeData.get("radius") != null ? (Double) shapeData.get("radius") : null;
    }

    @Override
    void calculateArea() {
        area = Math.PI * Math.pow(radius, 2);
    }

    @Override
    void calculateCircumference() {
        circumference = 2 * Math.PI * radius;
    }

    void calculateRadius(){
        //Za předpoklad, že může chybět pouze jeden z atributů, popřípadně lze rozšířit o kalkulaci z obsahu
        radius = circumference / (2 * Math.PI);
    }

    @Override
    public void finishShape() {

        if(area == null){calculateArea();}

        if(circumference == null){calculateCircumference();}

        if(radius == null){calculateRadius();}

    }

    @Override
    public String toString() {
        return "type: " + type + ", radius: " + radius + ", circumference: " + circumference + ", area: " + area;
    }
}
