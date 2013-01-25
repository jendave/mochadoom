package net.sourceforge.mochadoom.tests;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

public class PaletteShower {

    public static final int BLOCKSIZE=16;
    public static final int SHIFT=0;
    
    public static void main(String[] argv) {
        try {
    BufferedInputStream bis;
    bis=new BufferedInputStream(new FileInputStream(argv[0]));
    
    int size=bis.available();
    
    int blocks=size/768;
    
    
    byte[] palbuf=new byte[768];
    
    for (int i=0;i<blocks;i++){
        bis.read(palbuf);
        BufferedImage bim=new BufferedImage(16*BLOCKSIZE,16*BLOCKSIZE,BufferedImage.TYPE_INT_ARGB);
        
            /*
             * for (int j=0;j<256;j++){
            int color=  0xFF000000|(palbuf[j]<<(16+SHIFT))|
                        (palbuf[j]<<(8+SHIFT))|
                        (palbuf[j]<<SHIFT); 
                        }
                        */
            for (int j=0;j<256;j++){
                int colo=  0xFF000000|(0xFF0000&palbuf[j*3]<<(16+SHIFT))|
                            (0xFF00&palbuf[1+j*3]<<(8+SHIFT))|
                            (0xFF&palbuf[2+j*3]<<SHIFT);
            
            for (int x=0;x<BLOCKSIZE;x++){
                for (int y=0;y<BLOCKSIZE;y++){
                    bim.setRGB(BLOCKSIZE*(j%16)+x, BLOCKSIZE*(j/16)+y, colo);
                }
            }
            
        }
        
        FileOutputStream f=new FileOutputStream(String.format("%s-%d.PNG",argv[0],i));
        
        ImageIO.write(bim,"PNG",f);
        }
    
        bis.close();
    
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
