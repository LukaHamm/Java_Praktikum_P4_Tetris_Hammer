import java.awt.*;
import java.awt.event.KeyEvent;

public class Form {
    private Block [] blockListe = new Block[4];

    protected int [] zentrum;

    private Color farbe;

    protected static final Block [][] GERADE_BLOCKLISTE = {{new Block(Block.BLOCK_SIZE*5,0),null,null,null,null},
                                                        {new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE),null,null,null,null},
                                                        {new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*2),null,null,null,null},
                                                        {new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*3),null,null,null,null},
                                                        {null,null,null,null,null}};

    protected static final Block [][] QUADRAT_BLOCKLISTE = {{null,new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*2),new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*2),null,null},
                                                         {null,new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*3),new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*3),null,null},
                                                         {null,null,null,null,null},
                                                         {null,null,null,null,null},
                                                         {null,null,null,null,null}};

    protected static final Block [][] PYRAMIDE_BLOCKLISTE = {{null,null,new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*2),null,null},
                                                         {null,new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*3),new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*3),new Block(Block.BLOCK_SIZE*7,Block.BLOCK_SIZE*3),null},
                                                         {null,null,null,null,null},
                                                         {null,null,null,null,null},
                                                         {null,null,null,null,null}};

    protected static final Block [][] L_FORM_BLOCKLISTE = {{new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE),null,null,null,null},
                                                        {new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*2),null,null,null,null},
                                                        {new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*3),new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*3),null,null,null},
                                                        {null,null,null,null,null},
                                                        {null,null,null,null,null}};

    protected static final Block [][] L_FORM_INVERTIERT_BLOCKLISTE = { {null,new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE),null,null,null},
                                                                    {null,new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*2),null,null,null},
                                                                    {new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*3),new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*3),null,null,null},
                                                                    {null,null,null,null,null},
                                                                    {null,null,null,null,null}};

    protected static final Block [][] ZFORM_FORM_BLOCKLISTE = {{new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*2),new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*2),null,null,null},
            {null,null,new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*3),new Block(Block.BLOCK_SIZE*7,Block.BLOCK_SIZE*3),null},
            {null,null,null,null,null},
            {null,null,null,null,null},
            {null,null,null,null,null}};

    protected static final Block [][] ZFORM_FORM_INVERTIERT_BLOCKLISTE = {{null,null,new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*2),new Block(Block.BLOCK_SIZE*7,Block.BLOCK_SIZE*2),null},
                                                                        {null,null,new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*3),new Block(Block.BLOCK_SIZE*6,Block.BLOCK_SIZE*3),null},
                                                                        {null,null,null,null,null},
                                                                        {null,null,null,null,null},
                                                                        {null,null,null,null,null}};



    public Form(Block [] blockListe) {
        this.blockListe = blockListe;
    }

    public Form(Form form, Color farbe){
        this.zentrum = form.zentrum;
        this.farbe = farbe;
        kopiere_Bloecke(form.getBlockListe());


    }

    private void kopiere_Bloecke(Block[] blockListe) {
        for (int i = 0; i < 4; i++) {
            if (blockListe[i] != null) {
                if (blockListe[i] instanceof ExplosionBlock) {
                    this.blockListe[i] = new ExplosionBlock(blockListe[i].getX(), blockListe[i].getY());
                } else {
                    this.blockListe[i] = new Block(blockListe[i].getX(), blockListe[i].getY());
                }
            }
        }
    }



    public void nachruecken(int distanz) {
        for (Block block : this.getBlockListe()) {
            if (block != null) {
                block.setLocation(block.getX(), block.getY() + distanz);
            }
        }
    }




    public Block get_untersten_Block() {
        Block untersterBlock = null;
        for (Block block : blockListe) {
            if (block != null) {
                if (untersterBlock == null || untersterBlock.getY() < block.getY()) {
                    untersterBlock = block;
                }
            }
        }
        return untersterBlock;
    }

    public Block[] getBlockListe() {
        return blockListe;
    }

    public Color getFarbe() {
        return farbe;
    }
}
