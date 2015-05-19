package net.sourceforge.mochadoom.boom;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import net.sourceforge.mochadoom.utils.C2JUtils;
import net.sourceforge.mochadoom.wad.CacheableDoomObject;

public class DeepBSPNodesV4 implements CacheableDoomObject {

    public static final byte[] DeepBSPHeader = {
            'x', 'N', 'd', '4', 0, 0, 0, 0
    };

    byte[] header = new byte[8];
    MapNodeV4[] nodes;
    int numnodes;

    public boolean formatOK() {
        return Arrays.equals(header, DeepBSPHeader);
    }

    public MapNodeV4[] getNodes() {
        return nodes;
    }

    @Override
    public void unpack(ByteBuffer buf) throws IOException {
        int length = buf.capacity();

        // Too short, not even header.
        if (length < 8) return;

        numnodes = (length - 8) / MapNodeV4.sizeOf();

        if (length < 1) return;

        buf.get(header); // read header

        nodes = C2JUtils.createArrayOfObjects(MapNodeV4.class, length);

        for (int i = 0; i < length; i++) {
            nodes[i].unpack(buf);
        }

    }


}
