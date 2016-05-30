package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOGRAVITY;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SPAWNCEILING;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Commander_Keen">Commander Keen</a> 
 * @author Joaquin
 *
 */
public class CommanderKeen_t extends Monster_t {
  
  public CommanderKeen_t() {
    super(72,        // doomednum
        StateNum.S_KEENSTND,        // spawnstate
        100,        // spawnhealth
        StateNum.S_NULL,        // seestate
        sfxenum_t.sfx_None,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_KEENPAIN,        // painstate
        256,        // painchance
        sfxenum_t.sfx_keenpn,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_NULL,        // missilestate
        StateNum.S_COMMKEEN,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_keendt,        // deathsound
        0,        // speed
        16 * FRACUNIT,        // radius
        72 * FRACUNIT,        // height
        10000000,        // mass
        0,        // damage
        sfxenum_t.sfx_None,        // activesound
        MF_SOLID | MF_SPAWNCEILING | MF_NOGRAVITY | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_NULL        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_KEEN";
  }
  
}
