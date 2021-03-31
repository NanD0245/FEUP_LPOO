package com.aor.refactoring.example5;

public class EDirection extends Direction{
    EDirection(Turtle turtle) { super(turtle); }

    @Override
    public char getDirection() { return 'E'; }

    @Override
    public void rotateLeft() { turtle.setDirection(new NDirection(turtle)); }

    @Override
    public void rotateRight() { turtle.setDirection(new SDirection(turtle)); }

    @Override
    public void moveForward() { turtle.setColumn(turtle.getColumn() + 1); }
}
