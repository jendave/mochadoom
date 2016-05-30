package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHADOW;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Spectre">Shadows</a> 
 * @author Joaquin
 *
 */
public class Shadows_t extends Monster_t {
  
  public Shadows_t() {
    super(58,        // doomednum
        StateNum.S_SARG_STND,        // spawnstate
        150,        // spawnhealth
        StateNum.S_SARG_RUN1,        // seestate
        sfxenum_t.sfx_sgtsit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_sgtatk,        // attacksound
        StateNum.S_SARG_PAIN,        // painstate
        180,        // painchance
        sfxenum_t.sfx_dmpain,        // painsound
        StateNum.S_SARG_ATK1,        // meleestate
        StateNum.S_NULL,        // missilestate
        StateNum.S_SARG_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_sgtdth,        // deathsound
        10,        // speed
        30 * FRACUNIT,        // radius
        56 * FRACUNIT,        // height
        400,        // mass
        0,        // damage
        sfxenum_t.sfx_dmact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_SHADOW | MF_COUNTKILL,        // flags
        StateNum.S_SARG_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_SHADOWS";
  }
  
}
