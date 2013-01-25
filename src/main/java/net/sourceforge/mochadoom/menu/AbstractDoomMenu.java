package net.sourceforge.mochadoom.menu;

import net.sourceforge.mochadoom.doom.DoomStatus;
import net.sourceforge.mochadoom.doom.IDoomGame;
import net.sourceforge.mochadoom.hud.HU;
import net.sourceforge.mochadoom.system.IDoomSystem;
import net.sourceforge.mochadoom.rendering.RendererState;
import net.sourceforge.mochadoom.sound.IDoomSound;
import net.sourceforge.mochadoom.timing.ITicker;
import net.sourceforge.mochadoom.video.DoomVideoRenderer;
import net.sourceforge.mochadoom.wad.IWadLoader;

public abstract class AbstractDoomMenu
        implements IDoomMenu {

    ////////////////////// CONTEXT ///////////////////

    DoomStatus DM;
    IDoomGame DG;
    IWadLoader W;
    DoomVideoRenderer V;
    HU HU;
    RendererState R;
    IDoomSystem I;
    IDoomSound S;
    ITicker TICK;

    @Override
    public void updateStatus(DoomStatus DS) {
        this.DM = DS.DM;
        this.DG = DS.DG;
        this.V = DM.V;
        this.W = DM.W;
        this.HU = DM.HU;
        this.I = DM.I;
        this.S = DM.S;
        this.R = (RendererState) DM.R;
        this.TICK = DM.TICK;

    }

}
