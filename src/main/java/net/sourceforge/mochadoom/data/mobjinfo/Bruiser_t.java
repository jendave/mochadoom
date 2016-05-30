package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Baron_of_Hell">Bruiser</a> 
 * @author Joaquin
 *
 */
public class Bruiser_t extends Monster_t {
  
  public Bruiser_t() {
    super(3003,        // doomednum
        StateNum.S_BOSS_STND,        // spawnstate
        1000,        // spawnhealth
        StateNum.S_BOSS_RUN1,        // seestate
        sfxenum_t.sfx_brssit,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_None,        // attacksound
        StateNum.S_BOSS_PAIN,        // painstate
        50,        // painchance
        sfxenum_t.sfx_dmpain,        // painsound
        StateNum.S_BOSS_ATK1,        // meleestate
        StateNum.S_BOSS_ATK1,        // missilestate
        StateNum.S_BOSS_DIE1,        // deathstate
        StateNum.S_NULL,        // xdeathstate
        sfxenum_t.sfx_brsdth,        // deathsound
        8,        // speed
        24 * FRACUNIT,        // radius
        64 * FRACUNIT,        // height
        1000,        // mass
        0,        // damage
        sfxenum_t.sfx_dmact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_BOSS_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType() {
    return "MT_BRUISER";
  }
  
}
