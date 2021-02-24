import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Wall extends Element {

    Wall(int x, int y) {super(x,y); }

    public void draw(TextGraphics graphics) {
        graphics.putString(position.getX(),position.getY(),"#");
    }

    public Position getPosition() {
        return position;
    }
}
