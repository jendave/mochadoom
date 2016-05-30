package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Boss_Brain">Boss Brain</a> 
 * @author Joaquin
 *
 */
public class BossBrain_t extends Monster_t {
  
  public BossBrain_t() {
    super(88,        // doomednum
        StateNum.S_BRAIN,        // spawnstate
        250,        // spawnhealth
        StateNum.S_NULL,        // seestate
        sfxenum_t.sfx_None,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_BRAIN_PAIN,        // painstate
        255,        // painchance
        sfxenum_t.sfx_bospn,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_NULL,        // missilestate
        StateNum.S_BRAIN_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_bosdth,        // deathsound
        0,        // speed
        16 * FRACUNIT,        // radius
        16 * FRACUNIT,        // height
        10000000,        // mass
        0,        // damage
        sfxenum_t.sfx_None,        // activesound
        MF_SOLID | MF_SHOOTABLE,        // flags
        StateNum.S_NULL        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_BOSSBRAIN";
  }
  
}
