package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
import net.sourceforge.mochadoom.rendering.LightsAndColors;

public class RedZombie_t extends Zombie_t {
  
  public RedZombie_t() {
    super(3004,StateNum.S_POSS_STND,20,StateNum.S_POSS_RUN1,
        sfxenum_t.sfx_posit1,8,sfxenum_t.sfx_pistol,StateNum.S_POSS_PAIN
        ,200,sfxenum_t.sfx_popain,StateNum.S_NULL,StateNum.S_NULL,
        StateNum.S_POSS_DIE1,StateNum.S_POSS_XDIE1,sfxenum_t.sfx_podth1,
        30,20 * FRACUNIT,56 * FRACUNIT,100,0,sfxenum_t.sfx_posact,
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,StateNum.S_POSS_RAISE1);
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
  public short[] colormap;
  protected final static short REDCOLOR = -2983; 
  
  @Override
  public String getsubType(){
    return "MT_REDZOMBIE";
  }
  
  public <V> V getColorMap(LightsAndColors<V> colormaps){
    if(this.colormap == null){
      for(int i=0; i < 256; i++){
        colormap[i] = (short) ((REDCOLOR*999 + ((short[]) colormaps.colormaps[colormaps.colormaps.length - 20])[i])/1000);
      }
    }
    return (V) colormap;
  }
}
