package net.sourceforge.mochadoom.data.mobjinfo;

import net.sourceforge.mochadoom.data.mobjinfo_t;
import net.sourceforge.mochadoom.data.sounds;
import net.sourceforge.mochadoom.defines.StateNum;
import net.sourceforge.mochadoom.rendering.LightsAndColors;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_DROPOFF;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_MISSILE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOBLOCKMAP;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;

/**
 * Created by nicolasjara on 04-08-16.
 */
public class Flare_t extends mobjinfo_t {

    private int counter;
    public short[] colormap;
    //protected final static short REDCOLOR = -2983;
    protected final static short REDCOLOR = -2050;

    public Flare_t() {
        super(        // MT_PLASMA
                -1,        // doomednum
                StateNum.S_PLASBALL,        // spawnstate
                1000,        // spawnhealth
                StateNum.S_NULL,        // seestate
                sounds.sfxenum_t.sfx_plasma,        // seesound
                8,        // reactiontime
                sounds.sfxenum_t.sfx_None,        // attacksound
                StateNum.S_NULL,        // painstate
                0,        // painchance
                sounds.sfxenum_t.sfx_None,        // painsound
                StateNum.S_NULL,        // meleestate
                StateNum.S_NULL,        // missilestate
                StateNum.S_PLASEXP,        // deathstate
                StateNum.S_NULL,        // xdeathstate
                sounds.sfxenum_t.sfx_firxpl,        // deathsound
                25 * FRACUNIT,        // speed
                13 * FRACUNIT,        // radius
                8 * FRACUNIT,        // height
                100,        // mass
                0,        // damage
                sounds.sfxenum_t.sfx_None,        // activesound
                MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF,        // flags
                StateNum.S_NULL        // raisestate
        );
        counter = 0;

    }

    public int getCounter() {
        return counter;
    }

    public void addCounter() {
        counter++;
    }

    public <V> V getColorMap(LightsAndColors<V> colormaps) {
        if (this.colormap == null) {
            this.colormap = new short[256];
            for (int i = 0; i < 256; i++) {
                colormap[i] = (short) ((REDCOLOR * 999 + ((short[]) colormaps.colormaps[colormaps.colormaps.length - 20])[i]) / 1000);
            }
        }
        return (V) colormap;
    }
    @Override
    public String getsubType(){
        return "MT_FLARE";
    }
}
