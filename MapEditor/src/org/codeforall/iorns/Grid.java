package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.codeforall.iorns.Cell.Cell;
import org.codeforall.iorns.Cell.Player;

import java.util.Arrays;

public class Grid {

    private int x;
    private int y;
    public static final int PADDING = 10;
    public static final int CELLSIZE = 30;
    private Rectangle grid;
    private Cell cell;
    private Rectangle[] squares;


    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        grid = new Rectangle(PADDING, PADDING, x, y);
        squares = new Rectangle[400];
        drawGrid();
        drawCells();
    }

    private void drawGrid() {
        grid.draw();
    }

    private void drawCells() {

        x = PADDING;
        y = PADDING;

        int i = 0;

        while (y != (getHeight() + PADDING)) {
            while (x != (getWidth() + PADDING)) {
                cell = new Cell(x, y, CELLSIZE, CELLSIZE);
                cell.draw();
                squares[i] = cell.getCell();
                i++;
                x += CELLSIZE;
            }
            x = PADDING;
            y += CELLSIZE;
        }

    }


    public int getHeight() {
        return grid.getHeight();
    }

    public int getWidth() {
        return grid.getWidth();
    }

    public Rectangle[] getSquares() {
        return squares;
    }

}
