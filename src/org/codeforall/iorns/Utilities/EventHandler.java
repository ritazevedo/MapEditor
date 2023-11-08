package org.codeforall.iorns.Utilities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class EventHandler implements KeyboardHandler {

    private MapEditor mapEditor;
    private boolean space;
    private boolean blue;
    private boolean pink;
    private boolean yellow;
    private boolean orange;
    private boolean green;
    private boolean red;


    public EventHandler(MapEditor mapEditor) {
        this.mapEditor = mapEditor;
    }


    public void init() {
        Keyboard kb = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paint.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_C);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);

        KeyboardEvent notPaint = new KeyboardEvent();
        notPaint.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        notPaint.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);

        KeyboardEvent paintBlue = new KeyboardEvent();
        paintBlue.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintBlue.setKey(KeyboardEvent.KEY_B);

        KeyboardEvent paintPink = new KeyboardEvent();
        paintPink.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintPink.setKey(KeyboardEvent.KEY_P);

        KeyboardEvent paintYellow = new KeyboardEvent();
        paintYellow.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintYellow.setKey(KeyboardEvent.KEY_Y);

        KeyboardEvent paintOrange = new KeyboardEvent();
        paintOrange.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintOrange.setKey(KeyboardEvent.KEY_O);

        KeyboardEvent paintGreen = new KeyboardEvent();
        paintGreen.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintGreen.setKey(KeyboardEvent.KEY_G);

        KeyboardEvent paintRed = new KeyboardEvent();
        paintRed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintRed.setKey(KeyboardEvent.KEY_R);

        kb.addEventListener(right);
        kb.addEventListener(up);
        kb.addEventListener(left);
        kb.addEventListener(down);
        kb.addEventListener(paint);
        kb.addEventListener(clear);
        kb.addEventListener(save);
        kb.addEventListener(notPaint);
        kb.addEventListener(load);
        kb.addEventListener(paintBlue);
        kb.addEventListener(paintPink);
        kb.addEventListener(paintYellow);
        kb.addEventListener(paintOrange);
        kb.addEventListener(paintGreen);
        kb.addEventListener(paintRed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                mapEditor.movePlayerRight();
                checkSpace();
                break;
            case KeyboardEvent.KEY_UP:
                mapEditor.movePlayerUp();
                checkSpace();
                break;
            case KeyboardEvent.KEY_LEFT:
                mapEditor.movePlayerLeft();
                checkSpace();
                break;
            case KeyboardEvent.KEY_DOWN:
                mapEditor.movePlayerDown();
                checkSpace();
                break;
            case KeyboardEvent.KEY_SPACE:
                space = true;
                checkColor();
                break;
            case KeyboardEvent.KEY_C:
                mapEditor.clearCells();
                break;
            case KeyboardEvent.KEY_S:
                mapEditor.saveCells();
                break;
            case KeyboardEvent.KEY_L:
                mapEditor.loadCells();
                break;
            case KeyboardEvent.KEY_B:
                setBlue();
                break;
            case KeyboardEvent.KEY_P:
                setPink();
                break;
            case KeyboardEvent.KEY_Y:
                setYellow();
                break;
            case KeyboardEvent.KEY_O:
                setOrange();
                break;
            case KeyboardEvent.KEY_G:
                setGreen();
                break;
            case KeyboardEvent.KEY_R:
                setRed();
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                space = false;
                break;
        }
    }

    private void checkSpace() {
        if (space) {
            checkColor();
        }
    }

    private void checkColor() {
        if (blue) {
            mapEditor.paintCells(Color.BLUE);
            return;
        }
        if (pink) {
            mapEditor.paintCells(Color.MAGENTA);
            return;
        }
        if (yellow) {
            mapEditor.paintCells(Color.YELLOW);
            return;
        }
        if (orange) {
            mapEditor.paintCells(Color.ORANGE);
            return;
        }
        if (green) {
            mapEditor.paintCells(Color.GREEN);
            return;
        }
        if (red) {
            mapEditor.paintCells(Color.RED);
            return;
        }
        mapEditor.paintCells(Color.BLACK);
    }

    private void setBlue() {
        pink = false;
        yellow = false;
        orange = false;
        green = false;
        red = false;
        if (!blue) {
            blue = true;
            mapEditor.setPlayerColor(Color.BLUE);
            return;
        }
        mapEditor.setPlayerColor(Color.BLACK);
        blue = false;
    }

    private void setPink() {
        blue = false;
        yellow = false;
        orange = false;
        green = false;
        red = false;
        if (!pink) {
            pink = true;
            mapEditor.setPlayerColor(Color.MAGENTA);
            return;
        }
        mapEditor.setPlayerColor(Color.BLACK);
        pink = false;
    }

    private void setYellow() {
        blue = false;
        pink = false;
        orange = false;
        green = false;
        red = false;
        if (!yellow) {
            yellow = true;
            mapEditor.setPlayerColor(Color.YELLOW);
            return;
        }
        mapEditor.setPlayerColor(Color.BLACK);
        yellow = false;
    }

    private void setOrange() {
        blue = false;
        pink = false;
        yellow = false;
        green = false;
        red = false;
        if (!orange) {
            orange = true;
            mapEditor.setPlayerColor(Color.ORANGE);
            return;
        }
        mapEditor.setPlayerColor(Color.BLACK);
        orange = false;
    }

    private void setGreen() {
        blue = false;
        pink = false;
        yellow = false;
        orange = false;
        red = false;
        if (!green) {
            green = true;
            mapEditor.setPlayerColor(Color.GREEN);
            return;
        }
        mapEditor.setPlayerColor(Color.BLACK);
        green = false;
    }

    private void setRed() {
        blue = false;
        pink = false;
        yellow = false;
        orange = false;
        green = false;
        if (!red) {
            red = true;
            mapEditor.setPlayerColor(Color.RED);
            return;
        }
        mapEditor.setPlayerColor(Color.BLACK);
        red = false;
    }
}
