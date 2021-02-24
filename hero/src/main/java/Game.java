import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.gui2.TextBox;
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
    private int x = 10;
    private int y = 10;

    Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(125, 40);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        //int height = ((AWTTerminal)terminal).getFontConfiguration().getFontHeight();
        //System.out.print(height);
        //System.out.println("A message which is logged at QUIET level");
        //Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }

    public void run() throws IOException{
        draw();
        KeyStroke key = screen.readInput();
        boolean check = true;
        while (check) {
            switch (key.getKeyType()) {
                case ArrowUp:
                    if (y > 0) {
                        screen.clear();
                        screen.setCharacter(x, --y, TextCharacter.fromCharacter('X')[0]);
                        screen.refresh();
                    }
                    break;
                case ArrowDown:
                    screen.clear();
                    screen.setCharacter(x, ++y, TextCharacter.fromCharacter('X')[0]);
                    screen.refresh();
                    break;
                case ArrowLeft:
                    screen.clear();
                    screen.setCharacter(--x, y, TextCharacter.fromCharacter('X')[0]);
                    screen.refresh();
                    break;
                case ArrowRight:
                    screen.clear();
                    screen.setCharacter(++x, y, TextCharacter.fromCharacter('X')[0]);
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
            /*if (key.getKeyType() == KeyType.ArrowUp) {
                screen.clear();
                screen.setCharacter(x + 5, y + 5, TextCharacter.fromCharacter('X')[0]);
                screen.refresh();
            }
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.setCharacter(x - 5, y - 5, TextCharacter.fromCharacter('Q')[0]);
                screen.refresh();
            }*/
            key = screen.readInput();
        }
        //processKey(key);
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
    }
}
