import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width, heigh;
    private Hero hero;

    Arena(int width, int heigh) {
        this.width = width;
        this.heigh = heigh;
        hero = new Hero(10,10);
    }

    public void draw(Screen screen) {
        hero.draw(screen);
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() < 0 || position.getX() > width)
            return false;
        else if (position.getY() < 0 || position.getY() > heigh)
            return false;
        return true;
    }

    private void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }
    }
}
