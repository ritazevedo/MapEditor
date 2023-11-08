package org.codeforall.iorns;

import org.codeforall.iorns.Utilities.EventHandler;
import org.codeforall.iorns.Utilities.MapEditor;

public class Main {

    public static void main(String[] args) {

        MapEditor mapEditor = new MapEditor();

        EventHandler eventHandler = new EventHandler(mapEditor);
        eventHandler.init();


    }

}
