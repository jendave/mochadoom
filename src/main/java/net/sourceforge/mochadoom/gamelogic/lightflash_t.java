package net.sourceforge.mochadoom.gamelogic;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import net.sourceforge.mochadoom.menu.IRandom;
import net.sourceforge.mochadoom.rendering.SectorAction;
import net.sourceforge.mochadoom.wad.DoomIO;

//
// BROKEN LIGHT EFFECT
//

public class lightflash_t extends SectorAction {

    private IRandom RND;

    public int count;
    public int maxlight;
    public int minlight;
    public int maxtime;
    public int mintime;

    public lightflash_t() {

    }

    public lightflash_t(IRandom RND) {
        this.RND = RND;
    }

    /**
     * T_LightFlash
     * Do flashing lights.
     */

    public void LightFlash() {
        if (--count != 0)
            return;

        if (sector.lightlevel == maxlight) {
            sector.lightlevel = (short) minlight;
            count = (RND.P_Random() & mintime) + 1;
        } else {
            sector.lightlevel = (short) maxlight;
            count = (RND.P_Random() & maxtime) + 1;
        }

    }

    @Override
    public void read(DataInputStream f) throws IOException {

        super.read(f); // Call thinker reader first            
        super.sectorid = DoomIO.readLEInt(f); // Sector index
        count = DoomIO.readLEInt(f);
        maxlight = DoomIO.readLEInt(f);
        minlight = DoomIO.readLEInt(f);
        maxtime = DoomIO.readLEInt(f);
        mintime = DoomIO.readLEInt(f);
    }

    @Override
    public void pack(ByteBuffer b) throws IOException {
        super.pack(b); //12            
        b.putInt(super.sectorid); // 16
        b.putInt(count); //20
        b.putInt(maxlight);//24
        b.putInt(minlight);//28
        b.putInt(maxtime);//32
        b.putInt(mintime);//36
    }

}