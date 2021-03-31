package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private Direction direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;

        if (direction == 'N') this.direction = new NDirection(this);
        else if (direction == 'W') this.direction = new WDirection(this);
        else if (direction == 'S') this.direction = new SDirection(this);
        else if (direction == 'E') this.direction = new EDirection(this);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) { this.row = row; }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) { this.column = column; }

    public char getDirection() { return direction.getDirection(); }

    public void setDirection(Direction direction) { this.direction = direction; }

    public void execute(char command) {
        switch (command) {
            case 'L': direction.rotateLeft(); break;
            case 'R': direction.rotateRight(); break;
            case 'F': direction.moveForward(); break;
            default: break;
        }
    }
}
