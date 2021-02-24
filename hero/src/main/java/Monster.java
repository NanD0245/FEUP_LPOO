import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    Monster(int x, int y) {
        super(x,y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#0e8212"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "@");
    }

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position moveRandom() {
        Random random = new Random();
        int i = random.nextInt(8);
        switch (i) {
            case 0:
                return new Position(getPosition().getX(), getPosition().getY() - 1);
            case 1:
                return new Position(getPosition().getX(), getPosition().getY() + 1);
            case 2:
                return new Position(getPosition().getX() - 1, getPosition().getY());
            case 3:
                return new Position(getPosition().getX() + 1, getPosition().getY());
            case 4:
                return new Position(getPosition().getX() + 1, getPosition().getY() - 1);
            case 5:
                return new Position(getPosition().getX() - 1, getPosition().getY() + 1);
            case 6:
                return new Position(getPosition().getX() - 1, getPosition().getY() - 1);
            case 7:
                return new Position(getPosition().getX() + 1, getPosition().getY() + 1);
            default:
                return new Position(position.getX(), getPosition().getY());
        }
    }
}
