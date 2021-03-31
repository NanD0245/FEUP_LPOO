package com.aor.refactoring.example5;

public class SDirection extends Direction{
    SDirection(Turtle turtle){ super(turtle); }

    public char getDirection() { return 'S'; }

    @Override
    public void rotateLeft() { turtle.setDirection(new EDirection(turtle)); }

    @Override
    public void rotateRight() { turtle.setDirection(new WDirection(turtle)); }

    @Override
    public void moveForward() { turtle.setRow(turtle.getRow() + 1); }
}
