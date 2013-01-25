package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.menu.DoomRandom;
import net.sourceforge.mochadoom.menu.IRandom;

/** Another microbenchmark. According to this, casting "unsigned bytes" to chars is 
 * faster when performed with a logical function, rather than with arithmetic or
 * direct logical operations. Inlining perhaps? Furthermore, it has almost no penalty 
 * compared to not casting or to use built-in casting. So it's possible to use a
 * "toUnsigned" function of sorts, whenever you need to treat signed bytes as unsigned
 * without expanding them to chars in memory.
 *
 */

public class Unsigned {

    public static void main(String[] argv){
        int TESTS=100000000;
        IRandom r=new DoomRandom();
        
       byte[] values=new byte[TESTS];
       
       for (int i=0;i<TESTS;i++) {
    	   values[i]=(byte)r.P_Random();
       	}
           
       
       byte ub=(byte) 0xFF;
       char us=(char) ub;
       
       System.out.println((int)us);
       
       us= 0xFFFF;
       ub=(byte) us;
       System.out.println(ub);
       System.out.println((int)((char)ub));
       
       System.out.println((int)us);
       long a=System.nanoTime();
        for (int i=0;i<TESTS;i++) {
        us=(char) (0x00FF&values[i]);
    }
    long b=System.nanoTime();
        System.out.println("Time for "+TESTS+" byte to \"unsigned byte\" casts (with logical ops)"+((b-a)/1e09));

        a=System.nanoTime();
        for (int i=0;i<TESTS;i++) {
        us=unsigned(values[i]);
    }
    b=System.nanoTime();
        System.out.println("Time for "+TESTS+" byte to \"unsigned byte\" casts (with num. function) "+((b-a)/1e09));

        a=System.nanoTime();
        for (int i=0;i<TESTS;i++) {
        us=unsigned2(values[i]);
        }
    b=System.nanoTime();
        System.out.println("Time for "+TESTS+" byte to \"unsigned byte\" casts (with log. function)"+((b-a)/1e09));
        
        a=System.nanoTime();
        for (int i=0;i<TESTS;i++) {
        ub=values[i];
        us= (char) ub;
    }
    b=System.nanoTime();
        System.out.println("Time for "+TESTS+" byte to \"unsigned byte\" casts (no casting)"+((b-a)/1e09));
        
}
    public static final char unsigned(byte b){
        return (char) ((b>0)?b:(-b+128));
    }
    
    public static char unsigned2(byte b){
        return (char) (0x00FF&b);
    }
    }
    