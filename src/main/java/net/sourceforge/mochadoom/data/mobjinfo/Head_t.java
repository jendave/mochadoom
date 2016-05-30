package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_FLOAT;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOGRAVITY;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Cacodemon">Head</a> 
 * @author Joaquin
 *
 */
public class Head_t extends Monster_t {
  
  public Head_t() {
    super(3005,        // doomednum
        StateNum.S_HEAD_STND,        // spawnstate
        400,        // spawnhealth
        StateNum.S_HEAD_RUN1,        // seestate
        sfxenum_t.sfx_cacsit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_HEAD_PAIN,        // painstate
        128,        // painchance
        sfxenum_t.sfx_dmpain,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_HEAD_ATK1,        // missilestate
        StateNum.S_HEAD_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_cacdth,        // deathsound
        8,        // speed
        31 * FRACUNIT,        // radius
        56 * FRACUNIT,        // height
        400,        // mass
        0,        // damage
        sfxenum_t.sfx_dmact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_FLOAT | MF_NOGRAVITY | MF_COUNTKILL,        // flags
        StateNum.S_HEAD_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_HEAD";
  }
  
}
