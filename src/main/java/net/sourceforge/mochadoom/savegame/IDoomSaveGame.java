package net.sourceforge.mochadoom.savegame;

import net.sourceforge.mochadoom.system.DoomStatusAware;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import net.sourceforge.mochadoom.gamelogic.ThinkerList;

public interface IDoomSaveGame extends DoomStatusAware {
    void setThinkerList(ThinkerList li);

    boolean doLoad(DataInputStream f);

    IDoomSaveGameHeader getHeader();

    void setHeader(IDoomSaveGameHeader header);

    boolean doSave(DataOutputStream f);
}
