package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Arachnotron">Baby</a> 
 * @author Joaquin
 *
 */
public class Baby_t extends Monster_t {
  
  public Baby_t() {
    super( 68,        // doomednum
        StateNum.S_BSPI_STND,        // spawnstate
        500,        // spawnhealth
        StateNum.S_BSPI_SIGHT,        // seestate
        sfxenum_t.sfx_bspsit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_BSPI_PAIN,        // painstate
        128,        // painchance
        sfxenum_t.sfx_dmpain,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_BSPI_ATK1,        // missilestate
        StateNum.S_BSPI_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_bspdth,        // deathsound
        12,        // speed
        64 * FRACUNIT,        // radius
        64 * FRACUNIT,        // height
        600,        // mass
        0,        // damage
        sfxenum_t.sfx_bspact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_BSPI_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_BABY";
  }
  
}
