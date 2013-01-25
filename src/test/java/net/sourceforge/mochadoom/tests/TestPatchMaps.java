package net.sourceforge.mochadoom.tests;

import java.util.HashMap;

import net.sourceforge.mochadoom.pooling.RoguePatchMap;

public class TestPatchMaps {
    public static final int TESTS=2000000;
    public static final int SET=30;
    public static final int REPS=50;
    static byte[][][] stuff=new byte[SET][1][1];
    static byte[][][] stuff2=new byte[TESTS][][];
	// A normal hashmap....
	static HashMap<Integer,byte[][]> map1= new HashMap<Integer,byte[][]> ();
	
	// And a NEW and ENHANCED implementation.
	static RoguePatchMap map2=new RoguePatchMap();
	
    public static void main(String[] argv){
    
    	for (int i=0;i<REPS;i++){
    		System.out.printf("Put %d in Hashmap: %d\n",TESTS,testPutHashmap());
    	}

    	for (int i=0;i<REPS;i++){
    		System.out.printf("Put %d in Patchmap: %d\n",TESTS,testPutPatchmap());
    	}

    	
    	for (int i=0;i<REPS;i++){
    		System.out.printf("Get %d from Hashmap: %d\n",TESTS,testGetHashmap());
    	}

    	for (int i=0;i<REPS;i++){
    		System.out.printf("Get %d from Patchmap: %d\n",TESTS,testGetPatchmap());
    	}

    	
    }
    
    private static long testPutHashmap(){
    	
    	long a=System.nanoTime();
    	for (int i=0;i<TESTS;i++){
    		map1.put(i%SET, stuff[i%SET]);
    	}
    	long b=System.nanoTime();
    	
    	return (b-a);
    }
    
    private static long testGetHashmap(){
    	
    	long a=System.nanoTime();
    	for (int i=0;i<TESTS;i++){
    		stuff2[i]=map1.get(i%SET);
    	}
    	long b=System.nanoTime();
    	
    	return (b-a);
    }
    
    private static long testPutPatchmap(){
    	
    	long a=System.nanoTime();
    	for (int i=0;i<TESTS;i++){
    		map2.put(i%SET, stuff[i%SET]);
    	}
    	long b=System.nanoTime();
    	
    	return (b-a);
    }
    
    private static long testGetPatchmap(){
    	
    	long a=System.nanoTime();
    	for (int i=0;i<TESTS;i++){
    		stuff2[i]=map2.get(i%SET);
    	}
    	long b=System.nanoTime();
    	
    	return (b-a);
    }
}
