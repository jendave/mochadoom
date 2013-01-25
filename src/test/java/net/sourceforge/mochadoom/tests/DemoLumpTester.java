package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.demo.VanillaDoomDemo;
import net.sourceforge.mochadoom.wad.*;

public class DemoLumpTester {

    public static void main(String[] argv) {

    WadLoader W=new WadLoader();
    try {
		W.InitMultipleFiles(new String[] {"C://DOOMS/e1m1.wad"});
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    //W.AddFile("bitter.wad");
    System.out.println("Total lumps read: "+W.numlumps);
    System.out.println("NUm for DEMO1: "+W.GetNumForName("DEMO1"));
    VanillaDoomDemo demo=(VanillaDoomDemo) W.CacheLumpName("DEMO1",0,VanillaDoomDemo.class);
    System.out.println(demo);
    
    }
    
}
