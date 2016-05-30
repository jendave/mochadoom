package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="doom.wikia.com/wiki/Mancubus">Fatso</a> 
 * @author Joaquin
 *
 */
public class Fatso_t extends Monster_t {
  
  public Fatso_t() {
    super( 67,        // doomednum
        StateNum.S_FATT_STND,        // spawnstate
        600,        // spawnhealth
        StateNum.S_FATT_RUN1,        // seestate
        sfxenum_t.sfx_mansit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_FATT_PAIN,        // painstate
        80,        // painchance
        sfxenum_t.sfx_mnpain,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_FATT_ATK1,        // missilestate
        StateNum.S_FATT_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_mandth,        // deathsound
        8,        // speed
        48 * FRACUNIT,        // radius
        64 * FRACUNIT,        // height
        1000,        // mass
        0,        // damage
        sfxenum_t.sfx_posact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_FATT_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_FATSO";
  }
  
}
