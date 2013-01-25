package net.sourceforge.mochadoom.wad;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * filelumps are on-disk structures. lumpinfos are almost the same, but are memory only.
 *
 * @author Maes
 */

public class filelump_t implements IReadableDoomObject {
    long filepos;
    long size; // Is INT 32-bit in file!
    String name;

    public void read(DataInputStream f) throws IOException {
        // MAES: Byte Buffers actually make it convenient changing byte order on-the-fly.
        // But RandomAccessFiles don't :-S

        filepos = DoomIO.readUnsignedLEInt(f);
        size = DoomIO.readUnsignedLEInt(f);
        // Names used in the reading subsystem should be upper case.
        name = DoomIO.readNullTerminatedString(f, 8).toUpperCase();
    }

    public static int sizeof() {
        return (4 + 4 + 8);
    }

}
