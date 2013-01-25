package net.sourceforge.mochadoom.tests;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.imageio.ImageIO;

public class PaletteShower12 {

    public static final int BLOCKSIZE=16;
    public static final int SHIFT=4;
    
    public static void main(String[] argv) {
        try {
    BufferedInputStream bis;
    bis=new BufferedInputStream(new FileInputStream(argv[0]));
    
    int size=bis.available();
    
    int blocks=size/512;
    
    
    byte[] palbuf=new byte[512];
    ByteBuffer bb= ByteBuffer.wrap(palbuf);
    bb.order(ByteOrder.LITTLE_ENDIAN);
    bb.mark();
    for (int i=0;i<blocks;i++){
        bis.read(palbuf);
        
        BufferedImage bim=new BufferedImage(16*BLOCKSIZE,16*BLOCKSIZE,BufferedImage.TYPE_INT_ARGB);
        
            for (int j=0;j<256;j++){
                short shcol=bb.getShort();
                int r=(0xF000&shcol)>>12;
                int g=(0xF00&shcol)>>8;
                int b=(0xF0&shcol)>>4;
                System.out.printf("%x %d %d %d\n",shcol,r,g,b);
                int colo=  0xFF000000|(r<<(16+SHIFT))|
                            (g<<(8+SHIFT))|
                            (b<<SHIFT);
            
            for (int x=0;x<BLOCKSIZE;x++){
                for (int y=0;y<BLOCKSIZE;y++){
                    bim.setRGB(BLOCKSIZE*(j%16)+x, BLOCKSIZE*(j/16)+y, colo);
                }
            }
            
        }
        
        FileOutputStream f=new FileOutputStream(String.format("%s-%d.PNG",argv[0],i));
        
        ImageIO.write(bim,"PNG",f);
        bb.reset();
        }
    
        bis.close();
    
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
