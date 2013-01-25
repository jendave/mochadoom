package net.sourceforge.mochadoom.menu;

import net.sourceforge.mochadoom.doom.DoomStatus;
import net.sourceforge.mochadoom.doom.event_t;
import net.sourceforge.mochadoom.video.IVideoScale;

/**
 * A dummy menu, useful for testers that do need a defined
 * menu object.
 *
 * @author Maes
 */

public class DummyMenu
        extends AbstractDoomMenu {

    @Override
    public void setVideoScale(IVideoScale vs) {
        // TODO Auto-generated method stub

    }

    @Override
    public void initScaling() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean Responder(event_t ev) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void Ticker() {
        // TODO Auto-generated method stub

    }

    @Override
    public void Drawer() {
        // TODO Auto-generated method stub

    }

    @Override
    public void Init() {
        // TODO Auto-generated method stub

    }

    @Override
    public void StartControlPanel() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getShowMessages() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setShowMessages(boolean val) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getScreenBlocks() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setScreenBlocks(int val) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getDetailLevel() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void updateStatus(DoomStatus DS) {
        // TODO Auto-generated method stub

    }

    @Override
    public void ClearMenus() {
        // TODO Auto-generated method stub

    }

}
