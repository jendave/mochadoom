package net.sourceforge.mochadoom.data.mobjinfo;

import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_DROPOFF;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_MISSILE;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOBLOCKMAP;
import static net.sourceforge.mochadoom.gamelogic.mobj_t.MF_NOGRAVITY;
import static net.sourceforge.mochadoom.menu.fixed_t.FRACUNIT;
import net.sourceforge.mochadoom.data.mobjinfo_t;
import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;
import net.sourceforge.mochadoom.rendering.LightsAndColors;

public class AlternatePlasma_t extends mobjinfo_t {

	public AlternatePlasma_t() {
		super(       // MT_PLASMA
				-1,        // doomednum
				StateNum.S_PLASBALL3,        // spawnstate
				1000,        // spawnhealth
				StateNum.S_NULL,        // seestate
				sfxenum_t.sfx_plasma,        // seesound
				8,        // reactiontime
				sfxenum_t.sfx_None,        // attacksound
				StateNum.S_NULL,        // painstate
				0,        // painchance
				sfxenum_t.sfx_None,        // painsound
				StateNum.S_NULL,        // meleestate
				StateNum.S_NULL,        // missilestate
				StateNum.S_PLASEXP,        // deathstate
				StateNum.S_NULL,        // xdeathstate
				sfxenum_t.sfx_firxpl,        // deathsound
				25 * FRACUNIT,        // speed
				13 * FRACUNIT,        // radius
				8 * FRACUNIT,        // height
				100,        // mass
				5,        // damage
				sfxenum_t.sfx_None,        // activesound
				MF_NOBLOCKMAP | MF_MISSILE | MF_DROPOFF | MF_NOGRAVITY,        // flags
				StateNum.S_NULL        // raisestate
				);

	}


	@Override
	public String getsubType(){
		return "MT_ALTERNATEPLASMA";
	}

}
