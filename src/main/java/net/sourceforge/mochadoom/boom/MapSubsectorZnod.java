package net.sourceforge.mochadoom.boom;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import net.sourceforge.mochadoom.utils.C2JUtils;
import net.sourceforge.mochadoom.wad.CacheableDoomObject;

public class MapSubsectorZnod implements CacheableDoomObject {

    public long numsegs;

    @Override
    public void unpack(ByteBuffer buf)
            throws IOException {
        buf.order(ByteOrder.LITTLE_ENDIAN);
        this.numsegs = C2JUtils.unsigned(buf.getInt());
    }

    public static final int sizeOf() {
        return 4;
    }

}
