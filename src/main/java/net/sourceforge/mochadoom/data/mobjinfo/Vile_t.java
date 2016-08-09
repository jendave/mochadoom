package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Arch-Vile">Vile</a> 
 * @author Joaquin
 *
 */
public class Vile_t extends Monster_t {
  
  public Vile_t() {
    super( 64,        // doomednum
        StateNum.S_VILE_STND,        // spawnstate
        700,        // spawnhealth
        StateNum.S_VILE_RUN1,        // seestate
        sfxenum_t.sfx_vilsit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_VILE_PAIN,        // painstate
        10,        // painchance
        sfxenum_t.sfx_vipain,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_VILE_ATK1,        // missilestate
        StateNum.S_VILE_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_vildth,        // deathsound
        15,        // speed
        20 * FRACUNIT,        // radius
        56 * FRACUNIT,        // height
        500,        // mass
        0,        // damage
        sfxenum_t.sfx_vilact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_NULL        // raisestate
       );
  }
  
  @Override
  public String getsubType() {
    return "MT_VILE";
  }
  
}
