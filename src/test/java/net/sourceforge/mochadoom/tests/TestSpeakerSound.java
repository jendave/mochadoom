package net.sourceforge.mochadoom.tests;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

import net.sourceforge.mochadoom.sound.SpeakerSound;

import net.sourceforge.mochadoom.wad.WadLoader;

public class TestSpeakerSound {
    
    
    public static void main(String[] argv) throws Exception {
    WadLoader W=new WadLoader();
    W.InitMultipleFiles(new String[] {"C:\\iwads\\doom1.wad"});

    SpeakerSound sp=(SpeakerSound) W.CacheLumpName("DPSAWUP", 0, SpeakerSound.class);
    
    byte[] stuff=sp.toRawSample();
    
    AudioFormat format = new AudioFormat(11025,8,1,false,true);
    
    DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
    
    SourceDataLine line=null;

    if (AudioSystem.isLineSupported(info))
        try {
            line=  (SourceDataLine) AudioSystem.getSourceDataLine(format);
            line.open(format);
        } catch (Exception e){
            e.printStackTrace();
            System.err.print( "Could not play signed 16 data\n");
        }

        if (line!=null) System.err.print(" configured audio device\n" );
        line.start();
        line.write(stuff, 0,stuff.length);
        line.drain();
    
    Thread.sleep(1000);
    }
}
