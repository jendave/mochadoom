package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Spider_Mastermind">Spider</a> 
 * @author Joaquin
 *
 */
public class Spider_t extends Monster_t {
  
  public Spider_t() {
    super(  7,        // doomednum
        StateNum.S_SPID_STND,        // spawnstate
        3000,        // spawnhealth
        StateNum.S_SPID_RUN1,        // seestate
        sfxenum_t.sfx_spisit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_shotgn,        // attacksound
        StateNum.S_SPID_PAIN,        // painstate
        40,        // painchance
        sfxenum_t.sfx_dmpain,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_SPID_ATK1,        // missilestate
        StateNum.S_SPID_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_spidth,        // deathsound
        12,        // speed
        128 * FRACUNIT,        // radius
        100 * FRACUNIT,        // height
        1000,        // mass
        0,        // damage
        sfxenum_t.sfx_dmact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_NULL        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_SPIDER";
  }
  
}
