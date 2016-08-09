package net.sourceforge.mochadoom.data.mobjinfo;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;

public class Medikit_t extends Misc_t {

  public Medikit_t(int doomednum, StateNum spawnstate, int spawnhealth, StateNum seestate, sfxenum_t seesound,
      int reactiontime, sfxenum_t attacksound, StateNum painstate, int painchance, sfxenum_t painsound,
      StateNum meleestate, StateNum missilestate, StateNum deathstate, StateNum xdeathstate, sfxenum_t deathsound,
      int speed, int radius, int height, int mass, int damage, sfxenum_t activesound, int flags, StateNum raisestate) {
    super(doomednum, spawnstate, spawnhealth, seestate, seesound, reactiontime, attacksound, painstate, painchance,
        painsound, meleestate, missilestate, deathstate, xdeathstate, deathsound, speed, radius, height, mass, damage,
        activesound, flags, raisestate);
  }
  
}
