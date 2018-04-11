/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageoperations;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author maxkim
 */
public class ImageDisplayer extends JFrame {
    private ImageIcon imageIcon1, imageIcon2;
    private JLabel label1, label2;
  
    ImageDisplayer() {
        setLayout(new FlowLayout());
    }
    
    public void display2Images(String fileName1, String fileName2) {
        BufferedImage bi1 = null, bi2 = null;
        
        try {
            bi1 = ImageIO.read(new File("lena_gray.gif"));
            bi2 = ImageIO.read(new File("128.gif"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        imageIcon1 = new ImageIcon(bi1);
        imageIcon2 = new ImageIcon(bi2);
        
        label1 = new JLabel(imageIcon1);
        label2 = new JLabel(imageIcon2);

        add(label1);
        add(label2);
        
        ImageDisplayer gui = new ImageDisplayer();
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("2 images");
    }
}
