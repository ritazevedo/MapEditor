package org.codeforall.iorns.Cell;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.codeforall.iorns.Grid;
import org.w3c.dom.css.Rect;

import static org.codeforall.iorns.Grid.CELLSIZE;
import static org.codeforall.iorns.Grid.PADDING;

public class Player {

    private Rectangle player;

    public Player(int x, int y, int width, int height) {
        player = new Rectangle(x, y, width, height);
        startPlayer();
    }

    public void startPlayer() {
        setColor(Color.BLACK);
    }

    public void translatePlayer(int x, int y) {
        player.translate(x, y);
    }

    public int getX() {
        return player.getX();
    }

    public int getY() {
        return player.getY();
    }

    public void setColor(Color color) {
        player.setColor(color);
        player.fill();
    }



}
