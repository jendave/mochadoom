package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.wad.*;

/** This is a very simple tester for the WadLoader and HU modules.
 *  We use the same exact methods used in the C source code, only
 *  with a more OO approach.
 * 
 * 
 */

public class WadCoalescerTester {

    public static void main(String[] argv) {
        try {
    WadLoader W=new WadLoader();
    W.InitMultipleFiles(new String[] {"doom1.wad"/*,"sprite2.wad"*/});
    //W.AddFile("bitter.wad");

    //W.CoalesceMarkedResource("F_START", "F_END",li_namespace.ns_flats);
    //W.CoalesceMarkedResource("S_START", "S_END",li_namespace.ns_sprites);
    
    
    System.out.println("Total lumps read: "+W.numlumps);
    
    for (int i=0;i<W.numlumps;i++){
    	System.out.println(W.lumpinfo[i].name+" "+i);
    }
    
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
