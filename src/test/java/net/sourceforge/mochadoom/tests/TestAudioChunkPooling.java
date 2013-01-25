package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.pooling.AudioChunkPool;
import net.sourceforge.mochadoom.sound.AudioChunk;

public class TestAudioChunkPooling {
    public static final int TESTS=10000;
    
    public static void main(String[] argv){
    
    AudioChunk[] chunks=new AudioChunk[TESTS];
    AudioChunkPool chunkpool=new AudioChunkPool();
    
    long a=System.nanoTime();
    
    for (int i=0;i<TESTS;i++){
        chunks[i]=new AudioChunk();
    }

    for (int i=0;i<TESTS;i++){
        chunks[i]=new AudioChunk();
    }
    
    for (int i=0;i<TESTS;i++){
        chunks[i]=new AudioChunk();
    }
    
    for (int i=0;i<TESTS;i++){
        chunks[i]=new AudioChunk();
    }
    long b=System.nanoTime();
    
    System.out.println("Time: "+(float)(b-a)/1000000000f);
    
    a=System.nanoTime();
    
    for (int i=0;i<TESTS;i++){
        chunks[i]=chunkpool.checkOut();
    }

    for (int i=0;i<TESTS;i++){
        chunkpool.checkIn(chunks[i]);
        chunks[i]=chunkpool.checkOut();
    }
    
    for (int i=0;i<TESTS;i++){
        chunkpool.checkIn(chunks[i]);
        chunks[i]=chunkpool.checkOut();
    }
    
    for (int i=0;i<TESTS;i++){
        chunkpool.checkIn(chunks[i]);
        chunks[i]=chunkpool.checkOut();
    }
    b=System.nanoTime();
    
    System.out.println("Time: "+(float)(b-a)/1000000000f);
    
    
    }
    

}
