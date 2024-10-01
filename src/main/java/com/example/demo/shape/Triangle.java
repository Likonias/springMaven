package com.example.demo.shape;

import java.util.Map;

public class Triangle extends Shape {

    Double a;
    Double b;
    Double c;

    public Triangle(Map<String, Object> shapeData) {
        super(shapeData);
        type = ShapeEnum.TRIANGLE;
        a = shapeData.get("a") != null ? (Double) shapeData.get("a") : null;
        b = shapeData.get("b") != null ? (Double) shapeData.get("b") : null;
        c = shapeData.get("c") != null ? (Double) shapeData.get("c") : null;
    }

    @Override
    void calculateArea() {
        Double semiPerimeter = calculateSemiPerimeter();
        area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c) );
    }

    private Double calculateSemiPerimeter(){
        return (a+b+c) / 2;
    }

    @Override
    void calculateCircumference() {
        circumference = a + b + c;
    }

    private Double calculateMissingSide(Double missingSide, Double sideOne, Double sideTwo){
        return circumference - sideOne - sideTwo;
    }

    @Override
    public void finishShape() {

        if(area == null){calculateArea();}

        if(circumference == null){calculateCircumference();}

        if(a == null){a = calculateMissingSide(a, b, c);}

        if(b == null){b = calculateMissingSide(b, a, c);}

        if(c == null){c = calculateMissingSide(c, a, b);}

    }

    @Override
    public String toString() {
        return "type: " + type + ", a: " + a + ", b: " + b + ", c: " + c + ", circumference: " + circumference + ", area: " + area;
    }
}
