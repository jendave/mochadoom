package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.rendering.MultiPatchSynthesizer;
import net.sourceforge.mochadoom.rendering.column_t;

public class TestPatchSynthesis {
    
    public static void main(String[] argv){
        final byte[] crap={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        final boolean[] shit={true,true,true,
                              false, false, false,
                              true, true,true,
                              false,true,false,
                              true,false,true,
                              true};
        
        column_t fuck=MultiPatchSynthesizer.getColumnStream(crap, shit, crap.length);
        
        System.out.println("FUCK" +fuck);
        
        
    }

}
