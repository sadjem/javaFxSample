package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Group implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    public void addShapes(Shape shape1, Shape shape2) {
        shapes.add(shape1);
        shapes.add(shape2);
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    @Override
    public void moveLeft() {
        for (Shape shape : shapes) {
            shape.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        for (Shape shape : shapes) {
            shape.moveRight();
        }
    }

    @Override
    public void moveTop() {
        for (Shape shape : shapes) {
            shape.moveTop();
        }
    }

    @Override
    public void moveBottom() {
        for (Shape shape : shapes) {
            shape.moveBottom();
        }
    }

}
