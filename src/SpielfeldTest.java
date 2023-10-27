import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpielfeldTest {

    private static Spielfeld spielfeld;

    @BeforeAll
    public static void init(){
        spielfeld = new Spielfeld();

    }

    @Test
    @Order(4)
    void loeschen_und_nachruecken() {
        Block[] blocklist1 = new Block[4];
        for (int i = 20; i<24;i++){
            blocklist1[i-20] = new Block(Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*i);
        }
        try {
            spielfeld.uebernehme_bloecke(new Form(blocklist1));
        }catch (Spielfeld.FormOutOfBoundException e){

        }

    }

    @Test
    void diamantBlockGenerieren() {
    }

    @Test
    void block_durchfuehren_explodieren() {
    }

    @Test
    @Order(2)
    void beruehrt_boden() {
        Block[] blocklist1 = new Block[4];
        Block[] blocklist2 = new Block[4];
        Block [] blockList3 = new Block[4];
        for (int i = 20; i<24;i++){
           blocklist1[i-20] = new Block(Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*i);
        }
        for (int i = 19; i<23;i++){
            blocklist2[i-19] = new Block(Block.BLOCK_SIZE,Block.BLOCK_SIZE*i);
        }
        for (int i = 15; i<19;i++){
            blockList3[i-15] = new Block(Block.BLOCK_SIZE,Block.BLOCK_SIZE*i);
        }
        boolean beruehrtBoden1 = spielfeld.beruehrt_boden(new Form(blocklist1),Block.BLOCK_SIZE);
        boolean beruehrtBoden2 = spielfeld.beruehrt_boden(new Form(blocklist2),Block.BLOCK_SIZE);
        boolean beruehrtBoden3 = spielfeld.beruehrt_boden(new Form(blockList3),Block.BLOCK_SIZE);

        assertTrue(beruehrtBoden1);
        assertTrue(beruehrtBoden2);
        assertFalse(beruehrtBoden3);

    }

    @Test
    @Order(3)
    void beruehrt_seitlich() {
        Block[] blocklist1 = new Block[4];
        Block[] blocklist2 = new Block[4];
        for (int i = 0; i<4;i++){
            blocklist1[i] = new Block(Block.BLOCK_SIZE*i,Block.BLOCK_SIZE*5);
        }
        for (int i = 6; i<10;i++){
            blocklist2[i-6] = new Block(Block.BLOCK_SIZE*i,Block.BLOCK_SIZE*5);
        }
        boolean beruehrtSeitlich1 = spielfeld.beruehrt_seitlich(new Form(blocklist1),-Block.BLOCK_SIZE);
        boolean beruehrtSeitlich2 = spielfeld.beruehrt_seitlich(new Form(blocklist2),Block.BLOCK_SIZE);

        assertTrue(beruehrtSeitlich1);
        assertTrue(beruehrtSeitlich2);
    }

    @Test
    void position_valid() {
    }

    @Test
    void setze_auf_Boden() {
    }

    @Test
    @Order(1)
    void uebernehme_bloecke() {
        Block [] blockList1 = new Block[4];
        Block [] blockList2 = new Block[4];
        Block [] blockList3 = new Block[4];
        Block [] blockList4 = new Block[4];
        Block [] blockList5 = new Block[4];
        for (int i = 0;i<4;i++){
            blockList1[i]=(new Block(Block.BLOCK_SIZE*i,Block.BLOCK_SIZE*23));
        }

        for (int i = 4;i<8;i++){
            blockList2[i-4]=(new Block(Block.BLOCK_SIZE*i,Block.BLOCK_SIZE*23));
        }
        for (int i = 23;i<27;i++){
            blockList3[i-23]=(new Block(Block.BLOCK_SIZE*1,Block.BLOCK_SIZE*i));
        }
        for (int i = 0;i<4;i++){
            blockList4[i]=(new Block(Block.BLOCK_SIZE*1,Block.BLOCK_SIZE*i));
        }
        for (int i = 10;i<14;i++){
            blockList4[i-10]=(new Block(Block.BLOCK_SIZE*i,Block.BLOCK_SIZE*4));
        }
        for (int i = -4;i<0;i++){
            blockList5[i+4]=(new Block(Block.BLOCK_SIZE*i,Block.BLOCK_SIZE*4));
        }
        assertDoesNotThrow(() -> {spielfeld.uebernehme_bloecke(new Form(blockList1));});
        assertDoesNotThrow(() -> {spielfeld.uebernehme_bloecke(new Form(blockList2));});
        Exception exception3 = assertThrows(Spielfeld.FormOutOfBoundException.class, () -> {spielfeld.uebernehme_bloecke(new Form(blockList3));});
        Exception exception4 = assertThrows(Spielfeld.FormOutOfBoundException.class, () -> {spielfeld.uebernehme_bloecke(new Form(blockList4));});
        Exception exception5 = assertThrows(Spielfeld.FormOutOfBoundException.class, () -> {spielfeld.uebernehme_bloecke(new Form(blockList5));});

    }
}