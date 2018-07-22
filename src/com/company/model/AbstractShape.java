package com.company.model;

import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractShape implements Shape {

    protected double x;
    protected double y;
    protected double diameter = 30;
    protected double shift = 10;
    protected GraphicsContext gc;

    public AbstractShape(GraphicsContext gc, double x, double y) {
        this.gc = gc;
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveLeft() {
        x = x - shift;
    }

    @Override
    public void moveRight() {
        x = x + shift;
    }

    @Override
    public void moveTop() {
        y = y - shift;
    }

    @Override
    public void moveBottom() {
        y = y + shift;
    }
}
