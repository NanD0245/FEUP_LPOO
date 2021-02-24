import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
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
    private Arena arena;
    private TextGraphics graphics;

    Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(125, 40);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        graphics = screen.newTextGraphics();


        screen.refresh();
        //graphics.fill('a');

        arena = new Arena(20,20);
    }

    private void draw() throws IOException {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void run() throws IOException{
        draw();
        KeyStroke key = screen.readInput();
        while (key.getKeyType() != EOF) {
            if (key.getKeyType() == Character && key.getCharacter() == 'q')
                screen.close();
            arena.processKey(key);
            draw();
            key = screen.readInput();
        }
    }

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }
}
