package com.aor.refactoring.example5;

public class WDirection extends Direction{
    WDirection(Turtle turtle) { super(turtle); }

    @Override
    public char getDirection() { return 'W'; }

    @Override
    public void rotateLeft() { turtle.setDirection(new SDirection(turtle)); }

    @Override
    public void rotateRight() { turtle.setDirection(new NDirection(turtle)); }

    @Override
    public void moveForward() { turtle.setColumn(turtle.getColumn() - 1); }
}
