package net.sourceforge.mochadoom.savegame;

import net.sourceforge.mochadoom.defines.Skill;


/**
 * A Save Game Header should be able to be loaded quickly and return
 * some basic info about it (name, version, game time, etc.) in an unified
 * manner, no matter what actual format you use for saving.
 *
 * @author admin
 */

public interface IDoomSaveGameHeader {

    String getName();

    void setName(String name);

    Skill getGameskill();

    void setGameskill(Skill gameskill);

    String getVersion();

    void setVersion(String vcheck);

    int getGameepisode();

    void setGameepisode(int gameepisode);

    boolean isProperend();

    void setWrongversion(boolean wrongversion);

    boolean isWrongversion();

    void setLeveltime(int leveltime);

    int getLeveltime();

    void setPlayeringame(boolean[] playeringame);

    boolean[] getPlayeringame();

    void setGamemap(int gamemap);

    int getGamemap();

}
