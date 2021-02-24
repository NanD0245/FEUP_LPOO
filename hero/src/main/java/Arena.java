import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width, height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private boolean gameover;

    Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10,10);
        walls = createWalls();
        coins = createCoins();
        monsters = createMonsters();
        this.gameover = false;
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#bfbfbf"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width,height),' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin: coins)
            coin.draw(graphics);
        for (Monster monster: monsters)
            monster.draw(graphics);
    }

    private boolean canHeroMove(Position position) {
        for (Wall wall : walls) {
            if (wall.getPosition().equals(position))
                return false;
        }
        return true;
    }

    private void retrieveCoins(Position position) {
        for (Coin coin: coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                break;
            }
        }
    }

    private void moveHero(Position position) {
        moveMonsters();
        if (canHeroMove(position)) {
            retrieveCoins(position);
            hero.setPosition(position);
            verifyWin();
        }
        verifyMonsterCollisions();
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

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Coin coin;
        Random random = new Random();
        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            do {
                coin = new Coin(random.nextInt(width-2) + 1, random.nextInt(height-2)+1);
            } while(coin.getPosition().equals(hero.getPosition()));
            coins.add(coin);
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Monster monster;
        boolean check;
        Random random = new Random();
        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            do {
                check = true;
                monster = new Monster(random.nextInt(width-2) + 1,random.nextInt(height -2) + 1);
                for (Coin coin: coins) {
                    if (monster.getPosition().equals(coin.getPosition())) {
                        check = false;
                        break;
                    }
                }

            } while (monster.getPosition().equals(hero.getPosition()) && check);
            monsters.add(monster);
        }
        return monsters;
    }

    private boolean canMonsterMove(Position position) {
        for (Coin coin: coins)
            if (coin.getPosition().equals(position))
                return false;
        for (Wall wall: walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    private void moveMonsters() {
        for (Monster monster: monsters) {
            Position position = monster.moveRandom();
            if (canMonsterMove(position))
                monster.setPosition(position);
        }
    }

    private void verifyMonsterCollisions() {
        for (Monster monster: monsters)
            if (monster.getPosition().equals(hero.getPosition())) {
                System.out.println("GAME OVER!");
                gameover = true;
            }
    }

    private void verifyWin() {
        if (coins.isEmpty()) {
            System.out.println("YOU BEAT THE GAME");
            gameover = true;
            coins.add(new Coin(-1,-1));
        }
    }

    public boolean isGameover() {
        return gameover;
    }
}
