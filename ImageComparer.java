/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagecomparer;

/**
 * Can be used.
 *
 * @author NNAMDI
 */
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageComparer {

    /**
     * @param args the command line arguments
     */
    
    public static float compareImage(File fileA, File fileB) {

    float percentage = 0;
    try {
        // take buffer data from both image files //
        BufferedImage biA = ImageIO.read(fileA);
        DataBuffer dbA = biA.getData().getDataBuffer();
        int sizeA = dbA.getSize();
        BufferedImage biB = ImageIO.read(fileB);
        DataBuffer dbB = biB.getData().getDataBuffer();
        int sizeB = dbB.getSize();
        int count = 0;
        // compare data-buffer objects //
        if (sizeA == sizeB) {

            for (int i = 0; i < sizeA; i++) {

                if (dbA.getElem(i) == dbB.getElem(i)) {
                    count = count + 1;
                }

            }
            percentage = (count * 100) / sizeA;
        } else {
            System.out.println("Both the images are not of same size");
        }

    } catch (Exception e) {
        System.out.println("Failed to compare image files ...");
    }
    return percentage;
}
    public static void main(String[] args) {
        // TODO code application logic here
        File f = new File("C:/Users/NNAMDI/Documents/Youcam/g.jpg");
        File f2 = new File("C:/Users/NNAMDI/Documents/Youcam/h.jpg");
       float op = compareImage(f, f2);
       System.out.println("Hey Wil, here is the percentage of similarity: "+op+" %. Confirm from Inemesit via Henry.");
    }
    
}
