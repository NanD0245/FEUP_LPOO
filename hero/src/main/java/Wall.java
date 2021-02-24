import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Wall {
    Position position;
    Wall(int x, int y) {this.position = new Position(x,y); }

    public void draw(TextGraphics graphics) {
        graphics.putString(position.getX(),position.getY(),"#");
    }

    public Position getPosition() {
        return position;
    }
}
