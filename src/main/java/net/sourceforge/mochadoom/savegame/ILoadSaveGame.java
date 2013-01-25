package net.sourceforge.mochadoom.savegame;

import net.sourceforge.mochadoom.gamelogic.ThinkerList;

public interface ILoadSaveGame {
    void setThinkerList(ThinkerList li);

    void doSave(ThinkerList li);

    void doLoad(ThinkerList li);
}
