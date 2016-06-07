package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Hell_Knight">Knight</a> 
 * @author Joaquin
 *
 */
public class Knight_t extends Monster_t {
  
  public Knight_t() {
    super( 69,        // doomednum
        StateNum.S_BOS2_STND,        // spawnstate
        500,        // spawnhealth
        StateNum.S_BOS2_RUN1,        // seestate
        sfxenum_t.sfx_kntsit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_BOS2_PAIN,        // painstate
        50,        // painchance
        sfxenum_t.sfx_dmpain,        // painsound
        StateNum.S_BOS2_ATK1,        // meleestate
        StateNum.S_BOS2_ATK1,        // missilestate
        StateNum.S_BOS2_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_kntdth,        // deathsound
        8,        // speed
        24 * FRACUNIT,        // radius
        64 * FRACUNIT,        // height
        1000,        // mass
        0,        // damage
        sfxenum_t.sfx_dmact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_BOS2_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_KNIGHT";
  }
  
}
