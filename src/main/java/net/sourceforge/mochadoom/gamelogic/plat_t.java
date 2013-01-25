package net.sourceforge.mochadoom.gamelogic;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import net.sourceforge.mochadoom.rendering.SectorAction;
import net.sourceforge.mochadoom.rendering.sector_t;
import net.sourceforge.mochadoom.wad.DoomIO;
import net.sourceforge.mochadoom.wad.IReadableDoomObject;

public class plat_t extends SectorAction implements IReadableDoomObject {

    public sector_t sector;
    /**
     * fixed_t
     */
    public int speed, low, high;
    int wait;
    int count;
    public plat_e status;
    public plat_e oldstatus;
    boolean crush;
    public int tag;
    public plattype_e type;

    public plat_t() {
        // These must never be null so they get the lowest ordinal value.
        // by default.
        this.status = plat_e.up;
        this.oldstatus = plat_e.up;
    }

    @Override
    public void read(DataInputStream f) throws IOException {

        super.read(f); // Call thinker reader first
        super.sectorid = DoomIO.readLEInt(f); // Sector index
        speed = DoomIO.readLEInt(f);
        low = DoomIO.readLEInt(f);
        high = DoomIO.readLEInt(f);
        wait = DoomIO.readLEInt(f);
        count = DoomIO.readLEInt(f);
        status = plat_e.values()[DoomIO.readLEInt(f)];
        oldstatus = plat_e.values()[DoomIO.readLEInt(f)];
        System.out.println(status);
        System.out.println(oldstatus);
        crush = DoomIO.readIntBoolean(f);
        tag = DoomIO.readLEInt(f);
        type = plattype_e.values()[DoomIO.readLEInt(f)];
    }

    @Override
    public void pack(ByteBuffer b) throws IOException {
        super.pack(b); //12
        b.putInt(super.sectorid); // 16
        b.putInt(speed);//20
        b.putInt(low); // 24
        b.putInt(high); //28
        b.putInt(wait); //32
        b.putInt(count); //36
        b.putInt(status.ordinal()); //40
        b.putInt(oldstatus.ordinal()); //44
        System.out.println(status);
        System.out.println(oldstatus);
        b.putInt(crush ? 1 : 0); // 48
        b.putInt(tag); // 52
        b.putInt(type.ordinal()); // 56
    }

}