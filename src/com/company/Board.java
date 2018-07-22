package com.company;

import com.company.model.Circle;
import com.company.model.Group;
import com.company.model.Shape;
import com.company.model.Square;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private GraphicsContext gc;

    private int index = 0;

    private List<Shape> shapes = new ArrayList<>();

    public Board(GraphicsContext gc) {
        this.gc = gc;

        Shape circle = new Circle(gc, 100, 100);
        shapes.add(circle);

        Shape square = new Square(gc, 300, 100);
        shapes.add(square);
    }

    private void clearScreen() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRoundRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight(), 0, 0);
    }

    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void keyPressed(KeyEvent event) {
        clearScreen();

        Shape shape = shapes.get(index);

        switch (event.getCode()) {
            case UP:
                shape.moveTop();
                break;
            case RIGHT:
                shape.moveRight();
                break;
            case DOWN:
                shape.moveBottom();
                break;
            case LEFT:
                shape.moveLeft();
                break;
            case PAGE_UP:
                previous();
                break;
            case PAGE_DOWN:
                next();
                break;
            case A:
                Shape circle = new Circle(gc, 10, 10);
                shapes.add(circle);
                break;
            case S:
                Shape square = new Square(gc, 10, 10);
                shapes.add(square);
                break;
            case G:
                group();
                break;
        }
        drawAll();
    }

    private void group() {
        Shape shape1 = shapes.get(index);
        Shape shape2 = shapes.get(index - 1);

        Group group = new Group();
        group.addShapes(shape1, shape2);

        shapes.remove(shape1);
        shapes.remove(shape2);
        shapes.add(group);

        index = shapes.size() - 1;

    }

    private void previous() {
        index--;
        if(index < 0) {
            index = shapes.size() - 1;
        }
    }

    private void next() {
        index++;
        if (index >= shapes.size()) {
            index = 0;
        }
    }

    public void mousePressed(MouseEvent event) {
    }
}
