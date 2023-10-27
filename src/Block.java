/**
 * Projekt: Java-Praktikum-P4-Tetris
 * Autor: Lukas Hammer
 * Erstelldatum: 27.10.2023
 */

import javax.swing.*;
import java.awt.*;

public class Block extends JPanel {

    public static final int BLOCK_SIZE = 45;


    public Block(int xPosition, int yPosition) {
        setBounds(xPosition,yPosition,BLOCK_SIZE,BLOCK_SIZE);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(BLOCK_SIZE,BLOCK_SIZE));

        this.setLayout(null);
    }


}
