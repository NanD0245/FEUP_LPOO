package com.aor.refactoring.example5;

public abstract class Direction {
    Turtle turtle;
    Direction(Turtle turtle) {
        this.turtle = turtle;
    }

    public abstract char getDirection();

    public abstract void rotateLeft();
    public abstract void rotateRight();
    public abstract void moveForward();
}
