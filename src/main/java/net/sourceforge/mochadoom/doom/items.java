package net.sourceforge.mochadoom.doom;
// Emacs style mode select   -*- C++ -*- 
//-----------------------------------------------------------------------------
//
// $Id: items.java,v 1.3 2010/12/20 17:15:08 velktron Exp $
//
// Copyright (C) 1993-1996 by id Software, Inc.
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// as published by the Free Software Foundation; either version 2
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// $Log: items.java,v $
// Revision 1.3  2010/12/20 17:15:08  velktron
// Made the renderer more OO -> TextureManager and other changes as well.
//
// Revision 1.2  2010/08/19 23:14:49  velktron
// Automap
//
// Revision 1.1  2010/06/30 08:58:50  velktron
// Let's see if this stuff will finally commit....
//
//
// Most stuff is still  being worked on. For a good place to start and get an idea of what is being done, I suggest checking out the "testers" package.
//
// Revision 1.1  2010/06/29 11:07:34  velktron
// Release often, release early they say...
//
// Commiting ALL stuff done so far. A lot of stuff is still broken/incomplete, and there's still mixed C code in there. I suggest you load everything up in Eclpise and see what gives from there.
//
// A good place to start is the testers/ directory, where you  can get an idea of how a few of the implemented stuff works.
//
//
// DESCRIPTION:
//
//-----------------------------------------------------------------------------

import net.sourceforge.mochadoom.defines.AmmoType;
import net.sourceforge.mochadoom.defines.StateNum;

public class items {

    public static weaponinfo_t[] weaponinfo =
            {
                    new weaponinfo_t(
                            // fist
                            AmmoType.am_noammo,
                            StateNum.S_PUNCHUP,
                            StateNum.S_PUNCHDOWN,
                            StateNum.S_PUNCH,
                            StateNum.S_PUNCH1,
                            StateNum.S_PUNCH6,
                            StateNum.S_NULL
                    ),
                    new weaponinfo_t(
                            // pistol
                    		// Code.102
                    		// Se agrego StateNum.S_PISTOL5 para asignar el disparo secundario
                    		// Intercambiar en los demas weaponinfo por los nuevos StateNum
                            AmmoType.am_clip,
                            StateNum.S_PISTOLUP,
                            StateNum.S_PISTOLDOWN,
                            StateNum.S_PISTOL,
                            StateNum.S_PISTOL1,
                            StateNum.S_PISTOL5,
                            StateNum.S_PISTOLFLASH

                    ), new weaponinfo_t(
                    // shotgun
                    AmmoType.am_shell,
                    StateNum.S_SGUNUP,
                    StateNum.S_SGUNDOWN,
                    StateNum.S_SGUN,
                    StateNum.S_SGUN1,
                    StateNum.S_EXAMPLE1,
                    StateNum.S_SGUNFLASH1
            ),
                    new weaponinfo_t(
                            // chaingun
                            AmmoType.am_clip,
                            StateNum.S_CHAINUP,
                            StateNum.S_CHAINDOWN,
                            StateNum.S_CHAIN,
                            StateNum.S_CHAIN1,
                            StateNum.S_CHAIN4,
                            StateNum.S_CHAINFLASH1
                    ),
                    new weaponinfo_t(
                            // missile launcher
                            AmmoType.am_misl,
                            StateNum.S_MISSILEUP,
                            StateNum.S_MISSILEDOWN,
                            StateNum.S_MISSILE,
                            StateNum.S_MISSILE1,
                            StateNum.S_MISSILE4,
                            StateNum.S_MISSILEFLASH1
                    ),
                    new weaponinfo_t(
                            // plasma rifle
                            AmmoType.am_cell,
                            StateNum.S_PLASMAUP,
                            StateNum.S_PLASMADOWN,
                            StateNum.S_PLASMA,
                            StateNum.S_PLASMA1,
                            StateNum.S_PLASMA1,
                            StateNum.S_PLASMAFLASH1
                    ),
                    new weaponinfo_t(
                            // bfg 9000
                            AmmoType.am_cell,
                            StateNum.S_BFGUP,
                            StateNum.S_BFGDOWN,
                            StateNum.S_BFG,
                            StateNum.S_BFG1,
                            StateNum.S_BFG5,
                            StateNum.S_BFGFLASH1
                    ),
                    new weaponinfo_t(
                            // chainsaw
                            AmmoType.am_noammo,
                            StateNum.S_SAWUP,
                            StateNum.S_SAWDOWN,
                            StateNum.S_SAW,
                            StateNum.S_SAW1,
                            StateNum.S_SAW1,
                            StateNum.S_NULL
                    ),
                    new weaponinfo_t(
                            // super shotgun
                            AmmoType.am_shell,
                            StateNum.S_DSGUNUP,
                            StateNum.S_DSGUNDOWN,
                            StateNum.S_DSGUN,
                            StateNum.S_DSGUN1,
                            StateNum.S_DSGUN1,
                            StateNum.S_DSGUNFLASH1
                    )
            };
}








