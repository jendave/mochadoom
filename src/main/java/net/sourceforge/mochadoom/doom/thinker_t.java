package net.sourceforge.mochadoom.doom;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import net.sourceforge.mochadoom.gamelogic.ActionType1;
import net.sourceforge.mochadoom.gamelogic.ActionType2;
import net.sourceforge.mochadoom.gamelogic.ActionTypeSS;
import net.sourceforge.mochadoom.wad.CacheableDoomObject;
import net.sourceforge.mochadoom.wad.IPackableDoomObject;
import net.sourceforge.mochadoom.wad.IReadableDoomObject;

import static net.sourceforge.mochadoom.utils.C2JUtils.pointer;

public class thinker_t implements CacheableDoomObject, IReadableDoomObject, IPackableDoomObject {

    public thinker_t prev;
    public thinker_t next;
    public think_t function;
    // Thinkers can either have one parameter of type (mobj_t),
    // Or otherwise be sector specials, flickering lights etc.
    // Those are atypical and need special handling.
    public ActionType1 acp1;
    public ActionType2 acp2;
    public ActionTypeSS acpss;

    /**
     * extra fields, to use when archiving/unarchiving for
     * identification. Also in blocklinks, etc.
     */
    public int id, previd, nextid, functionid;


    @Override
    public void read(DataInputStream f)
            throws IOException {
        readbuffer.position(0);
        readbuffer.order(ByteOrder.LITTLE_ENDIAN);
        f.read(readbuffer.array());
        unpack(readbuffer);
    }

    /**
     * This adds 12 bytes
     */

    @Override
    public void pack(ByteBuffer b)
            throws IOException {
        // It's possible to reconstruct even by hashcodes.
        // As for the function, that should be implied by the mobj_t type.
        b.order(ByteOrder.LITTLE_ENDIAN);
        b.putInt(pointer(prev));
        b.putInt(pointer(next));
        b.putInt(pointer(function));
        //System.out.printf("Packed thinker %d %d %d\n",pointer(prev),pointer(next),pointer(function));
    }

    @Override
    public void unpack(ByteBuffer b)
            throws IOException {
        // We are supposed to archive pointers to other thinkers,
        // but they are rather useless once on disk.
        b.order(ByteOrder.LITTLE_ENDIAN);
        previd = b.getInt();
        nextid = b.getInt();
        functionid = b.getInt();
        //System.out.printf("Unpacked thinker %d %d %d\n",pointer(previd),pointer(nextid),pointer(functionid));
    }

    private static ByteBuffer readbuffer = ByteBuffer.allocate(12);

}