package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.doom.think_t;
import net.sourceforge.mochadoom.rendering.SectorAction;
import net.sourceforge.mochadoom.rendering.line_t;
import net.sourceforge.mochadoom.rendering.sector_t;

public class slidedoor_t extends SectorAction {
    sdt_e type;
    line_t line;
    int frame;
    int whichDoorIndex;
    int timer;
    sector_t frontsector;
    sector_t backsector;
    sd_e status;

    public slidedoor_t() {
        type = sdt_e.sdt_closeOnly;
        status = sd_e.sd_closing;
        function = think_t.T_SlidingDoor;
    }

}