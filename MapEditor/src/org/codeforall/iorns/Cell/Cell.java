package org.codeforall.iorns.Cell;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.codeforall.iorns.Grid;

import java.util.HashSet;

import static org.codeforall.iorns.Grid.CELLSIZE;
import static org.codeforall.iorns.Grid.PADDING;

public class Cell {

    private Rectangle cell;


    public Cell(int x, int y, int width, int height) {
        cell = new Rectangle(x, y, width, height);
    }

    public void draw() {
        cell.draw();
    }

    public Rectangle getCell() {
        return cell;
    }


}
