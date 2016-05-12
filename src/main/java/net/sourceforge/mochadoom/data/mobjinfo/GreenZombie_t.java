package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds;
import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;

public class GreenZombie_t extends Zombie_t {

  public GreenZombie_t() {
    super(3004,StateNum.S_POSS_STND,20,StateNum.S_POSS_RUN1,
        sfxenum_t.sfx_posit1,8,sfxenum_t.sfx_pistol,StateNum.S_POSS_PAIN
        ,200,sfxenum_t.sfx_popain,StateNum.S_NULL,StateNum.S_NULL,
        StateNum.S_POSS_DIE1,StateNum.S_POSS_XDIE1,sfxenum_t.sfx_podth1,
        10,20 * FRACUNIT,56 * FRACUNIT,100,0,sfxenum_t.sfx_posact,
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
  
  @Override
  public String getsubType(){
    return "MT_GREENZOMBIE";
  }
}
