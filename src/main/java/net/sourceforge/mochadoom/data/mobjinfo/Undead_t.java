package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Revenant">Undead</a> 
 * @author Joaquin
 *
 */
public class Undead_t extends Monster_t {
  
  public Undead_t() {
    super(  66,        // doomednum
        StateNum.S_SKEL_STND,        // spawnstate
        300,        // spawnhealth
        StateNum.S_SKEL_RUN1,        // seestate
        sfxenum_t.sfx_skesit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_SKEL_PAIN,        // painstate
        100,        // painchance
        sfxenum_t.sfx_popain,        // painsound
        StateNum.S_SKEL_FIST1,        // meleestate
        StateNum.S_SKEL_MISS1,        // missilestate
        StateNum.S_SKEL_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_skedth,        // deathsound
        10,        // speed
        20 * FRACUNIT,        // radius
        56 * FRACUNIT,        // height
        500,        // mass
        0,        // damage
        sfxenum_t.sfx_skeact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_SKEL_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_UNDEAD";
  }
  
}
