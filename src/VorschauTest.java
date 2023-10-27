/**
 * Projekt: Java-Praktikum-P4-Tetris
 * Autor: Lukas Hammer
 * Erstelldatum: 27.10.2023
 */

import javax.swing.*;
import java.awt.*;



class VorschauTest extends JFrame {

    private static Vorschau vorschau;
    private JPanel contentPane;

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    VorschauTest frame = new VorschauTest();
                    frame.setVisible(true);


                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    public VorschauTest(){
        setBounds(0,0,16*Block.BLOCK_SIZE +Block.BLOCK_SIZE,
                20*Block.BLOCK_SIZE + Block.BLOCK_SIZE);
        vorschau = new Vorschau();
        Form form = new Form(new Form(Form.DEFAULT_BLOCKS), Color.BLACK);
        vorschau.setPunktzahl("1");
        vorschau.vorschau_anzeigen(form);
        vorschau.setVisible(true);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
        contentPane.add(vorschau);


    }


}