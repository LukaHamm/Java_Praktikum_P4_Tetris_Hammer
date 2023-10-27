/**
 * Projekt: Java-Praktikum-P4-Tetris
 * Autor: Lukas Hammer
 * Erstelldatum: 27.10.2023
 */

import java.util.ArrayList;
import java.util.HashMap;
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
        Block[] blocklist2 = new Block[4];
        for (int i = 20; i<24;i++){
            blocklist1[i-20] = new Block(Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*i);
        }
        for (int i = 20; i<24;i++){
            blocklist2[i-20] = new Block(Block.BLOCK_SIZE*8,Block.BLOCK_SIZE*i);
        }
        try {
            spielfeld.uebernehme_bloecke(new Form(blocklist1));
            spielfeld.uebernehme_bloecke(new Form(blocklist2));
            List<Block> blockList = spielfeld.loeschen_und_nachruecken();
            assertEquals(10,blockList.size());
        }catch (Spielfeld.FormOutOfBoundException e){

        }

    }

    @Test
    @Order(5)
    void diamantBlockGenerieren() {
        Block[] blocklist1 = new Block[4];
        Block[] blocklist2 = new Block[4];
        Block[] blocklist3 = new Block[4];
        Block[] blocklist4 = new Block[4];
        Block[] blocklist5 = new Block[4];
        Block[] blocklist6 = new Block[4];
        for (int i = 20; i<24;i++){
            blocklist1[i-20] = new Block(Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*i);
        }
        for (int i = 16; i<20;i++){
            blocklist2[i-16] = new Block(Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*i);
        }
        for (int i = 12; i<16;i++){
            blocklist5[i-12] = new Block(Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*i);
        }
        for (int i = 20; i<24;i++){
            blocklist3[i-20] = new Block(Block.BLOCK_SIZE*8,Block.BLOCK_SIZE*i);
        }
        for (int i = 15; i<19;i++){
            blocklist4[i-15] = new Block(Block.BLOCK_SIZE*8,Block.BLOCK_SIZE*i);
        }
        for (int i = 11; i<15;i++){
            blocklist6[i-11] = new Block(Block.BLOCK_SIZE*8,Block.BLOCK_SIZE*i);
        }


        try {
            spielfeld.uebernehme_bloecke(new Form(blocklist1));
            spielfeld.uebernehme_bloecke(new Form(blocklist2));
            spielfeld.uebernehme_bloecke(new Form(blocklist3));
            spielfeld.uebernehme_bloecke(new Form(blocklist4));
            spielfeld.uebernehme_bloecke(new Form(blocklist5));
            spielfeld.uebernehme_bloecke(new Form(blocklist6));
        } catch (Spielfeld.FormOutOfBoundException e) {
            throw new RuntimeException(e);
        }
        HashMap<Block, Diamantblock> diamondBlocks = spielfeld.diamantBlockGenerieren();
        assertEquals(4,diamondBlocks.size());

    }

    @Test
    @Order(6)
    void block_durchfuehren_explodieren() {
        Block[] blocklist1 = new Block[4];
        for (int i = 20; i<23;i++){
            blocklist1[i-20] = new Block(Block.BLOCK_SIZE*7,Block.BLOCK_SIZE*i);
        }
        blocklist1[3] = new ExplosionBlock(Block.BLOCK_SIZE*7,Block.BLOCK_SIZE*23);
        try {
            spielfeld.uebernehme_bloecke(new Form(blocklist1));
        } catch (Spielfeld.FormOutOfBoundException e) {
            throw new RuntimeException(e);
        }
        List<Block> deletedBlockList = spielfeld.block_durchfuehren_explodieren();
        assertEquals(12,deletedBlockList.size());

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
    @Order(7)
    void position_valid() {
        Block[] blocklist1 = new Block[4];
        Block[] blocklist2 = new Block[4];
        Block [] blockList3 = new Block[4];
        Block [] blockList4 = new Block[4];
        Block [] blockList5 = new Block[4];
        Block [] blockList6 = new Block[4];
        Block [] blockList7 = new Block[4];
        for (int i = 0; i<4;i++){
            blocklist1[i] = new Block(Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*i);
        }
        for (int i = 23; i<27;i++){
            blocklist2[i-23] = new Block(Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*i);
        }
        for (int i = -4; i<0;i++){
            blockList3[i+4] = new Block(Block.BLOCK_SIZE*i,Block.BLOCK_SIZE*4);
        }
        for (int i = 10; i<14;i++){
            blockList4[i-10] = new Block(Block.BLOCK_SIZE*i,Block.BLOCK_SIZE*4);
        }
        for (int i = 8; i<12;i++){
            blockList5[i-8] = new Block(Block.BLOCK_SIZE*8,Block.BLOCK_SIZE*i);
        }
        for (int i = 5; i<9;i++){
            blockList6[i-5] = new Block(Block.BLOCK_SIZE*i,Block.BLOCK_SIZE*13);
        }
        for (int i = 13; i<17;i++){
            blockList7[i-13] = new Block(Block.BLOCK_SIZE*5,Block.BLOCK_SIZE*i);
        }
        boolean validpos1 = spielfeld.position_valid(blocklist1);
        boolean validpos2 = spielfeld.position_valid(blocklist2);
        boolean validpos3 = spielfeld.position_valid(blockList3);
        boolean validpos4 = spielfeld.position_valid(blockList4);
        boolean validpos5 = spielfeld.position_valid(blockList5);
        boolean validpos6 = spielfeld.position_valid(blockList6);
        boolean validpos7 = spielfeld.position_valid(blockList7);

        assertFalse(validpos1);
        assertFalse(validpos2);
        assertFalse(validpos3);
        assertFalse(validpos4);
        assertFalse(validpos5);
        assertFalse(validpos6);
        assertTrue(validpos7);


    }

    @Test
    void setze_auf_Boden() {
        Block[] blocklist1 = new Block[4];
        Block[] blocklist2 = new Block[4];
        for (int i = 4; i<8;i++){
            blocklist1[i-4] = new Block(Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*i+10);
        }
        for (int i = 4; i<8;i++){
            blocklist2[i-4] = new Block(Block.BLOCK_SIZE,Block.BLOCK_SIZE*i+10);
        }
        Form form1 = new Form(blocklist1);
        Form form2 = new Form(blocklist2);
        spielfeld.setze_auf_Boden(form1);
        spielfeld.setze_auf_Boden(form2);
        int[] validyPositions1 = {Block.BLOCK_SIZE*8,Block.BLOCK_SIZE*9,Block.BLOCK_SIZE*10,Block.BLOCK_SIZE*11};
        int[] validyPositions2 = {Block.BLOCK_SIZE*20,Block.BLOCK_SIZE*21,Block.BLOCK_SIZE*22,Block.BLOCK_SIZE*23};
        for (int i = 0;i<4;i++){
            Block block = form1.getBlockListe()[i];
            assertEquals(validyPositions1[i],block.getY());
        }
        for (int i = 0;i<4;i++){
            Block block = form2.getBlockListe()[i];
            assertEquals(validyPositions2[i],block.getY());
        }
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