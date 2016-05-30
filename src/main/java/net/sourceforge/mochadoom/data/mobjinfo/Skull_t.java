package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_FLOAT;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOGRAVITY;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Lost_soul">Skull</a> 
 * @author Joaquin
 *
 */
public class Skull_t extends Monster_t {
  
  public Skull_t() {
    super(3006,        // doomednum
        StateNum.S_SKULL_STND,        // spawnstate
        100,        // spawnhealth
        StateNum.S_SKULL_RUN1,        // seestate
        sfxenum_t.sfx_None,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_sklatk,        // attacksound
        StateNum.S_SKULL_PAIN,        // painstate
        256,        // painchance
        sfxenum_t.sfx_dmpain,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_SKULL_ATK1,        // missilestate
        StateNum.S_SKULL_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_firxpl,        // deathsound
        8,        // speed
        16 * FRACUNIT,        // radius
        56 * FRACUNIT,        // height
        50,        // mass
        3,        // damage
        sfxenum_t.sfx_dmact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_FLOAT | MF_NOGRAVITY,        // flags
        StateNum.S_NULL        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_SKULL";
  }
  
}
