package net.sourceforge.mochadoom.menu;

import java.util.Random;

// Emacs style mode select   -*- C++ -*- 
//-----------------------------------------------------------------------------
//
// $Id: JavaRandom.java,v 1.2 2011/07/27 20:47:46 velktron Exp $
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
//
// DESCRIPTION:
//	Random number LUT using java.util.Random
// Don't expect vanilla demo compatibility with THIS!
//
//-----------------------------------------------------------------------------

public class JavaRandom implements IRandom {

    protected int rndindex = 0;
    protected int prndindex = 0;

    // Which one is deterministic?
    public int P_Random() {
        rndindex++;
        return (0xFF & r.nextInt());

    }

    public int M_Random() {
        prndindex++;
        return (0xFF & m.nextInt());
    }

    public void ClearRandom() {
        rndindex = prndindex = 0;
        r.setSeed(666);
    }

    public JavaRandom() {
        r = new Random(666);
        m = new Random(666);
        this.ClearRandom();
    }

    public int getIndex() {
        return rndindex;
    }

    private Random r;
    private Random m;

}


//$Log: JavaRandom.java,v $
//Revision 1.2  2011/07/27 20:47:46  velktron
//Proper commenting, cleanup.
//
//Revision 1.1  2011/05/29 22:15:32  velktron
//Introduced IRandom interface.

