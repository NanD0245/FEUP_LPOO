package com.aor.refactoring.example5;

public class NDirection extends Direction{
    NDirection(Turtle turtle){ super(turtle); }

    public char getDirection() { return 'N'; }

    @Override
    public void rotateLeft() {turtle.setDirection(new WDirection(turtle)); }

    @Override
    public void rotateRight() {turtle.setDirection(new EDirection(turtle)); }

    @Override
    public void moveForward() {turtle.setRow(turtle.getRow() - 1); }
}
