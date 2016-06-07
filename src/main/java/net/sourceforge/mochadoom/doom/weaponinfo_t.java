package net.sourceforge.mochadoom.doom;

import net.sourceforge.mochadoom.defines.StateNum;
import net.sourceforge.mochadoom.defines.AmmoType;

//
// PSPRITE ACTIONS for waepons.
// This struct controls the weapon animations.
//
// Each entry is:
//   ammo/amunition type
//  upstate
//  downstate
// readystate
// atkstate, i.e. attack/fire/hit frame
// flashstate, muzzle flash
//

public class weaponinfo_t {

    /*    
    public weaponinfo_t(AmmoType ammo, int upstate, int downstate,
            int readystate, int atkstate, int flashstate) {
        super();
        this.ammo = ammo;
        this.upstate = upstate;
        this.downstate = downstate;
        this.readystate = readystate;
        this.atkstate = atkstate;
        this.atkaltern = atkaltern;
        this.flashstate = flashstate;
    }*/
    public AmmoType ammo;


    public weaponinfo_t(AmmoType ammo, StateNum upstate,
                        StateNum downstate, StateNum readystate,
                        StateNum atkstate, StateNum atkaltern,
                        StateNum flashstate) {
        super();
        this.ammo = ammo;
        this.upstate = upstate;
        this.downstate = downstate;
        this.readystate = readystate;
        this.atkstate = atkstate;
        this.atkaltern = atkaltern;
        this.flashstate = flashstate;
    }

    public StateNum upstate;
    public StateNum downstate;
    public StateNum readystate;
    public StateNum atkstate;
    public StateNum atkaltern;
    public StateNum flashstate;


    /*
    public int     upstate;
    public int     downstate;
    public int     readystate;
    public int     atkstate;
    public int     flashstate;
    */

}
