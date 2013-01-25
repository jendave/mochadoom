package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.rendering.patch_t;

import net.sourceforge.mochadoom.wad.*;

/** This is a very simple tester for the WadLoader and HU modules.
 *  We use the same exact methods used in the C source code, only
 *  with a more OO approach.
 * 
 * 
 */

public class PatchLoaderTester {

    public static void main(String[] argv) {
        try {
    WadLoader W=new WadLoader();
    W.InitMultipleFiles(new String[] {"doom1.wad"});
    
    patch_t wall=W.CachePatchName("BAL1d0");
    System.out.println(wall.leftoffset);
    
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
