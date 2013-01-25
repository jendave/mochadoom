package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.rendering.patch_t;

import net.sourceforge.mochadoom.wad.*;

/** A tester for loading patches off cached memory and directly from disk,
 *  proving how direct WAD access is possible, too.
 *  Will need to implement reading column pixel data and dumping it into a file somewhat...
 * 
 */

public class DiskPatchReader {

    public static void main(String[] argv) throws Exception {
    WadLoader W=new WadLoader();
    W.InitMultipleFiles(new String[] {"C:\\iwads\\doom1.wad"});
    System.out.println("Total lumps read: "+W.numlumps);
   
    System.out.println("Num for WALL00_1: "+W.GetNumForName("WALL00_1"));
    // We prepare a ByteBuffer to receive a "SECTORS" object. Deserializing it is
    // another matter.
    //ByteBuffer bb=W.CacheLumpName("WALL00_1", 0);
    //

    patch_t wall= W.CachePatchName("WALL00_1");
    lumpinfo_t lump= W.GetLumpinfoForName("WALL00_1");
    System.out.println(lump.name);
    System.out.println(lump.position);
    System.out.println(lump.size);
    
    // Now open Doom1.wad standalone...
    //DoomFile f=new DoomFile("doom1.wad","r");
    //patch_t wall1=new patch_t();
    //f.seek(lump.position);
    //wall1.read(f);
    //System.out.println(wall1.height);
    
    System.out.println("Num for HELP1: "+W.GetNumForName("HELP1"));
    //bb=W.CacheLumpName("HELP1", 0);
    patch_t stbar= W.CachePatchName("HELP1");
    System.out.println(stbar.height);
    System.out.println(stbar.width);
    stbar=(patch_t)W.CacheLumpName("HELP1", 0,stbar.getClass());
        }
    
}
