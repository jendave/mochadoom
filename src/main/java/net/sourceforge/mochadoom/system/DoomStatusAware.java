package net.sourceforge.mochadoom.system;

import net.sourceforge.mochadoom.doom.DoomStatus;

public interface DoomStatusAware {
    public void updateStatus(DoomStatus<?, ?> DC);
}
