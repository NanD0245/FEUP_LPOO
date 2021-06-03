import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.run();
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}
