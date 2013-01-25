package net.sourceforge.mochadoom.tests;

import java.nio.ByteBuffer;

import net.sourceforge.mochadoom.menu.FixedFloat;

import net.sourceforge.mochadoom.rendering.vertex_t;

import net.sourceforge.mochadoom.data.mapvertex_t;

import net.sourceforge.mochadoom.wad.*;

/** This is a very simple tester for the WadLoader and HU modules.
 *  We use the same exact methods used in the C source code, only
 *  with a more OO approach.
 * 
 * 
 */

public class WadLoaderTester {

    public static void main(String[] argv) {
        try {
    IWadLoader W=new WadLoader();
    W.InitMultipleFiles(new String[] {"doom1.wad"});
    //W.AddFile("bitter.wad");
    System.out.println("Total lumps read: "+W.NumLumps());
    System.out.println("NUm for E1M1: "+W.GetNumForName("E1M1"));
    System.out.println("NUm for SECTORS: "+W.GetNumForName("SECTORS"));
    System.out.println("NUm for SSECTORS: "+W.GetNumForName("SSECTORS"));
   int lump=W.GetNumForName("VERTEXES");
   System.out.println("NUm for VERTEXES: "+W.GetNumForName("VERTEXES"));
    // We prepare a ByteBuffer to receive a "SECTORS" object. Deserializing it is
    // another matter.
    ByteBuffer bb=W.CacheLumpName("SECTORS", 0).getBuffer();
    System.out.println("Num for THINGS: "+W.GetNumForName("THINGS"));
    //DoomStatus ds = new DoomStatus();
    //ds.gameepisode=1;
    //ds.gamemap=1;
    //ds.gamemission=GameMission_t.doom;
    //ds.W=W;
    
    // Testing "Heads Up" clases. Notice how we pass "doomstate" and "WadLoader" as instances,
    // instead of globals. OO all the way, baby!
    
    // Determine number of lumps:
    //  total lump length / vertex record length.
    int numvertexes = W.LumpLength (lump) / mapvertex_t.sizeOf();

    // Allocate zone memory for buffer.
    vertex_t[] vertexes;

    // Load data into cache.
    // MAES: we now have a mismatch between memory/disk: in memory, we need an array.
    // On disk, we have a single lump/blob. Thus, we need to find a way to deserialize this...
    vertexes= W.CacheLumpNumIntoArray(lump,numvertexes,vertex_t.class);

   // Copy and convert vertex coordinates,
    // internal representation as fixed.
    for (int i=0 ; i<numvertexes ; i++)
    {
        //vertexes[i].x = ml[i].x<<FRACBITS;
        //vertexes[i].y = ml[i].y<<FRACBITS;
       System.out.println(vertexes[i].x+" , "+vertexes[i].y+" "+FixedFloat.toDouble(vertexes[i].x)+" , "+FixedFloat.toDouble(vertexes[i].y));
        //System.out.println(ml[i].x+" , "+ml[i].y+" "+FPTest.Value(vertexes[i].x)+" , "+FPTest.Value(vertexes[i].y));
    }

    
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
