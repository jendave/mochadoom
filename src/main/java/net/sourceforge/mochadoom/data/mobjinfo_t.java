package net.sourceforge.mochadoom.data;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
import net.sourceforge.mochadoom.rendering.LightsAndColors;

public class mobjinfo_t {
    
    public mobjinfo_t(int doomednum, StateNum spawnstate, int spawnhealth,
                      StateNum seestate, sfxenum_t seesound, int reactiontime,
                      sfxenum_t attacksound, StateNum painstate,
                      int painchance, sfxenum_t painsound,
                      StateNum meleestate, StateNum missilestate,
                      StateNum deathstate, StateNum xdeathstate,
                      sfxenum_t deathsound, int speed, int radius, int height,
                      int mass, int damage, sfxenum_t activesound, int flags,
                      StateNum raisestate) {
        this.doomednum = doomednum;
        this.spawnstate = spawnstate;
        this.spawnhealth = spawnhealth;
        this.seestate = seestate;
        this.seesound = seesound;
        this.reactiontime = reactiontime;
        this.attacksound = attacksound;
        this.painstate = painstate;
        this.painchance = painchance;
        this.painsound = painsound;
        this.meleestate = meleestate;
        this.missilestate = missilestate;
        this.deathstate = deathstate;
        this.xdeathstate = xdeathstate;
        this.deathsound = deathsound;
        this.speed = speed;
        this.radius = radius;
        this.height = height;
        this.mass = mass;
        this.damage = damage;
        this.activesound = activesound;
        this.flags = flags;
        this.raisestate = raisestate;
    }

    public int doomednum;
    public StateNum spawnstate;
    public int spawnhealth;
    public StateNum seestate;
    public sfxenum_t seesound;
    public int reactiontime;
    public sfxenum_t attacksound;
    public StateNum painstate;
    public int painchance;
    public sfxenum_t painsound;
    public StateNum meleestate;
    public StateNum missilestate;
    public StateNum deathstate;
    public StateNum xdeathstate;
    public sfxenum_t deathsound;
    public int speed;
    public int radius;
    public int height;
    public int mass;
    public int damage;
    public sfxenum_t activesound;
    public int flags;
    public StateNum raisestate;
    /**
     * Used to get specific type of object.
     * @return String with name of class object.
     */
    public String getsubType(){
      return "";
    }
    /**
     * getType, returns mobjtype_t of object.
     * @return string with type of object.
     */
    public String getType(){
      return "mobjinfo_t";
    }
    public <V> V getColorMap(LightsAndColors<V> colormaps){
      return colormaps.colormaps[colormaps.colormaps.length - 1];
    }
}
