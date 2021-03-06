import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element{

    Hero(int x, int y) {super(x,y); }

    @Override
    public void draw(TextGraphics graphics) {
        //graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#0d2e63"));
        graphics.enableModifiers(SGR.BOLD);
        //graphics.putString(position.getX()*2, position.getY()*2+1, "\\/");
        //graphics.putString(position.getX()*2, position.getY()*2+1, "/\\");
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {return position; }

    public Position moveUp() { return new Position(position.getX(), position.getY() - 1); }
    public Position moveDown() { return new Position(position.getX(), position.getY() + 1); }
    public Position moveLeft() { return new Position(position.getX() - 1, position.getY()); }
    public Position moveRight() { return new Position(position.getX() + 1, position.getY()); }
}
