package org.codeforall.iorns.Utilities;

import java.io.*;

class Saver {

    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private String line;



    String readCells() {
        try {
            fileReader = new FileReader("resources/copy.txt");
            bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }

    void writeCells(String file) {
        try {
            fileWriter = new FileWriter("resources/copy.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(file);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
