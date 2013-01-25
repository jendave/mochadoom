package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.doom.DoomMain;
import net.sourceforge.mochadoom.doom.DoomStatus;
import net.sourceforge.mochadoom.menu.DoomRandom;
import net.sourceforge.mochadoom.menu.IRandom;
import net.sourceforge.mochadoom.sound.ClipSFXModule;
import net.sourceforge.mochadoom.wad.WadLoader;

public class TestClipSound {
	public static void main(String[] argv) throws Exception{

	DoomStatus DS=new DoomMain.Indexed();
	
	
	WadLoader W=new WadLoader();
	IRandom RND=new DoomRandom();
	
	DS.W=W;
	DS.RND=RND;
	W.InitMultipleFiles(new String[]{"doom1.wad"});
	
	ClipSFXModule sound=new ClipSFXModule(DS,4);
	
	sound.InitSound();
	sound.SetChannels(4);
	
	Thread.sleep(1000);
	//sound.StartSound(1, 127, 127, 127, 0);
	for (int i=0;i<1000;i++){
	    
	    Thread.sleep(1000/35);

	    if (i%70==0) sound.StartSound(sfxenum_t.sfx_plpain.ordinal(), 127, 127, 127, 0);
	    if (i%90==0) sound.StartSound(sfxenum_t.sfx_barexp.ordinal(), 127, 0, 127, 0);
	    if (i%35==0) sound.StartSound(sfxenum_t.sfx_plpain.ordinal(), 127, 255, 127, 0);
	    if (i%35==0) sound.StartSound(sfxenum_t.sfx_oof.ordinal(), 127, 192, 127, 0);
	    sound.UpdateSound();
	    
	    sound.SubmitSound();
	    
	       System.out.println(DS.gametic++);
	}
	sound.ShutdownSound();
	}
	
}
