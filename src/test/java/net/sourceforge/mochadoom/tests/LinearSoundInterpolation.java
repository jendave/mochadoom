package net.sourceforge.mochadoom.tests;

import java.io.File;
import java.io.FileOutputStream;

import net.sourceforge.mochadoom.sound.DMXSound;
import net.sourceforge.mochadoom.sound.DSP;
import net.sourceforge.mochadoom.wad.WadLoader;

public class LinearSoundInterpolation {
    
    public static void main(String[] argv) throws Exception{

        
        WadLoader W=new WadLoader();
        W.InitMultipleFiles(new String[]{"c:\\iwads\\doom1.wad"});
        
        int sfxlump = W.GetNumForName("dspistol");
        
        DMXSound dmx= W.CacheLumpNum(sfxlump, 0, DMXSound.class);
        
        File out=new File("original.raw");
        FileOutputStream fos=new FileOutputStream(out);
        fos.write(dmx.data);
        fos.close();
        
        fos=new FileOutputStream("linear.raw");
        
        // KRUDE
        if (dmx.speed==11025){
             //Plain linear interpolation.
            dmx.data=DSP.crudeResample(dmx.data,2);
            //DSP.filter(dmx.data,SAMPLERATE, SAMPLERATE/4);
            dmx.datasize=dmx.data.length;            
        }
        
        fos.write(dmx.data);
        fos.close();
        
            }
    
}
