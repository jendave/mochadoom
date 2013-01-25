package net.sourceforge.mochadoom.tests;

import java.lang.reflect.Method;

import net.sourceforge.mochadoom.wad.WadLoader;

public class TestInvoke {

    /**
     * @param args
     * @throws Exception 

     */
    public static void main(String[] args) throws Exception {
        Method shit=WadLoader.class.getDeclaredMethod("InitFile", String.class);
        Method cunt=WadLoader.class.getDeclaredMethod("LumpLength", int.class);
        Method nothing=WadLoader.class.getDeclaredMethod("Reload",null);
        WadLoader crap=new WadLoader();
        shit.invoke(crap, "~DOOM1.WAD");
        System.out.println(cunt.invoke(crap, 0));
        byte[] ahhh=crap.CacheLumpName("PLAYPAL", 0).getBuffer().array();
        System.out.println(ahhh.length);
        ahhh=crap.CacheLumpName("PLAYPAL", 0).getBuffer().array();
        System.out.println(ahhh.length);
        // This should flush the cache
        nothing.invoke(crap, (Object[])null);
        ahhh=crap.CacheLumpName("PLAYPAL", 0).getBuffer().array();
        System.out.println(ahhh.length);
    }

}
