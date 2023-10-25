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
