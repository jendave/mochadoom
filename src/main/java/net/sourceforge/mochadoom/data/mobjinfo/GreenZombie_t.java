package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOGRAVITY;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_JUSTHIT;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
import net.sourceforge.mochadoom.rendering.LightsAndColors;

public class GreenZombie_t extends Zombie_t {

  public GreenZombie_t() {
    super(3004,StateNum.S_POSS_STND,20,StateNum.S_POSS_RUN1,
        sfxenum_t.sfx_posit1,8,sfxenum_t.sfx_pistol,StateNum.S_POSS_PAIN
        ,200,sfxenum_t.sfx_popain,StateNum.S_NULL,StateNum.S_NULL,
        StateNum.S_POSS_DIE1,StateNum.S_POSS_XDIE1,sfxenum_t.sfx_podth1,
        10,20 * FRACUNIT,56 * FRACUNIT,100,0,sfxenum_t.sfx_posact,
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL | MF_NOGRAVITY | MF_JUSTHIT,StateNum.S_POSS_RAISE1);
  }

  public GreenZombie_t(int doomednum2, StateNum spawnstate2, int spawnhealth2, StateNum seestate2, sfxenum_t seesound2,
      int reactiontime2, sfxenum_t attacksound2, StateNum painstate2, int painchance2, sfxenum_t painsound2,
      StateNum meleestate2, StateNum missilestate2, StateNum deathstate2, StateNum xdeathstate2, sfxenum_t deathsound2,
      int speed2, int radius2, int height2, int mass2, int damage2, sfxenum_t activesound2, int flags2,
      StateNum raisestate2) {
    super(doomednum2, spawnstate2, spawnhealth2, seestate2, seesound2, reactiontime2, attacksound2, painstate2, painchance2,
        painsound2, meleestate2, missilestate2, deathstate2, xdeathstate2, deathsound2, speed2, radius2, height2, mass2, damage2,
        activesound2, flags2, raisestate2);
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
  public short[] colormap = null;
  protected final static short GREENCOLOR = 256; 
  
  @Override
  public String getsubType(){
    return "MT_GREENZOMBIE";
  }
  
  public <V> V getColorMap(LightsAndColors<V> colormaps){
    if(this.colormap == null){
      this.colormap = new short[256];
      for(int i=0; i < 256; i++){
        colormap[i] = (short) ((GREENCOLOR*0.2 + 0.8*((short[]) colormaps.colormaps[colormaps.colormaps.length - 5])[i]));
      }
    }
    return (V) colormap;
  }
}
