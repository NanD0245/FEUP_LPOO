import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminal;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.*;
import static java.lang.System.*;

public class Game {
    private Screen screen;
    private Hero hero;

    Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(125, 40);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        hero = new Hero(10,10);
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    private void moveHero(Position position) {
        hero.setPosition(position);
    }

    public void run() throws IOException{
        draw();
        KeyStroke key = screen.readInput();
        boolean check = true;
        while (check) {
            switch (key.getKeyType()) {
                case ArrowUp:
                    screen.clear();
                    moveHero(hero.moveUp());
                    hero.draw(screen);
                    screen.refresh();
                    break;
                case ArrowDown:
                    screen.clear();
                    moveHero(hero.moveDown());
                    hero.draw(screen);
                    screen.refresh();
                    break;
                case ArrowLeft:
                    screen.clear();
                    moveHero(hero.moveLeft());
                    hero.draw(screen);
                    screen.refresh();
                    break;
                case ArrowRight:
                    screen.clear();
                    moveHero(hero.moveRight());
                    hero.draw(screen);
                    screen.refresh();
                    break;
                case Character:
                    if (key.getCharacter() == 'q') {
                        screen.close();
                    }
                    break;
                case EOF:
                    check = false;
                    break;
            }
            key = screen.readInput();
        }
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
    }
}
