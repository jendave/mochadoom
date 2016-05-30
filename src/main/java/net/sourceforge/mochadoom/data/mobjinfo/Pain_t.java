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
 * more info in this site: <a href="http://doom.wikia.com/wiki/Pain_elemental">Pain</a> 
 * @author Joaquin
 *
 */
public class Pain_t extends Monster_t {
  
  public Pain_t() {
    super(71,        // doomednum
        StateNum.S_PAIN_STND,        // spawnstate
        400,        // spawnhealth
        StateNum.S_PAIN_RUN1,        // seestate
        sfxenum_t.sfx_pesit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_PAIN_PAIN,        // painstate
        128,        // painchance
        sfxenum_t.sfx_pepain,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_PAIN_ATK1,        // missilestate
        StateNum.S_PAIN_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_pedth,        // deathsound
        8,        // speed
        31 * FRACUNIT,        // radius
        56 * FRACUNIT,        // height
        400,        // mass
        0,        // damage
        sfxenum_t.sfx_dmact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_FLOAT | MF_NOGRAVITY | MF_COUNTKILL,        // flags
        StateNum.S_PAIN_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_PAIN";
  }
  
}
