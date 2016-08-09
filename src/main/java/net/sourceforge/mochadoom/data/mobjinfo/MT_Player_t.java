package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_DROPOFF;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOTDMATCH;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_PICKUP;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.mobjinfo_t;
import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;

public class MT_Player_t extends mobjinfo_t{

  public MT_Player_t() {
    super( -1,
        StateNum.S_PLAY,        
        100,      
        StateNum.S_PLAY_RUN1,     
        sfxenum_t.sfx_None,       
        0,       
        sfxenum_t.sfx_None,       
        StateNum.S_PLAY_PAIN,     
        255,       
        sfxenum_t.sfx_plpain,        
        StateNum.S_NULL,        
        StateNum.S_PLAY_ATK1,      
        StateNum.S_PLAY_DIE1,        
        StateNum.S_PLAY_XDIE1,       
        sfxenum_t.sfx_pldeth,       
        0,       
        16 * FRACUNIT,        
        56 * FRACUNIT,        
        100,       
        0,        
        sfxenum_t.sfx_None,       
        MF_SOLID | MF_SHOOTABLE | MF_DROPOFF | MF_PICKUP | MF_NOTDMATCH,       
        StateNum.S_NULL);
  }
  
  public int doomednum;
  public StateNum spawnstate;
  public int spawnhealth;
  public StateNum seestate;
  public sfxenum_t seesound;
  public int reactiontime;
  public sfxenum_t attacksound;
  public StateNum painstate;
  public int painchance;
  public sfxenum_t painsound;
  public StateNum meleestate;
  public StateNum missilestate;
  public StateNum deathstate;
  public StateNum xdeathstate;
  public sfxenum_t deathsound;
  public int speed;
  public int radius;
  public int height;
  public int mass;
  public int damage;
  public sfxenum_t activesound;
  public int flags;
  public StateNum raisestate;
  
  @Override
  public String getsubType(){
    return "MT_PLAYER";
  }
  
  @Override
  public String getType(){
    return "MT_ZOMBIE";
  }
}
