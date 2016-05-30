package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_COUNTKILL;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SHOOTABLE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_SOLID;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
/**
 * more info in this site: <a href="http://doom.wikia.com/wiki/Shotgun_guy">ShotGuy</a> 
 * @author Joaquin
 *
 */
public class ShotGuy_t extends Monster_t {
  
  public ShotGuy_t() {
    super(9,        // doomednum
        StateNum.S_SPOS_STND,        // spawnstate
        30,        // spawnhealth
        StateNum.S_SPOS_RUN1,        // seestate
        sfxenum_t.sfx_posit2,        // seesound
        8,        // reactiontime
        sfxenum_t.sfx_shotgn,        // attacksound MAES: Weird, this was 0 :-S
        StateNum.S_SPOS_PAIN,        // painstate
        170,        // painchance
        sfxenum_t.sfx_popain,        // painsound
        StateNum.S_NULL,        // meleestate
        StateNum.S_SPOS_ATK1,        // missilestate
        StateNum.S_SPOS_DIE1,        // deathstate
        StateNum.S_SPOS_XDIE1,        // xdeathstate
        sfxenum_t.sfx_podth2,        // deathsound
        8,        // speed
        20 * FRACUNIT,        // radius
        56 * FRACUNIT,        // height
        100,        // mass
        0,        // damage
        sfxenum_t.sfx_posact,        // activesound
        MF_SOLID | MF_SHOOTABLE | MF_COUNTKILL,        // flags
        StateNum.S_SPOS_RAISE1        // raisestate
        );
  }
  
  @Override
  public String getsubType(){
    return "MT_SHOTGUY";
  }
  
}
