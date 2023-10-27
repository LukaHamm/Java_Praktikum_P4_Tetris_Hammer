/**
 * Projekt: Java-Praktikum-P4-Tetris
 * Autor: Lukas Hammer
 * Erstelldatum: 27.10.2023
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ExplosionBlock extends Block {
    public static final int explosionsRadius = 3;


    public ExplosionBlock(int x, int y){
        super(x,y);

    }
}
