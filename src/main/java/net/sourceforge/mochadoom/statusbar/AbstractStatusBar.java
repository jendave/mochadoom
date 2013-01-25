package net.sourceforge.mochadoom.statusbar;

import net.sourceforge.mochadoom.doom.DoomMain;
import net.sourceforge.mochadoom.doom.DoomStatus;
import net.sourceforge.mochadoom.system.DoomVideoInterface;
import net.sourceforge.mochadoom.system.IDoomSystem;
import net.sourceforge.mochadoom.menu.IRandom;
import net.sourceforge.mochadoom.rendering.Renderer;
import net.sourceforge.mochadoom.sound.IDoomSound;
import net.sourceforge.mochadoom.video.DoomVideoRenderer;
import net.sourceforge.mochadoom.video.IVideoScaleAware;
import net.sourceforge.mochadoom.wad.IWadLoader;

public abstract class AbstractStatusBar implements IDoomStatusBar, IVideoScaleAware {

    // /// STATUS //////////

    protected DoomVideoRenderer<?, ?> V;

    protected IWadLoader W;

    protected Renderer<?, ?> R;

    protected DoomMain<?, ?> DM;

    protected IRandom RND;

    protected IDoomSystem I;

    protected DoomVideoInterface<?> VI;

    protected IDoomSound S;

    @Override
    public void updateStatus(DoomStatus<?, ?> DC) {
        this.DM = DC.DM;
        this.V = DC.V;
        this.W = DC.W;
        this.RND = DC.RND;
        this.R = DC.R;
        this.VI = DC.VI;
        this.I = DC.I;
        this.S = DC.S;
    }

}
