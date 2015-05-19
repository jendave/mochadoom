package net.sourceforge.mochadoom.boom;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import net.sourceforge.mochadoom.wad.CacheableDoomObject;

/**
 * ZDoom node?
 */

public class MapSegZnod implements CacheableDoomObject {

    public MapSegZnod() {

    }

    public int v1, v2; // Those are unsigned :-/
    public char linedef;
    public byte side;

    public static int sizeOf() {
        return 11;
    }

    @Override
    public void unpack(ByteBuffer buf)
            throws IOException {
        buf.order(ByteOrder.LITTLE_ENDIAN);
        this.v1 = buf.getInt();
        this.v2 = buf.getInt();
        this.linedef = buf.getChar();
        this.side = buf.get();
    }

};
