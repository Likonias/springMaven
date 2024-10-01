package com.example.demo.shape;

import java.util.Locale;
import java.util.Map;

public class ShapeCreator {

    public static Shape createShape(Map<String, Object> shapeData) throws Exception {

        ShapeEnum shapeType;
        Shape createdShape = null;

        if(shapeData.containsKey("type")){
            shapeType = ShapeEnum.valueOf(shapeData.get("type").toString().toUpperCase(Locale.ROOT));
        }else{
            shapeType = determineShape(shapeData);
        }

        switch(shapeType) {
            case CIRCLE -> createdShape = new Circle(shapeData);
            case TRIANGLE -> createdShape = new Triangle(shapeData);
            case RECTANGLE -> createdShape = new Rectangle(shapeData);
            case UNKNOWN -> throw new Exception("Could not recognize shape!");
        }

        return createdShape;

    }

    private static ShapeEnum determineShape(Map<String, Object> shapeData) {

        if(isCircle(shapeData)) {return ShapeEnum.CIRCLE;}

        if(isTriangle(shapeData)) {return ShapeEnum.TRIANGLE;}

        if(isRectangle(shapeData)) {return ShapeEnum.RECTANGLE;}

        return ShapeEnum.UNKNOWN;

    }


    private static boolean isCircle(Map<String, Object> shapeData) {
        return shapeData.containsKey("radius");
    }


    private static boolean isTriangle(Map<String, Object> shapeData) {
        return  shapeData.containsKey("a") || shapeData.containsKey("b") || shapeData.containsKey("c");
    }

    private static boolean isRectangle(Map<String, Object> shapeData){
        return shapeData.containsKey("height") || shapeData.containsKey("width");
    }


}
