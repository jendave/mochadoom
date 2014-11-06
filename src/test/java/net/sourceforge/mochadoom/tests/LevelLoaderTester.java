package net.sourceforge.mochadoom.tests;

import net.sourceforge.mochadoom.defines.GameMission;
import net.sourceforge.mochadoom.defines.Skill;
import net.sourceforge.mochadoom.doom.DoomMain;
import net.sourceforge.mochadoom.doom.DoomStatus;
import net.sourceforge.mochadoom.gamelogic.LevelLoader;
import net.sourceforge.mochadoom.rendering.SimpleTextureManager;
import net.sourceforge.mochadoom.rendering.TextureManager;
import net.sourceforge.mochadoom.sound.DummySoundDriver;
import net.sourceforge.mochadoom.sound.IDoomSound;
import net.sourceforge.mochadoom.wad.WadLoader;

/** This is a very simple tester for the WadLoader and HU modules.
 *  We use the same exact methods used in the C source code, only
 *  with a more OO approach.
 * 
 * 
 */

public class LevelLoaderTester {

    public static void main(String[] argv) {
        try {
    WadLoader W=new WadLoader();
    W.InitMultipleFiles(new String[] {"C:\\DOOMS\\doom1.wad"});
    //W.AddFile("bitter.wad");
    System.out.println("Total lumps read: "+W.numlumps);
    System.out.println("NUm for E1M1: "+W.GetNumForName("E1M1"));
    DoomStatus DS = new DoomMain.Indexed();
    DS.gameepisode=1;
    DS.gamemap=1;
    DS.gamemission= GameMission.doom;
    //DS.gamemode=GameMode.shareware;
    IDoomSound S=new DummySoundDriver();            
    DS.S=S;
    DS.W=W;
    LevelLoader LL=new LevelLoader(DS);
    DS.LL=LL;
    TextureManager TM=new SimpleTextureManager(DS);
    DS.TM=TM;
    LL.updateStatus(DS);
    TM.InitFlats();
    TM.InitTextures();
    
    //HU hu=new HU(DS);
    //hu.Init();
    
    LL.SetupLevel(1, 1, 0, Skill.sk_hard);
    
    
    
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
