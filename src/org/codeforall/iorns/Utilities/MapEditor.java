package org.codeforall.iorns.Utilities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.codeforall.iorns.Cell.Player;
import org.codeforall.iorns.Grid;

import java.util.Objects;

import static org.codeforall.iorns.Grid.CELLSIZE;
import static org.codeforall.iorns.Grid.PADDING;

public class MapEditor {

    private Grid grid;
    private Player player;
    private int[] paint;
    private String file;
    private Saver saver;

    public MapEditor() {
        saver = new Saver();
        paint = new int[400];
        grid = new Grid(600, 600);
        player = new Player(PADDING, PADDING, CELLSIZE, CELLSIZE);
    }

    void movePlayerRight() {
        if (player.getX() == (grid.getWidth() + PADDING - CELLSIZE)) {
            return;
        }
        player.translatePlayer(CELLSIZE, 0);
    }

    void movePlayerUp() {
        if (player.getY() == PADDING) {
            return;
        }
        player.translatePlayer(0, -CELLSIZE);
    }

    void movePlayerLeft() {
        if (player.getX() == PADDING) {
            return;
        }
        player.translatePlayer(-CELLSIZE, 0);
    }

    void movePlayerDown() {
        if (player.getY() == (grid.getHeight() + PADDING - CELLSIZE)) {
            return;
        }
        player.translatePlayer(0, CELLSIZE);
    }

    void paintCells(Color color) {
        for (int i = 0; i < grid.getSquares().length; i++) {
            if (player.getX() == grid.getSquares()[i].getX() && player.getY() == grid.getSquares()[i].getY()) {
                if (!(paint[i] == 0)) {
                    grid.getSquares()[i].setColor(Color.BLACK);
                    grid.getSquares()[i].draw();
                    paint[i] = 0;
                    return;
                }
                grid.getSquares()[i].setColor(color);
                grid.getSquares()[i].fill();
                if (color.equals(Color.BLACK)) {
                    paint[i] = 1;
                    return;
                }
                if (color.equals(Color.BLUE)) {
                    paint[i] = 2;
                    return;
                }
                if (color.equals(Color.MAGENTA)) {
                    paint[i] = 3;
                    return;
                }
                if (color.equals(Color.YELLOW)) {
                    paint[i] = 4;
                    return;
                }
                if (color.equals(Color.ORANGE)) {
                    paint[i] = 5;
                    return;
                }
                if (color.equals(Color.GREEN)) {
                    paint[i] = 6;
                    return;
                }
                if (color.equals(Color.RED)) {
                    paint[i] = 7;
                    return;
                }
            }
        }
    }

    void clearCells() {
        for (int i = 0; i < grid.getSquares().length; i++) {
            if (grid.getSquares()[i] == null) {
                continue;
            }
            grid.getSquares()[i].setColor(Color.BLACK);
            grid.getSquares()[i].draw();
            paint[i] = 0;
        }
    }

    void saveCells() {
        file = "";
        for (int i = 0; i < paint.length; i++) {
            if (paint[i] == 0) {
                file += "0";
                continue;
            }
            if (paint[i] == 1) {
                file += "1";
                continue;
            }
            if (paint[i] == 2) {
                file += "2";
                continue;
            }
            if (paint[i] == 3) {
                file += "3";
                continue;
            }
            if (paint[i] == 4) {
                file += "4";
                continue;
            }
            if (paint[i] == 5) {
                file += "5";
                continue;
            }
            if (paint[i] == 6) {
                file += "6";
                continue;
            }
            if (paint[i] == 7) {
                file += "7";
            }
        }
        saver.writeCells(file);
    }

    void loadCells() {
        String[] copy = saver.readCells().split("");
        for (int i = 0; i < copy.length; i++) {
            if (grid.getSquares()[i] == null) {
                return;
            }
            if (Objects.equals(copy[i], "0")) {
                paint[i] = 0;
                grid.getSquares()[i].setColor(Color.BLACK);
                grid.getSquares()[i].draw();
                continue;
            }
            if (Objects.equals(copy[i], "1")) {
                paint[i] = 1;
                grid.getSquares()[i].setColor(Color.BLACK);
                grid.getSquares()[i].fill();
                continue;
            }
            if (Objects.equals(copy[i], "2")) {
                paint[i] = 2;
                grid.getSquares()[i].setColor(Color.BLUE);
                grid.getSquares()[i].fill();
                continue;
            }
            if (Objects.equals(copy[i], "3")) {
                paint[i] = 3;
                grid.getSquares()[i].setColor(Color.MAGENTA);
                grid.getSquares()[i].fill();
                continue;
            }
            if (Objects.equals(copy[i], "4")) {
                paint[i] = 4;
                grid.getSquares()[i].setColor(Color.YELLOW);
                grid.getSquares()[i].fill();
                continue;
            }
            if (Objects.equals(copy[i], "5")) {
                paint[i] = 5;
                grid.getSquares()[i].setColor(Color.ORANGE);
                grid.getSquares()[i].fill();
                continue;
            }
            if (Objects.equals(copy[i], "6")) {
                paint[i] = 6;
                grid.getSquares()[i].setColor(Color.GREEN);
                grid.getSquares()[i].fill();
                continue;
            }
            if (Objects.equals(copy[i], "7")) {
                paint[i] = 7;
                grid.getSquares()[i].setColor(Color.RED);
                grid.getSquares()[i].fill();
            }
        }
    }

    void setPlayerColor(Color color) {
        player.setColor(color);
    }

}
