package net.sourceforge.mochadoom.tests;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import net.sourceforge.mochadoom.wad.*;

/** DUMPS a WAD's LUMPS to disk. Any questions?! 
 * 
 */

public class WadDumper {

    public static void main(String[] argv) {
        try {
    IWadLoader W=new WadLoader();
    W.InitMultipleFiles(argv);
    BufferedOutputStream bos;
    
    int numlumps=W.NumLumps();
    
    for (int i=0;i<numlumps;i++){
        byte[] crap=W.ReadLump(i);
        String name=W.GetNameForLump(i);
        File f=new File(String.format("%s.lmp",name));
        bos=new BufferedOutputStream(new FileOutputStream(f));
        bos.write(crap);
        bos.close();        
        }

    
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
